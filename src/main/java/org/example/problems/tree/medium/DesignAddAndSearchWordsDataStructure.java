package org.example.problems.tree.medium;

/**
 * Problem: Design Add And Search Words Data Structure
 * Topic: Tries
 * Level: Medium
 *
 * Problem Description:
 * Design a data structure that supports adding new words and searching for a word where a dot '.' can be a wildcard.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class DesignAddAndSearchWordsDataStructure {

    public static class WordDictionary {
        private class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEndOfWord = false;
        }

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            return searchInNode(word, 0, root);
        }

        private boolean searchInNode(String word, int index, TrieNode node) {
            if (node == null) return false;
            if (index == word.length()) return node.isEndOfWord;

            char c = word.charAt(index);
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (searchInNode(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                return searchInNode(word, index + 1, node.children[c - 'a']);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DesignAddAndSearchWordsDataStructure ===");
        WordDictionary wordDict = new WordDictionary();
        wordDict.addWord("bad");
        wordDict.addWord("dad");
        wordDict.addWord("mad");

        System.out.println("Search 'pad': " + wordDict.search("pad")); // false
        System.out.println("Search 'bad': " + wordDict.search("bad")); // true
        System.out.println("Search '.ad': " + wordDict.search(".ad")); // true
        System.out.println("Search 'b..': " + wordDict.search("b..")); // true
    }

    public static Object solution(Object input) {
        return new WordDictionary();
    }

    public static Object alternativeSolution(Object input) {
        return new WordDictionary();
    }
}
