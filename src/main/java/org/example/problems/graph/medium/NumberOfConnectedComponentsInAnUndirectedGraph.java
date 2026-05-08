package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Number of Connected Components in an Undirected Graph (LeetCode Premium)
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Given n nodes labeled 0..n-1 and an edge list, return the number of connected components.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}}; // two components: {0,1,2} and {3,4}
        System.out.println("Connected components = " + solution(new Object[]{n, edges}));
    }

    /**
     * Solution using Union‑Find (Disjoint Set Union).
     */
    public static Object solution(Object input) {
        Object[] arr = (Object[]) input;
        int n = (int) arr[0];
        int[][] edges = (int[][]) arr[1];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        // Find with path compression
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                if (parent[x] != x) parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };
        // Union
        for (int[] e : edges) {
            int a = find.applyAsInt(e[0]);
            int b = find.applyAsInt(e[1]);
            if (a != b) parent[a] = b;
        }
        // Count unique roots
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) roots.add(find.applyAsInt(i));
        return roots.size();
    }

    public static Object alternativeSolution(Object input) {
        // Union‑Find is already optimal; delegate to primary solution.
        return solution(input);
    }
}
