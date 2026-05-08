package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Find the Celebrity
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: In a party of N people, find the celebrity (known by everyone, knows nobody).
 */
public class FindTheCelebrity {

    public static void main(String[] args) {
        int[][] M = {
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };
        System.out.println("Celebrity index = " + solution(M));
    }

    public static Object solution(Object input) {
        int[][] M = (int[][]) input;
        int n = M.length;
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i; // candidate knows i, so cannot be celebrity
            }
        }
        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                return -1; // no celebrity
            }
        }
        return candidate;
    }

    public static Object alternativeSolution(Object input) {
        // Stream API does not simplify the two‑pass verification.
        return solution(input);
    }
}
