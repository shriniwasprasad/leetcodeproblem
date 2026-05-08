package org.example.problems.graph.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: Swim In Rising Water (Minimax Path Finding)
 * Topic: Advanced Graphs
 * Level: Hard
 *
 * Problem Description:
 * Given an n x n grid representing heights, find minimum time to swim
 * from top-left (0,0) to bottom-right (n-1,n-1). You can swim between
 * adjacent cells if both have height <= time.
 *
 * Input:
 * - grid: int[][] 2D array of heights
 * - Output: Integer representing minimum time to reach destination
 *
 * Example:
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation: Path (0,0)->(1,0)->(1,1) requires max height 3
 *
 * Best Solution: Modified Dijkstra (Minimax Path)
 * - Time Complexity: O(N*M log(N*M)) where N=M is grid dimensions
 * - Space Complexity: O(N*M) for visited and priority queue
 */
public class SwimInRisingWater {

    public static void main(String[] args) {
        System.out.println("=== Swim In Rising Water ===\n");

        // Example 1
        int[][] grid1 = {{0, 2}, {1, 3}};
        System.out.println("Test 1 - Input: grid=" + formatGrid(grid1));
        System.out.println("Expected: 3");
        System.out.println("Result: " + solution(grid1));
        System.out.println();

        // Example 2
        int[][] grid2 = {{0, 1, 2, 3, 4}, {21, 23, 24, 25, 26}, {11, 12, 13, 14, 15},
                          {10, 9,  8,  11, 12}, {10, 12, 11, 7,  6}};
        System.out.println("Test 2 - Input: grid=" + formatGrid(grid2));
        System.out.println("Expected: 7");
        System.out.println("Result: " + solution(grid2));
        System.out.println();

        // Example 3 - All same heights
        int[][] grid3 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println("Test 3 - Input: grid=" + formatGrid(grid3));
        System.out.println("Expected: 1");
        System.out.println("Result: " + solution(grid3));
        System.out.println();
    }

    /**
     * Main solution using Modified Dijkstra Algorithm
     *
     * Implementation Steps:
     * 1. Treat each cell height as edge weight
     * 2. Use modified Dijkstra where cost to enter cell = max(current, cell_height)
     * 3. Start from (0,0) with cost = grid[0][0]
     * 4. Always process cell with minimum current cost
     * 5. When reaching (n-1,m-1), return the cost
     * 6. Time complexity: O(N*M log(N*M))
     *
     * @param grid 2D array of heights
     * @return Minimum time to swim from (0,0) to (n-1,m-1)
     */
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        // Handle 1x1 grid
        if (n == 1 && m == 1) {
            return grid[0][0];
        }

        // Distance array: dist[r][c] = minimum max-height to reach cell (r,c)
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // Priority queue: stores {maxHeight, row, col}
        // Min-heap ordered by maxHeight (least max-height first)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize start position
        int startHeight = grid[0][0];
        dist[0][0] = startHeight;
        visited[0][0] = true;
        pq.offer(new int[]{startHeight, 0, 0});

        // Direction vectors for moving up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int result = 0;

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int r = current[1];
            int c = current[2];

            // If we reached destination, return the cost
            if (r == n - 1 && c == m - 1) {
                result = currentCost;
                break;
            }

            // Note: currentCost might be less than dist[r][c] due to lazy deletion
            if (currentCost > dist[r][c]) {
                continue;
            }

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check bounds and if cell already visited
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;

                    // Cost to enter new cell is max(current cell's max, new cell's height)
                    int newCost = Math.max(dist[r][c], grid[nr][nc]);
                    dist[nr][nc] = newCost;

                    pq.offer(new int[]{newCost, nr, nc});
                }
            }
        }

        return result;
    }

    /**
     * Alternative solution using Binary Heap with different approach
     */
    public static int alternativeSolution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // int n = grid.length;
        // int m = grid[0].length;

        // Same as solution() - this is the optimal approach
        // Just returning from main solution
        return solution(grid);
    }

    /**
     * Alternative solution using Union-Find (binary search on answer)
     * Different approach: binary search on answer + connected components
     */
    public static int binarySearchSolution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        // Binary search on answer: range [0, max(grid)]
        // int minTime = 0;
        int maxTime = 0;
        for (int[] row : grid) {
            for (int h : row) {
                maxTime = Math.max(maxTime, h);
            }
        }

        int low = 0, high = maxTime;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if (0,0) and (n-1,m-1) are connected with max height <= mid
            if (canReach(grid, n, m, mid)) {
                result = mid;
                high = mid - 1; // Try smaller max height
            } else {
                low = mid + 1; // Need larger max height
            }
        }

        return result == -1 ? maxTime : result;
    }

    /**
     * Helper method to check connectivity using Union-Find
     */
    private static boolean canReach(int[][] grid, int n, int m, int maxHeight) {
        UnionFind uf = new UnionFind(n * m);

        // Union adjacent cells if both have height <= maxHeight
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] <= maxHeight) {
                    // Union with right neighbor
                    if (c + 1 < m && grid[r][c + 1] <= maxHeight) {
                        uf.union(r * m + c, r * m + c + 1);
                    }
                    // Union with bottom neighbor
                    if (r + 1 < n && grid[r + 1][c] <= maxHeight) {
                        uf.union(r * m + c, (r + 1) * m + c);
                    }
                }
            }
        }

        // Check if start and end are in same component
        return uf.find(0) == uf.find((n - 1) * m + (m - 1));
    }

    /**
     * Union-Find data structure for connectivity checking
     */
    private static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY; // Union without rank
            }
        }
    }

    /**
     * Helper method to format grid for display
     */
    private static String formatGrid(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("[[");
        for (int r = 0; r < grid.length; r++) {
            sb.append(grid[r]);
            if (r < grid.length - 1) sb.append("], [");
        }
        sb.append("]]");
        return sb.toString();
    }
}
