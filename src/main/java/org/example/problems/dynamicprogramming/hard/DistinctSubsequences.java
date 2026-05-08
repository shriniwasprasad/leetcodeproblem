package org.example.problems.dynamicprogramming.hard;

import java.util.*;

/**
 * Problem: Distinct Subsequences
 * Topic: 2-D Dynamic Programming
 * Level: Hard
 *
 * Problem Description:
 * Count the number of distinct subsequences of t in s.
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3 (rabbbit has 3 ways to form "rabbit")
 *
 * Video Explanation: https://www.youtube.com/watch?v=A5IBp1ldlik
 * LeetCode Problem Link: https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println("=== DistinctSubsequences ===");
        System.out.println(solution("rabbbit", "rabbit")); // 3
    }

    /**
     * Solution: 2D DP.
     * dp[i][j] = number of distinct subsequences of t[0..j-1] in s[0..i-1]
     * Time: O(m * n), Space: O(m * n)
     */
    public static int solution(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Alternative Solution: Space-optimized 1D DP.
     * Time: O(m * n), Space: O(n)
     */
    public static int alternativeSolution(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }

    /**
     * Alternative Solution: Recursive with memoization.
     * Time: O(m * n), Space: O(m * n)
     */
    public static int alternativeRecursiveSolution(String s, String t) {
        Map<String, Integer> memo = new HashMap<>();
        return countSubseq(s, t, s.length(), t.length(), memo);
    }

    private static int countSubseq(String s, String t, int i, int j, Map<String, Integer> memo) {
        if (j == 0) return 1;
        if (i == 0) return 0;
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        int result = countSubseq(s, t, i - 1, j, memo);
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            result += countSubseq(s, t, i - 1, j - 1, memo);
        }
        memo.put(key, result);
        return result;
    }
}
