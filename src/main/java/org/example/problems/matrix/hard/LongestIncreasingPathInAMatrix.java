package org.example.problems.matrix.hard;

import java.util.*;

/**
 * Problem: Longest Increasing Path in a Matrix
 * Topic: Matrix
 * Level: Hard
 *
 * Problem Description:
 * Longest Increasing Path in a Matrix - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=gvwTGXP-reQ
 * LeetCode Problem Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {

    /**
     * Finds the length of the longest increasing path in a matrix.
     * Uses DFS with memoization for O(m·n) time and O(m·n) space.
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println("Longest increasing path length = " + solution(matrix));
    }

    public static Object solution(Object input) {
        int[][] matrix = (int[][]) input;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                max = Math.max(max, dfs(matrix, memo, r, c));
            }
        }
        return max;
    }

    private static int dfs(int[][] m, int[][] memo, int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int best = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= m.length || nc < 0 || nc >= m[0].length) continue;
            if (m[nr][nc] > m[r][c]) {
                best = Math.max(best, 1 + dfs(m, memo, nr, nc));
            }
        }
        memo[r][c] = best;
        return best;
    }

    public static Object alternativeSolution(Object input) {
        // Stream API does not simplify DFS with memoization.
        return solution(input);
    }
}
