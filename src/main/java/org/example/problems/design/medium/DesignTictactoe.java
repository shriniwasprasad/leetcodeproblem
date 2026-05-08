package org.example.problems.design.medium;

/**
 * Problem: Design Tic-Tac-Toe (LeetCode 348)
 * Topic: Design, Game Theory
 * Level: Medium
 *
 * Problem Description:
 * Assume the following rules are for a tic-tac-toe game on an n x n board between two players:
 * - A move is guaranteed to be valid and is placed on an empty block.
 * - Once a move is made, no further movement will occur on that block.
 * - A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 * Implement the TicTacToe class:
 * - TicTacToe(int n) Initializes the object with the size of the board n.
 * - int move(int row, int col, int player) Indicates that the player with id player plays
 *   at the cell (row, col) of the board. The move is guaranteed to be valid.
 *   Return 0 if there is no winner, 1 or 2 otherwise.
 *
 * Example:
 * Input:
 * ["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
 * [[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
 * Output:
 * [null, 0, 0, 0, 0, 0, 0, 1]
 *
 * LeetCode Problem Link: https://leetcode.com/problems/design-tic-tac-toe/
 */
public class DesignTictactoe {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println("move(0, 0, 1): " + ticTacToe.move(0, 0, 1));       // 0
        System.out.println("move(0, 2, 2): " + ticTacToe.move(0, 2, 2));       // 0
        System.out.println("move(2, 2, 1): " + ticTacToe.move(2, 2, 1));       // 0
        System.out.println("move(1, 1, 2): " + ticTacToe.move(1, 1, 2));       // 0
        System.out.println("move(2, 0, 1): " + ticTacToe.move(2, 0, 1));       // 0
        System.out.println("move(1, 0, 2): " + ticTacToe.move(1, 0, 2));       // 0
        System.out.println("move(2, 1, 1): " + ticTacToe.move(2, 1, 1));       // 1 (player 1 wins)
    }

    /**
     * TicTacToe class with O(1) move operation.
     * Uses counters for rows, columns, and diagonals instead of checking the entire board.
     */
    static class TicTacToe {
        private int n;
        private int[] rows;
        private int[] cols;
        private int diagonal;
        private int antiDiagonal;

        /**
         * Initialize the tic-tac-toe board of size n.
         * Time Complexity: O(n)
         * @param n the size of the board
         */
        public TicTacToe(int n) {
            this.n = n;
            this.rows = new int[n];
            this.cols = new int[n];
            this.diagonal = 0;
            this.antiDiagonal = 0;
        }

        /**
         * Process a move and check for winner.
         * Time Complexity: O(1)
         * Space Complexity: O(n)
         *
         * @param row the row index
         * @param col the column index
         * @param player the player ID (1 or 2)
         * @return 0 if no winner, 1 or 2 if that player wins
         */
        public int move(int row, int col, int player) {
            // Use player as +1 or -1 to track moves
            int playerVal = (player == 1) ? 1 : -1;

            // Update row and column counters
            rows[row] += playerVal;
            cols[col] += playerVal;

            // Update diagonal if applicable
            if (row == col) {
                diagonal += playerVal;
            }

            // Update anti-diagonal if applicable
            if (row + col == n - 1) {
                antiDiagonal += playerVal;
            }

            // Check if player won
            if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
                return player;
            }

            return 0;
        }
    }
}
