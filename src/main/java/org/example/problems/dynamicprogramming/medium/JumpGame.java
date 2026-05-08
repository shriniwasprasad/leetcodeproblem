package org.example.problems.dynamicprogramming.medium;

/**
 * Problem: Jump Game (LeetCode 55)
 * Topic: Dynamic Programming, Greedy, Array
 * Level: Medium
 *
 * Problem Description:
 * You are given an integer array nums. You are initially positioned at the array's first index
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * which makes it impossible to reach the last index.
 *
 * Video Explanation: https://www.youtube.com/watch?v=PVNLmjJaHW0
 * LeetCode Problem Link: https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1 (Greedy): " + solution(nums1));  // Expected: true

        // Test case 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test 2 (Greedy): " + solution(nums2));  // Expected: false

        // Test case 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Test 3 (Greedy): " + solution(nums3));  // Expected: true

        // Test case 4
        int[] nums4 = {2, 0, 0};
        System.out.println("Test 4 (Greedy): " + solution(nums4));  // Expected: true

        // Alternative solution (DP) tests
        System.out.println("\nAlternative Solution (DP) Tests:");
        System.out.println("Test 1: " + alternativeSolution(nums1));  // Expected: true
        System.out.println("Test 2: " + alternativeSolution(nums2));  // Expected: false
    }

    /**
     * Greedy approach - track the maximum reachable index.
     * If at any point the current index is beyond max reach, return false.
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(1)
     *
     * @param nums array where nums[i] is the maximum jump length from index i
     * @return true if last index is reachable, false otherwise
     */
    public static boolean solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int maxReach = 0;  // Maximum index we can reach so far

        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond our max reach, we can't reach it
            if (i > maxReach) {
                return false;
            }

            // Update maximum reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early termination: if we can already reach the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return maxReach >= nums.length - 1;
    }

    /**
     * Dynamic Programming approach - Bottom-up.
     * dp[i] = true if index i is reachable from index 0.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param nums array where nums[i] is the maximum jump length
     * @return true if last index is reachable, false otherwise
     */
    public static boolean alternativeSolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;  // Starting position is always reachable

        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                // Current index is not reachable, skip
                continue;
            }

            // Mark all reachable indices from current position
            int maxJump = nums[i];
            for (int jump = 1; jump <= maxJump && i + jump < n; jump++) {
                dp[i + jump] = true;
            }

            // Early termination
            if (dp[n - 1]) {
                return true;
            }
        }

        return dp[n - 1];
    }
}
