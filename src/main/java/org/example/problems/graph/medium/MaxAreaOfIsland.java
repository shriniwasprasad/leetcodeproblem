package org.example.problems.graph.medium;

/**
 * Problem: Max Area of Island (LeetCode 695)
 * Topic: Graphs, DFS, BFS
 * Level: Medium
 *
 * Problem Description:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical).
 *
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * Example 1:
 * Input: grid = [
 *   [0,0,1,0,0,0,0,1,0,0,0,0,0],
 *   [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *   [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *   [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *   [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *   [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *   [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *   [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * ]
 * Output: 6
 *
 * Video Explanation: https://www.youtube.com/watch?v=Dy-M-Suk8nk
 * LeetCode Problem Link: https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        // Test case 1
        int[][] grid1 = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println("Test 1 (DFS): " + solution(grid1));  // Expected: 6

        // Test case 2: No islands
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println("Test 2 (DFS): " + solution(grid2));  // Expected: 0

        // Test case 3: Single island
        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println("Test 3 (DFS): " + solution(grid3));  // Expected: 4

        // Test case 4
        int[][] grid4 = {{0, 1}, {1, 1}};
        System.out.println("Test 4 (DFS): " + solution(grid4));  // Expected: 3

        // Alternative solution (BFS) tests
        System.out.println("\nAlternative Solution (BFS) Tests:");
        System.out.println("Test 1: " + alternativeSolution(grid1));  // Expected: 6
        System.out.println("Test 2: " + alternativeSolution(grid2));  // Expected: 0
    }

    /**
     * DFS approach to find maximum area of island.
     * For each unvisited land cell, calculate the area of its island.
     * Time Complexity: O(m * n) where m = rows, n = columns
     * Space Complexity: O(m * n) for recursion stack in worst case
     *
     * @param grid binary matrix with 0 (water) and 1 (land)
     * @return maximum area of an island
     */
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Found new island, calculate its area
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    /**
     * BFS approach to find maximum area of island.
     * Uses a queue to count cells in each island iteratively.
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n)) for queue
     *
     * @param grid binary matrix
     * @return maximum area of an island
     */
    public static int alternativeSolution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        // Direction arrays for moving up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // BFS to count island area
                    int area = 0;
                    java.util.Queue<int[]> queue = new java.util.LinkedList<>();
                    queue.offer(new int[]{r, c});
                    grid[r][c] = 0;  // Mark as visited
                    area++;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int currR = cell[0];
                        int currC = cell[1];

                        for (int i = 0; i < 4; i++) {
                            int nr = currR + dr[i];
                            int nc = currC + dc[i];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                                grid[nr][nc] = 0;  // Mark as visited
                                area++;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    /**
     * DFS helper to calculate island area.
     * @param grid the matrix
     * @param r row index
     * @param c column index
     * @return area of the island
     */
    private static int dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check bounds and if cell is water or already visited
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;  // Mark as visited

        // Count current cell + all connected cells
        return 1 + dfs(grid, r - 1, c) +   // Up
                   dfs(grid, r + 1, c) +   // Down
                   dfs(grid, r, c - 1) +   // Left
                   dfs(grid, r, c + 1);    // Right
    }
}
