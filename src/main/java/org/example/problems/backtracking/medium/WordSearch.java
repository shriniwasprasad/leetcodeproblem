package org.example.problems.backtracking.medium;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Word Search
 * Topic: Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public static void main(String[] args) {
        System.out.println("=== WordSearch ===");
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println("Board: " + Arrays.deepToString(board));
        System.out.println("Word: " + word);
        System.out.println("Result: " + solution(board, word));
        System.out.println("Alternative Result: " + alternativeSolution(board, word));
    }

    public static boolean solution(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = backtrack(board, word, r + 1, c, index + 1) ||
                        backtrack(board, word, r - 1, c, index + 1) ||
                        backtrack(board, word, r, c + 1, index + 1) ||
                        backtrack(board, word, r, c - 1, index + 1);
        board[r][c] = temp;
        return found;
    }

    public static boolean alternativeSolution(char[][] board, String word) {
        // Word Search is purely stateful (marking visited cells),
        // so a Stream-based approach would just be wrapping the loops.
        return IntStream.range(0, board.length).boxed()
            .flatMap(r -> IntStream.range(0, board[0].length).boxed()
                .filter(c -> backtrack(board, word, r, c, 0))
                .map(c -> true))
            .findFirst()
            .orElse(false);
    }
}
