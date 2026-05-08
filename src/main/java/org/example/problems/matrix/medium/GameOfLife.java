package org.example.problems.matrix.medium;

import java.util.*;

/**
 * Problem: Game of Life
 * Topic: Matrix
 * Level: Medium
 *
 * Problem Description:
 * Game of Life - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=1FQNMDPZXRc
 * LeetCode Problem Link: https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {

    /**
     * Implements Conway's Game of Life. The input is a 2‑D int array where 0 = dead, 1 = alive.
     * The board is updated in‑place using state encoding:
     *   0 – dead → dead
     *   1 – live  → live
     *   2 – live  → dead (was live, becomes dead)
     *   3 – dead  → live (was dead, becomes live)
     */
    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        System.out.println("Before:");
        print(board);
        solution(board);
        System.out.println("After:");
        print(board);
    }

    private static void print(int[][] b) {
        for (int[] row : b) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    public static Object solution(Object input) {
        int[][] board = (int[][]) input;
        if (board == null || board.length == 0 || board[0].length == 0) return board;
        int m = board.length, n = board[0].length;
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        // First pass: encode next state in 2 or 3
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveNeighbors = 0;
                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    int val = board[nr][nc];
                    if (val == 1 || val == 2) liveNeighbors++; // originally alive
                }
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[r][c] = 2; // live -> dead
                } else if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = 3; // dead -> live
                }
            }
        }
        // Second pass: finalize state
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 2) board[r][c] = 0;
                else if (board[r][c] == 3) board[r][c] = 1;
            }
        }
        return board;
    }

    public static Object alternativeSolution(Object input) {
        // Stream API is not suitable for in‑place neighbour updates; delegate to primary solution.
        return solution(input);
    }
}
