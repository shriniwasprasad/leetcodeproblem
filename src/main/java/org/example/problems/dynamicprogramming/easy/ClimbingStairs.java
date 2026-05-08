package org.example.problems.dynamicprogramming.easy;

/**
 * Problem: Climbing Stairs (LeetCode 70)
 * Topic: Dynamic Programming
 * Level: Easy
 *
 * Problem Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Video Explanation: https://www.youtube.com/watch?v=5mWBnYrdO70
 * LeetCode Problem Link: https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println("Test 1 (DP - Space Optimized): " + solution(2));  // Expected: 2
        System.out.println("Test 2 (DP - Space Optimized): " + solution(3));  // Expected: 3
        System.out.println("Test 3 (DP - Space Optimized): " + solution(5));  // Expected: 8

        System.out.println("\nAlternative Solution (DP - Array) Tests:");
        System.out.println("Test 1: " + alternativeSolution(2));  // Expected: 2
        System.out.println("Test 2: " + alternativeSolution(3));  // Expected: 3
        System.out.println("Test 3: " + alternativeSolution(5));  // Expected: 8
    }

    /**
     * Space-optimized Dynamic Programming approach.
     * Uses only two variables to track previous results (Fibonacci-like).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param n number of steps to reach the top
     * @return number of distinct ways to climb to the top
     */
    public static int solution(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;  // Ways to reach step 1
        int prev1 = 2;  // Ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;  // Ways = ways(i-1) + ways(i-2)
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    /**
     * Standard Dynamic Programming approach using array.
     * dp[i] represents the number of ways to reach step i.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param n number of steps
     * @return number of distinct ways
     */
    public static int alternativeSolution(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;  // 1 way to reach step 1
        dp[2] = 2;  // 2 ways to reach step 2

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
