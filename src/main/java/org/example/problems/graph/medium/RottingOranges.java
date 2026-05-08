package org.example.problems.graph.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Rotting Oranges (LeetCode 994)
 * Topic: Graphs, BFS, Multi-source BFS
 * Level: Medium
 *
 * Problem Description:
 * You are given an m x n grid where each cell can have one of three values:
 * - 0 representing an empty cell,
 * - 1 representing a fresh orange, or
 * - 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 *
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten.
 *
 * Example 3:
 * Input: grid = [[0,2]]
 * Output: 0
 *
 * Video Explanation: https://www.youtube.com/watch?v=1BlwbFfgk-E
 * LeetCode Problem Link: https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    public static void main(String[] args) {
        // Test case 1
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Test 1 (BFS): " + solution(grid1));  // Expected: 4

        // Test case 2
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println("Test 2 (BFS): " + solution(grid2));  // Expected: -1

        // Test case 3
        int[][] grid3 = {{0, 2}};
        System.out.println("Test 3 (BFS): " + solution(grid3));  // Expected: 0

        // Test case 4
        int[][] grid4 = {{1}, {2}};
        System.out.println("Test 4 (BFS): " + solution(grid4));  // Expected: 1

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(grid1));  // Expected: 4
        System.out.println("Test 2: " + alternativeSolution(grid2));  // Expected: -1
    }

    /**
     * Multi-source BFS approach to simulate rot spreading.
     * Start BFS from all rotten oranges simultaneously.
     * Time Complexity: O(m * n) where m = rows, n = columns
     * Space Complexity: O(m * n) for queue in worst case
     *
     * @param grid 2D grid with 0 (empty), 1 (fresh), 2 (rotten)
     * @return minimum minutes until no fresh oranges, or -1 if impossible
     */
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;

        // Queue for BFS: stores {row, col}
        Queue<int[]> queue = new LinkedList<>();

        // Add all rotten oranges to queue and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, no time needed
        if (freshCount == 0) {
            return 0;
        }

        // Direction arrays for moving up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int minutes = 0;

        // BFS level by level
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;

            // Process all oranges that became rotten in current minute
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                // Check all 4 directions
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // If valid cell with fresh orange
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;  // Make it rotten
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // Return minutes if all fresh oranges are rotton, otherwise -1
        return freshCount == 0 ? minutes : -1;
    }

    /**
     * Alternative BFS approach with explicit depth tracking.
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * @param grid 2D grid
     * @return minimum minutes or -1
     */
    public static int alternativeSolution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c, 0});  // Include depth
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int maxMinutes = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int depth = cell[2];

            maxMinutes = Math.max(maxMinutes, depth);

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    freshCount--;
                    queue.offer(new int[]{nr, nc, depth + 1});
                }
            }
        }

        return freshCount == 0 ? maxMinutes : -1;
    }
}
