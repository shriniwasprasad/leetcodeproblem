package org.example.problems.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Walls and Gates (LeetCode 286)
 * Topic: Graphs, BFS, DFS
 * Level: Medium
 *
 * Problem Description:
 * You are given an m x n grid rooms initialized with:
 * - -1 for a wall or an obstacle.
 * - 0 for a gate.
 * - INF (2147483647) for an empty room.
 *
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example 1:
 * Input: rooms = [
 *   [INF,-1,0,INF],
 *   [INF,INF,INF,-1],
 *   [INF,-1,INF,-1],
 *   [0,-1,INF,INF]
 * ]
 * Output: [
 *   [3,-1,0,1],
 *   [2,2,1,-1],
 *   [1,-1,2,-1],
 *   [0,-1,3,4]
 * ]
 *
 * Example 2:
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=wYv60DTtsto
 * LeetCode Problem Link: https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {

    // Constant representing INF (empty room)
    private static final int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;

    public static void main(String[] args) {
        // Test case 1
        int[][] rooms1 = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };
        System.out.println("Test 1 - Before:");
        printRooms(rooms1);
        solution(rooms1);
        System.out.println("Test 1 - After:");
        printRooms(rooms1);

        // Test case 2: Single wall
        int[][] rooms2 = {{-1}};
        System.out.println("\nTest 2 - Before:");
        printRooms(rooms2);
        solution(rooms2);
        System.out.println("Test 2 - After:");
        printRooms(rooms2);

        // Test case 3: No gates
        int[][] rooms3 = {{INF, INF}, {INF, INF}};
        System.out.println("\nTest 3 - Before:");
        printRooms(rooms3);
        solution(rooms3);
        System.out.println("Test 3 - After:");
        printRooms(rooms3);  // Expected: no change (no gates)

        // Alternative solution (DFS) test
        System.out.println("\n=== Alternative Solution (DFS) ===");
        int[][] rooms4 = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };
        System.out.println("Test 1 - Before:");
        printRooms(rooms4);
        alternativeSolution(rooms4);
        System.out.println("Test 1 - After:");
        printRooms(rooms4);
    }

    /**
     * Multi-source BFS approach - start from all gates simultaneously.
     * This ensures we find the shortest distance to each room.
     * Time Complexity: O(m * n) where m = rows, n = columns
     * Space Complexity: O(m * n) for queue in worst case
     *
     * @param rooms the m x n grid with -1, 0, and INF
     */
    public static void solution(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        // Queue for BFS: stores {row, col}
        Queue<int[]> queue = new LinkedList<>();

        // Add all gates to queue as starting points
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == GATE) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // Direction arrays for moving up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BFS propagation
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            // Check all 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // If valid room and we found a shorter path
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                    rooms[nr][nc] == INF) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    /**
     * DFS approach - start from each gate and propagate distances.
     * Note: BFS is generally preferred for shortest path problems.
     * Time Complexity: O(m * n) in practice
     * Space Complexity: O(m * n) for recursion stack
     *
     * @param rooms the m x n grid
     */
    public static void alternativeSolution(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        // Start DFS from each gate
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == GATE) {
                    dfs(rooms, r, c, 0);
                }
            }
        }
    }

    /**
     * DFS helper to propagate distances from gates.
     * @param rooms the grid
     * @param r row index
     * @param c column index
     * @param distance current distance from gate
     */
    private static void dfs(int[][] rooms, int r, int c, int distance) {
        int rows = rooms.length;
        int cols = rooms[0].length;

        // Check bounds
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }

        // If current cell has shorter distance already, stop
        // Also stop at walls
        if (rooms[r][c] < distance) {
            return;
        }

        // Update distance
        rooms[r][c] = distance;

        // Direction arrays
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            dfs(rooms, r + dr[i], c + dc[i], distance + 1);
        }
    }

    /**
     * Helper method to print the rooms grid.
     */
    private static void printRooms(int[][] rooms) {
        for (int[] row : rooms) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                if (row[i] == INF) {
                    System.out.print("INF");
                } else {
                    System.out.print(row[i]);
                }
                if (i < row.length - 1) System.out.print(", ");
            }
            System.out.println("],");
        }
    }
}
