package org.example.problems.array.medium;


/**
 * Problem: Maximum Subarray
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Input: int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * Output: int = 6 (subarray [4, -1, 2, 1])
 *
 * Video Explanation: https://www.youtube.com/watch?v=nr2djEYM7_A
 * LeetCode Problem Link: https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + solution(nums));
    }

    // Kadane's Algorithm: Track current subarray sum and global max
    // Key insight: If current sum becomes negative, start fresh from next element
    public static int solution(int[] nums) {
        int maxSum = nums[0];     // Global maximum seen so far
        int currentSum = nums[0]; // Sum of subarray ending at current position

        for (int i = 1; i < nums.length; i++) {
            // Two choices: extend previous subarray OR start new subarray at current element
            // If currentSum is negative, starting fresh is better
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update global max if current subarray is the best seen
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Alternative: Same logic, slightly different implementation
    public static int alternativeSolution(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Calculate new sum: either extend previous or start new
            int newSum = currentSum + nums[i];
            // Choose better option: start new or continue from previous
            currentSum = Math.max(nums[i], Math.max(newSum, nums[i] + currentSum));
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}