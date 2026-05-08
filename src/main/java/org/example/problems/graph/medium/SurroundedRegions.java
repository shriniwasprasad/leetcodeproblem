package org.example.problems.graph.medium;

/**
 * Problem: Surrounded Regions (LeetCode 130)
 * Topic: Graphs, DFS, BFS
 * Level: Medium
 *
 * Problem Description:
 * You are given an m x n matrix board containing letters 'X' and 'O'.
 * Capture regions that are surrounded:
 * - Connect: A cell is connected to adjacent cells horizontally or vertically.
 * - Region: A region is formed by connecting every 'O' cell.
 * - Surround: A region is surrounded if it is connected to 'X' cells and none of the cells
 *   in the region are connected to cells on the border of the board.
 *
 * You need to mutate the board by replacing all 'O's in surrounded regions with 'X's in-place.
 *
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=yaBaE4fo6wA
 * LeetCode Problem Link: https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        // Test case 1
        char[][] board1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        System.out.println("Test 1 - Before:");
        printBoard(board1);
        solution(board1);
        System.out.println("Test 1 - After:");
        printBoard(board1);  // Expected: border O stays, internal O's become X

        // Test case 2
        char[][] board2 = {{'X'}};
        System.out.println("\nTest 2 - Before:");
        printBoard(board2);
        solution(board2);
        System.out.println("Test 2 - After:");
        printBoard(board2);

        // Test case 3: All O's on border
        char[][] board3 = {
            {'O', 'O', 'O'},
            {'O', 'O', 'O'},
            {'O', 'O', 'O'}
        };
        System.out.println("\nTest 3 - Before:");
        printBoard(board3);
        solution(board3);
        System.out.println("Test 3 - After:");
        printBoard(board3);  // Expected: no change (all connected to border)

        // Alternative solution (BFS) test
        System.out.println("\n=== Alternative Solution (BFS) ===");
        char[][] board4 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        System.out.println("Test 1 - Before:");
        printBoard(board4);
        alternativeSolution(board4);
        System.out.println("Test 1 - After:");
        printBoard(board4);
    }

    /**
     * DFS approach - mark all 'O's connected to border, then flip remaining.
     * Step 1: Start DFS from all border 'O's and mark them as safe ('S')
     * Step 2: Flip all remaining 'O's to 'X' (they are surrounded)
     * Step 3: Convert all 'S' back to 'O'
     * Time Complexity: O(m * n) where m = rows, n = columns
     * Space Complexity: O(m * n) for recursion stack
     *
     * @param board the m x n matrix of 'X' and 'O'
     */
    public static void solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        if (rows <= 2 || cols <= 2) {
            // All cells are on border - cannot be surrounded
            return;
        }

        // Step 1: Mark all 'O's connected to border as safe ('S')
        // Check first and last column
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // Check first and last row
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // Step 2: Flip all remaining 'O's to 'X' (surrounded regions)
        // Step 3: Convert all 'S' back to 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';  // Surrounded
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';  // Safe (connected to border)
                }
            }
        }
    }

    /**
     * BFS approach - same logic using breadth-first search.
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n)) for queue
     *
     * @param board the m x n matrix
     */
    public static void alternativeSolution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        if (rows <= 2 || cols <= 2) {
            return;
        }

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        // Add all border 'O's to queue
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = 'S';
                queue.offer(new int[]{r, 0});
            }
            if (board[r][cols - 1] == 'O') {
                board[r][cols - 1] = 'S';
                queue.offer(new int[]{r, cols - 1});
            }
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = 'S';
                queue.offer(new int[]{0, c});
            }
            if (board[rows - 1][c] == 'O') {
                board[rows - 1][c] = 'S';
                queue.offer(new int[]{rows - 1, c});
            }
        }

        // Direction arrays
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BFS to mark all connected 'O's as safe
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'O') {
                    board[nr][nc] = 'S';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Flip remaining 'O's and restore 'S' to 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    /**
     * DFS helper to mark all connected 'O' cells as safe ('S').
     */
    private static void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        // Check bounds and if cell is not 'O'
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'S';  // Mark as safe

        // Explore all 4 directions
        dfs(board, r - 1, c);  // Up
        dfs(board, r + 1, c);  // Down
        dfs(board, r, c - 1);  // Left
        dfs(board, r, c + 1);  // Right
    }

    /**
     * Helper method to print the board.
     */
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print("\"" + row[i] + "\"");
                if (i < row.length - 1) System.out.print(", ");
            }
            System.out.println("],");
        }
    }
}
