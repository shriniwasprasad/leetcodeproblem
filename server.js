const express = require('express');
const fs = require('fs');
const path = require('path');
const app = express();
const port = 3000;

const PROBLEMS_ROOT = path.resolve('src/main/java/org/example/problems');

function parseJavaFile(filePath) {
    const content = fs.readFileSync(filePath, 'utf8');
    const docMatch = content.match(/\/\*\*([\s\S]*?)\*\//);
    if (!docMatch) return null;

    const doc = docMatch[1];
    const extract = (regex) => {
        const match = doc.match(regex);
        if (!match) return '';
        // Remove leading asterisks and whitespace from each line
        return match[1].trim().replace(/^[\s\*]+/gm, '').trim();
    };

    const title = extract(/Problem: (.*)/);

    // Extract Description
    const description = extract(/Problem Description:\s*([\s\S]*?)(?=Hint|Example|Constraints|Video|LeetCode|$)/);

    // Extract Hint
    const hint = extract(/Hint:\s*([\s\S]*?)(?=Example|Constraints|Video|LeetCode|$)/);

    // Extract Examples
    const examples = extract(/Example 1:\s*([\s\S]*?)(?=Example \d+:|Constraints|Video|LeetCode|$)/) || extract(/Example:\s*([\s\S]*?)(?=Example \d+:|Constraints|Video|LeetCode|$)/);

    const leetcode = extract(/LeetCode Problem Link: (.*)/);
    const video = extract(/Video Explanation: (.*)/);
    const codeMatch = content.substring(content.indexOf('*/') + 2).trim();

    return {
        title,
        description: description.trim(),
        hint: hint.trim(),
        examples: examples.trim(),
        leetcode,
        video,
        solution: codeMatch
    };
}

app.get('/api/problems', (req, res) => {
    const section = req.query.section || 'string';
    const sectionPath = path.join(PROBLEMS_ROOT, section);
    if (!fs.existsSync(sectionPath)) return res.status(404).json({ error: 'Section not found' });

    const result = { easy: [], medium: [], hard: [] };
    const difficulties = ['easy', 'medium', 'hard'];
    difficulties.forEach(diff => {
        const diffPath = path.join(sectionPath, diff);
        if (fs.existsSync(diffPath)) {
    const files = fs.readdirSync(diffPath).filter(f => f.endsWith('.java'));
    files.forEach(file => {
        const data = parseJavaFile(path.join(diffPath, file));
        if (data) {
            data.filePath = path.join(diffPath, file).replace(/\\/g, '/');
            result[diff].push(data);
        }
    });
        }
    });
    res.json(result);
});

app.get('/api/file', (req, res) => {
    const filePath = req.query.path;
    if (!filePath) return res.status(400).send('Path is required');

    // Security check: ensure path is within PROBLEMS_ROOT
    const absolutePath = path.resolve(filePath);
    if (!absolutePath.startsWith(PROBLEMS_ROOT)) {
        return res.status(403).send('Forbidden');
    }

    try {
        const content = fs.readFileSync(absolutePath, 'utf8');
        res.send(content);
    } catch (e) {
        res.status(404).send('File not found');
    }
});

app.use(express.static('.'));
app.listen(port, () => {
    console.log(`LeetCode Explorer running at http://localhost:${port}`);
});
