package org.example.problems.tree.hard;

import java.util.*;

/**
 * Problem: Word Search II
 * Topic: Tree (Trie), Backtracking
 * Level: Hard
 *
 * Problem Description:
 * Given an m x n grid of characters board and a string words dictionary of different words,
 * return all the words on the board.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchIi {

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode current = root;
            for (char c : w.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.word = w;
        }

        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private static void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;

        char ch = board[r][c];
        TrieNode nextNode = node.children.get(ch);
        if (nextNode == null) return;

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // Avoid duplicate entries
        }

        board[r][c] = '#'; // Mark as visited

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            dfs(board, r + dr[i], c + dc[i], nextNode, result);
        }

        board[r][c] = ch; // Backtrack
    }

    public static void main(String[] args) {
        System.out.println("=== WordSearchIi ===");
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','a','m'},
            {'i','i','i','d'}
        };
        String[] words = {"oath","pea","eat","rain"};

        List<String> result = findWords(board, words);
        System.out.println("Found words: " + result); // Expected: [oath, eat]
    }

    public static Object solution(Object input) {
        return null;
    }

    public static Object alternativeSolution(Object input) {
        return null;
    }
}
