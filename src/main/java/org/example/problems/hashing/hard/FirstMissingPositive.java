package org.example.problems.hashing.hard;

import java.util.*;

/**
 * Problem: First Missing Positive
 * Topic: Hashing
 * Level: Hard
 *
 * Problem Description:
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * Must run in O(n) time and use O(1) extra space.
 *
 * Input: int[] nums = {1, 2, 0}
 * Output: int = 3
 *
 * Video Explanation: https://www.youtube.com/watch?v=N8DefKVUIKw
 * LeetCode Problem Link: https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println("Input: nums = [1, 2, 0]");
        System.out.println("Output: " + solution(nums));
    }

    // Index-based marking: O(n) time, O(1) space
    // Key insight: Place each number at its corresponding index (num - 1)
    // Numbers out of range [1, n] are ignored; missing index indicates missing number
    public static int solution(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct position (num - 1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctPos = nums[i] - 1;
                int temp = nums[correctPos];
                nums[correctPos] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first position where the number doesn't match index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All positions [1..n] are filled, answer is n + 1
        return n + 1;
    }

    // Alternative: HashSet approach (O(n) time but O(n) space)
    public static int alternativeSolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}