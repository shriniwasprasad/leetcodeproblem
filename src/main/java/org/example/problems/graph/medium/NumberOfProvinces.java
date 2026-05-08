package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Number of Provinces
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Given an n x n adjacency matrix isConnected, return the number of provinces (connected components).
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        System.out.println("Number of provinces = " + solution(isConnected));
    }

    public static Object solution(Object input) {
        int[][] g = (int[][]) input;
        int n = g.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(g, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] g, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < g.length; j++) {
            if (g[i][j] == 1 && !visited[j]) {
                dfs(g, visited, j);
            }
        }
    }

    public static Object alternativeSolution(Object input) {
        // Stream API does not simplify graph component traversal.
        return solution(input);
    }
}
