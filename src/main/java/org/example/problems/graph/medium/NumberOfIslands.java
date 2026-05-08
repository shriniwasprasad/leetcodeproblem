package org.example.problems.graph.medium;

/**
 * Problem: Number of Islands (LeetCode 200)
 * Topic: Graphs, DFS, BFS
 * Level: Medium
 *
 * Problem Description:
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Video Explanation: https://www.youtube.com/watch?v=H-2Nh2RXX6g
 * LeetCode Problem Link: https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        // Test case 1
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Test 1 (DFS): " + solution(grid1));  // Expected: 1

        // Test case 2
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Test 2 (DFS): " + solution(grid2));  // Expected: 3

        // Alternative solution (BFS) tests
        System.out.println("\nAlternative Solution (BFS) Tests:");
        char[][] grid3 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Test 1: " + alternativeSolution(grid3));  // Expected: 1
    }

    /**
     * Depth-First Search approach to count islands.
     * For each unvisited land cell, increment count and mark entire island as visited.
     * Time Complexity: O(m * n) where m = rows, n = columns
     * Space Complexity: O(m * n) for recursion stack in worst case
     *
     * @param grid 2D grid of '1's (land) and '0's (water)
     * @return number of islands
     */
    public static int solution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    // Found new island, count it and mark all connected land
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    /**
     * Breadth-First Search approach to count islands.
     * Uses a queue to traverse each island iteratively.
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n)) for queue
     *
     * @param grid 2D grid of '1's (land) and '0's (water)
     * @return number of islands
     */
    public static int alternativeSolution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Direction arrays for moving up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    grid[r][c] = '0';  // Mark as visited

                    // BFS to mark entire island
                    java.util.Queue<int[]> queue = new java.util.LinkedList<>();
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int currR = cell[0];
                        int currC = cell[1];

                        // Check all 4 directions
                        for (int i = 0; i < 4; i++) {
                            int nr = currR + dr[i];
                            int nc = currC + dc[i];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';  // Mark as visited
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }

    /**
     * DFS helper method to mark all connected land cells.
     * @param grid the 2D grid
     * @param r row index
     * @param c column index
     */
    private static void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check bounds and if cell is water or already visited
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';  // Mark as visited

        // Explore all 4 directions
        dfs(grid, r - 1, c);  // Up
        dfs(grid, r + 1, c);  // Down
        dfs(grid, r, c - 1);  // Left
        dfs(grid, r, c + 1);  // Right
    }
}
