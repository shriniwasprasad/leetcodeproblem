package org.example.problems.dynamicprogramming.medium;

import java.util.*;

/**
 * Problem: Interleaving String
 * Topic: 2-D Dynamic Programming
 * Level: Medium
 *
 * Problem Description:
 * Given strings s1, s2, and s3, determine if s3 is formed by interleaving s1 and s2.
 *
 * Input: s1 = "aab", s2 = "axy", s3 = "aaxabyb"
 * Output: true
 *
 * Video Explanation: https://www.youtube.com/watch?v=KXIK863L9tk
 * LeetCode Problem Link: https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

    public static void main(String[] args) {
        System.out.println("=== InterleavingString ===");
        System.out.println(solution("aab", "axy", "aaxabyb")); // true
    }

    /**
     * Solution: 2D DP.
     * dp[i][j] = true if s3[0..i+j-1] is interleaving of s1[0..i-1] and s2[0..j-1]
     * Time: O(m * n), Space: O(m * n)
     */
    public static boolean solution(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= n && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }

    /**
     * Alternative Solution: Space-optimized 1D DP.
     * Time: O(m * n), Space: O(n)
     */
    public static boolean alternativeSolution(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n];
    }

    /**
     * Alternative Solution: BFS with queue.
     * Time: O(m * n), Space: O(m * n)
     */
    public static boolean alternativeBFSSolution(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited.add("0,0");

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            int k = i + j;

            if (i == m && j == n) return true;

            if (i < m && s1.charAt(i) == s3.charAt(k)) {
                String key = (i + 1) + "," + j;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(new int[]{i + 1, j});
                }
            }

            if (j < n && s2.charAt(j) == s3.charAt(k)) {
                String key = i + "," + (j + 1);
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        return false;
    }
}
