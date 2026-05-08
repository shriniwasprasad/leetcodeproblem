package org.example.problems.graph.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Redundant Connection (LeetCode 684)
 * Topic: Graphs, Union-Find, DFS
 * Level: Medium
 *
 * Problem Description:
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * You are given a graph that started as a tree with n nodes labeled from 1 to n,
 * with one additional edge added. The added edge has two different vertices chosen
 * from 1 to n and was not an edge that already existed.
 *
 * The graph is given as an array edges where edges[i] = [ai, bi] indicates that
 * there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 *
 * Example 1:
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 * Example 2:
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 * Video Explanation: https://www.youtube.com/watch?v=ctMC5TPuVnM
 * LeetCode Problem Link: https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {

    public static void main(String[] args) {
        // Test case 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result1 = solution(edges1);
        System.out.print("Test 1 (Union-Find) - Redundant: [" + result1[0] + ", " + result1[1] + "]");  // Expected: [2, 3]
        System.out.println();

        // Test case 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result2 = solution(edges2);
        System.out.print("Test 2 (Union-Find) - Redundant: [" + result2[0] + ", " + result2[1] + "]");  // Expected: [1, 4]
        System.out.println();

        // Test case 3
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 1}};
        int[] result3 = solution(edges3);
        System.out.print("Test 3 (Union-Find) - Redundant: [" + result3[0] + ", " + result3[1] + "]");  // Expected: [3, 1]
        System.out.println();

        // Alternative solution (DFS) tests
        System.out.println("\n=== Alternative Solution (DFS) ===");
        int[][] edges4 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result4 = alternativeSolution(edges4);
        System.out.print("Test 1 - Redundant: [" + result4[0] + ", " + result4[1] + "]");
        System.out.println();

        int[][] edges5 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result5 = alternativeSolution(edges5);
        System.out.print("Test 2 - Redundant: [" + result5[0] + ", " + result5[1] + "]");
        System.out.println();
    }

    /**
     * Union-Find (Disjoint Set Union) approach.
     * Process edges one by one and union nodes.
     * If two nodes are already in the same set, this edge creates a cycle.
     * Time Complexity: O(n * alpha(n)) where alpha is the inverse Ackermann function (nearly constant)
     * Space Complexity: O(n) for parent array
     *
     * @param edges array of [u, v] edges
     * @return the redundant edge
     */
    public static int[] solution(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }

        int n = edges.length;
        int[] parent = new int[n + 1];  // Nodes are 1-indexed

        // Initialize parent array (each node is its own parent)
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Find roots of both nodes
            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // If they have the same root, this edge creates a cycle
            if (rootU == rootV) {
                return edge;
            }

            // Union the sets
            parent[rootU] = rootV;
        }

        return new int[0];  // Should not reach here
    }

    /**
     * DFS approach - build graph incrementally and check for paths.
     * For each edge, check if a path already exists between the two nodes.
     * Time Complexity: O(n^2) in worst case
     * Space Complexity: O(n) for adjacency list and recursion
     *
     * @param edges array of edges
     * @return the redundant edge
     */
    public static int[] alternativeSolution(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }

        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Process edges one by one
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Check if path already exists between u and v
            if (hasPath(graph, u, v, new boolean[n + 1])) {
                return edge;  // This edge creates a cycle
            }

            // Add edge to graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    /**
     * Union-Find find with path compression.
     * @param parent parent array
     * @param x node to find root for
     * @return root of the set containing x
     */
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);  // Path compression
        }
        return parent[x];
    }

    /**
     * DFS helper to check if path exists between source and target.
     * @param graph adjacency list
     * @param source starting node
     * @param target destination node
     * @param visited visited array
     * @return true if path exists
     */
    private static boolean hasPath(List<List<Integer>> graph, int source, int target, boolean[] visited) {
        if (source == target) {
            return true;
        }

        visited[source] = true;

        for (int neighbor : graph.get(source)) {
            if (!visited[neighbor] && hasPath(graph, neighbor, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
