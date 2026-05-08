package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Graph Valid Tree (LeetCode Premium)
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: An undirected graph is a tree if it is connected and has no cycles.
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}}; // this forms a valid tree
        System.out.println("Is valid tree = " + solution(new Object[]{n, edges}));
    }

    /**
     * Use Union‑Find to detect cycles and ensure connectivity.
     */
    public static Object solution(Object input) {
        Object[] arr = (Object[]) input;
        int n = (int) arr[0];
        int[][] edges = (int[][]) arr[1];
        if (edges.length != n - 1) return false; // must have exactly n-1 edges for a tree
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                if (parent[x] != x) parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };
        for (int[] e : edges) {
            int a = find.applyAsInt(e[0]);
            int b = find.applyAsInt(e[1]);
            if (a == b) return false; // cycle detected
            parent[a] = b; // union
        }
        return true; // connected (n-1 edges ensures connectivity) and acyclic
    }

    public static Object alternativeSolution(Object input) {
        // Union‑Find is already optimal; delegate to primary solution.
        return solution(input);
    }
}
