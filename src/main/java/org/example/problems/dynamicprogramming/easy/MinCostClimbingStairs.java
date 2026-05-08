package org.example.problems.dynamicprogramming.easy;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem: Min Cost Climbing Stairs
 * Topic: 1-D Dynamic Programming
 * Level: Easy
 *
 * Problem Description:
 * You are given an array cost where cost[i] is the cost of climbing the i-th stair.
 * You can start at index 0 or 1. Pay the cost and climb to the next stair.
 * Find the minimum cost to reach the top.
 *
 * Input: cost = [10, 15, 20]
 * Output: 15 (start at 1, pay 15, climb to 2)
 *
 * Video Explanation: https://www.youtube.com/watch?v=A3LYMRqAQeU
 * LeetCode Problem Link: https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println("=== MinCostClimbingStairs ===");
        System.out.println(solution(new int[]{10, 15, 20})); // 15
        System.out.println(alternativeSolution(new int[]{10, 15, 20})); // 15
    }

    /**
     * Solution: DP where dp[i] = min cost to reach step i.
     * dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
     * Time: O(n), Space: O(1)
     */
    public static int solution(int[] cost) {
        int n = cost.length;
        int prev1 = cost[1];
        int prev2 = cost[0];

        for (int i = 2; i < n; i++) {
            int curr = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }

    /**
     * Alternative Solution: 1D DP array.
     * Time: O(n), Space: O(n)
     */
    public static int alternativeSolution(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * Alternative Solution: Stream API (inefficient).
     * Time: O(n), Space: O(n)
     */
    public static int alternativeStreamSolution(int[] cost) {
        int n = cost.length;
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(0);

        IntStream.range(2, n + 1)
                .forEach(i -> {
                    int val = Math.min(
                            dp.get(i - 1) + cost[i - 1],
                            dp.get(i - 2) + cost[i - 2]
                    );
                    dp.add(val);
                });

        return dp.get(n);
    }
}
