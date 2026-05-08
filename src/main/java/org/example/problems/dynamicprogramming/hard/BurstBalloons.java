package org.example.problems.dynamicprogramming.hard;

import java.util.*;

/**
 * Problem: Burst Balloons
 * Topic: 2-D Dynamic Programming
 * Level: Hard
 *
 * Problem Description:
 * Given balloons numbered 0 to n-1, each has a coin value.
 * Burst balloon i to get coins = nums[i-1] * nums[i] * nums[i+1].
 * Find maximum coins you can collect.
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 *
 * Video Explanation: https://www.youtube.com/watch?v=TfvN6rqDOT0
 * LeetCode Problem Link: https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {

    public static void main(String[] args) {
        System.out.println("=== BurstBalloons ===");
        System.out.println(solution(new int[]{3, 1, 5, 8})); // 167
    }

    /**
     * Solution:区间 DP.
     * Add virtual balloons (1) at both ends. dp[i][j] = max coins in (i, j).
     * Time: O(n^3), Space: O(n^2)
     */
    public static int solution(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n + 1; len++) {
            for (int i = 0; i <= n + 1 - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    /**
     * Alternative Solution: Recursive with memoization.
     * Time: O(n^3), Space: O(n^2)
     */
    public static int alternativeSolution(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] memo = new int[n + 2][n + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return burst(arr, 0, n + 1, memo);
    }

    private static int burst(int[] arr, int left, int right, int[][] memo) {
        if (left + 1 == right) return 0;
        if (memo[left][right] != -1) return memo[left][right];

        int max = 0;
        for (int k = left + 1; k < right; k++) {
            max = Math.max(max,
                    burst(arr, left, k, memo)
                            + burst(arr, k, right, memo)
                            + arr[left] * arr[k] * arr[right]);
        }
        memo[left][right] = max;
        return max;
    }
}
