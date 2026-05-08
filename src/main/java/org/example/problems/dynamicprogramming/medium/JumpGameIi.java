package org.example.problems.dynamicprogramming.medium;

/**
 * Problem: Jump Game II (LeetCode 45)
 * Topic: Dynamic Programming, Greedy, Array
 * Level: Medium
 *
 * Problem Description:
 * You are given a 0-indexed array of integers nums of length n.
 * You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * - 0 <= j <= nums[i] and
 * - i + j < n
 *
 * Return the minimum number of jumps to reach nums[n - 1].
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Video Explanation: https://www.youtube.com/watch?v=d_1GRnMg_zs
 * LeetCode Problem Link: https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameIi {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test 1 (Greedy): " + solution(nums1)); // Expected: 2

        // Test case 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test 2 (Greedy): " + solution(nums2)); // Expected: 2

        // Test case 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Test 3 (Greedy): " + solution(nums3)); // Expected: 2

        // Test case 4
        int[] nums4 = {1, 1, 1, 1};
        System.out.println("Test 4 (Greedy): " + solution(nums4)); // Expected: 3

        // Alternative solution tests
        System.out.println("\nAlternative Solution (DP) Tests:");
        System.out.println("Test 1: " + alternativeSolution(nums1)); // Expected: 2
        System.out.println("Test 2: " + alternativeSolution(nums2)); // Expected: 2
    }

    /**
     * Greedy approach - track the range of each jump.
     * For each jump, find the maximum reach within the current range.
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(1)
     *
     * @param nums array where nums[i] is the maximum jump length from index i
     * @return minimum number of jumps to reach the last index
     */
    public static int solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0; // End of the current jump range
        int farthest = 0;   // Farthest index reachable so far

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index we can reach from current position
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Early termination: if we can already reach the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    /**
     * Dynamic Programming approach - Bottom-up.
     * dp[i] = minimum number of jumps to reach index i
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param nums array where nums[i] is the maximum jump length
     * @return minimum number of jumps to reach the last index
     */
    public static int alternativeSolution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];

        // Initialize with a value larger than any possible answer
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        dp[0] = 0; // No jumps needed to reach starting position

        for (int i = 0; i < n; i++) {
            // For each index we can reach from position i
            int maxJump = nums[i];
            for (int jump = 1; jump <= maxJump && i + jump < n; jump++) {
                dp[i + jump] = Math.min(dp[i + jump], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}
