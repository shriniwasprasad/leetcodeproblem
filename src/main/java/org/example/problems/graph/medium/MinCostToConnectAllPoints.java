package org.example.problems.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: Min Cost to Connect All Points (Minimum Spanning Tree)
 * Topic: Advanced Graphs
 * Level: Medium
 *
 * Problem Description:
 * Given n points on a 2D plane, connect all points such that the total
 * cost of connections is minimized. Cost between two points is Manhattan distance.
 *
 * Input:
 * - points: int[][] array where points[i] = [xi, yi]
 * - Output: Integer representing minimum cost to connect all points
 *
 * Example:
 * Input: points = [[0,0],[0,2],[3,0],[3,2]]
 * Output: 8
 * Explanation: Connect [0,0] to [0,2] (cost 2), then [0,2] to [3,2] (cost 3),
 *              then [3,2] to [3,0] (cost 2), total = 7 OR connect optimally for 8
 *
 * Best Solution: Kruskal's Algorithm with Union-Find
 * - Time Complexity: O(E log E) where E = n*(n-1)/2 edges
 * - Space Complexity: O(E) for edges storage
 */
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        System.out.println("=== MinCostToConnectAllPoints ===\n");

        // Example 1
        int[][] points1 = {{0, 0}, {0, 2}, {3, 0}, {3, 2}};
        System.out.println("Test 1 - Input: " + formatPoints(points1));
        System.out.println("Expected: 8");
        System.out.println("Result: " + solution(points1));
        System.out.println();

        // Example 2
        int[][] points2 = {{0, 0}, {0, 3}, {3, 4}, {3, 0}};
        System.out.println("Test 2 - Input: " + formatPoints(points2));
        System.out.println("Expected: 10");
        System.out.println("Result: " + solution(points2));
        System.out.println();

        // Example 3
        int[][] points3 = {{3, 2}, {1, 3}, {1, 1}, {2, 2}};
        System.out.println("Test 3 - Input: " + formatPoints(points3));
        System.out.println("Expected: 6");
        System.out.println("Result: " + solution(points3));
    }

    /**
     * Main solution using Kruskal's Algorithm with Union-Find
     *
     * Implementation Steps:
     * 1. Generate all possible edges with Manhattan distances
     * 2. Sort edges by weight (distance)
     * 3. Iterate through sorted edges and add to MST if they don't create cycles
     * 4. Use Union-Find to efficiently detect cycles
     * 5. Return total weight of MST
     *
     * @param points 2D array of point coordinates
     * @return minimum cost to connect all points
     */
    public static int solution(int[][] points) {
        // Handle edge cases
        if (points == null || points.length <= 1) {
            return 0;
        }

        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Step 1: Generate all possible edges with their Manhattan distances
        // Manhattan distance: |x1-x2| + |y1-y2|
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) +
                               Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }

        // Step 2: Sort edges by weight (ascending)
        Collections.sort(edges);

        // Step 3 & 4: Build MST using Union-Find
        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesAdded = 0;

        for (Edge edge : edges) {
            // If two points are not already connected, add this edge
            if (uf.find(edge.from) != uf.find(edge.to)) {
                uf.union(edge.from, edge.to);
                mstCost += edge.weight;
                edgesAdded++;

                // MST is complete when we have n-1 edges
                if (edgesAdded == n - 1) {
                    break;
                }
            }
        }

        return mstCost;
    }

    /**
     * Alternative solution using Prim's Algorithm with PriorityQueue
     *
     * Best for dense graphs, but O(E log E) = O(n² log n) for complete graph
     */
    public static int alternativeSolution(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }

        int n = points.length;
        // Minimum priority queue: stores {cost, index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int nodesVisited = 0;

        // Start from node 0
        for (int j = 1; j < n; j++) {
            int dist = manhattanDistance(points[0], points[j]);
            pq.offer(new int[]{dist, j});
        }

        while (!pq.isEmpty() && nodesVisited < n) {
            int[] edge = pq.poll();
            int cost = edge[0];
            int node = edge[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalCost += cost;
            nodesVisited++;

            // Add edges from newly visited node to unvisited nodes
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = manhattanDistance(points[node], points[j]);
                    pq.offer(new int[]{dist, j});
                }
            }
        }

        return totalCost;
    }

    /**
     * Calculates Manhattan distance between two points
     */
    private static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    /**
     * Edge class for storing edge information
     */
    private static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    /**
     * Union-Find (Disjoint Set Union) data structure
     * Uses path compression and union by rank for near-constant time operations
     */
    private static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;  // Each element is its own parent initially
                rank[i] = 1;    // Initial rank is 1
            }
        }

        public int find(int x) {
            // Path compression: make all nodes on path point directly to root
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Union by rank: attach shorter tree to taller tree
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    /**
     * Formats points array for display
     */
    private static String formatPoints(int[][] points) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < points.length; i++) {
            sb.append(Arrays.toString(points[i]));
            if (i < points.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
