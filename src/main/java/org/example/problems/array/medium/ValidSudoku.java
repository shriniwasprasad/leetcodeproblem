package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Valid Sudoku
 * Topic: Arrays & Hashing
 * Level: Medium
 *
 * Problem Description:
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated
 * according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition
 * 2. Each column must contain the digits 1-9 without repetition
 * 3. Each of the 9 3x3 sub-boxes must contain the digits 1-9 without repetition
 *
 * Input: char[][] board - 9x9 Sudoku board ( '.' represents empty cells)
 * Output: boolean = true if valid
 *
 * Video Explanation: https://www.youtube.com/watch?v=q2fl7lUkc8o
 * LeetCode Problem Link: https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println("=== ValidSudoku ===");

        // Test Case 1 - Valid Sudoku
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Input: Valid Sudoku board");
        System.out.println("Output: " + solution(board1));
        System.out.println();

        // Test Case 2 - Invalid Sudoku (row repetition)
        char[][] board2 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Input: Invalid Sudoku board with duplicate in row");
        System.out.println("Output: " + solution(board2));
    }

    /**
     * Solution: Hash Set Validation
     * ----------------------------------------
     * Step-by-step explanation:
     *
     * 1. Create three HashSets for row, column, and box validation
     * 2. Iterate through each cell of the board
     * 3. For each filled cell (not '.'):
     *    - Check row: create key "row_i" and check if digit already seen
     *    - Check column: create key "col_j" and check if digit already seen
     *    - Check 3x3 box: create key "box_{i/3}_{j/3}" and check if digit already seen
     * 4. If any check fails, return false; otherwise return true
     *
     * Time Complexity: O(81) = O(1) - fixed 9x9 board
     * Space Complexity: O(81) = O(1) - at most 81 elements in sets
     */
    public static boolean solution(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                String num = String.valueOf(c);

                // Check row
                String rowKey = "row" + i + num;
                if (!seen.add(rowKey)) return false;

                // Check column
                String colKey = "col" + j + num;
                if (!seen.add(colKey)) return false;

                // Check 3x3 box
                String boxKey = "box" + (i / 3) + (j / 3) + num;
                if (!seen.add(boxKey)) return false;
            }
        }

        return true;
    }

    /**
     * Alternative Solution: Direct Array Validation
     * ----------------------------------------
     * Use three separate 2D boolean arrays for rows, cols, and boxes.
     *
     * Time Complexity: O(81) = O(1)
     * Space Complexity: O(1)
     */
    public static boolean alternativeSolution(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int num = c - '1';
                int boxIndex = (i / 3) * 3 + j / 3;

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}
