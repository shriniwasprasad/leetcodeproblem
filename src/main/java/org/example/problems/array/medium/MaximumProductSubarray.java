package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Maximum Product Subarray
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums, find the subarray with the largest product, and return the product.
 *
 * Input: int[] nums = {2, 3, -2, 4}
 * Output: int = 6 (subarray [2, 3])
 *
 * Video Explanation: https://www.youtube.com/watch?v=OuRQ_TCCjsU
 * LeetCode Problem Link: https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Input: nums = [2, 3, -2, 4]");
        System.out.println("Output: " + solution(nums));
    }

    // Track both max and min products at each position
    // Key insight: A negative number can flip max to min and vice versa
    public static int solution(int[] nums) {
        int maxProd = nums[0];  // Maximum product ending at current position
        int minProd = nums[0];   // Minimum product ending at current position
        int result = nums[0];    // Global maximum product seen

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Three candidates: curr alone, curr * maxProd, curr * minProd
            // Arrays.stream and max/min finds best of three
            int[] candidates = {curr, curr * maxProd, curr * minProd};
            maxProd = Arrays.stream(candidates).max().getAsInt();
            minProd = Arrays.stream(candidates).min().getAsInt();

            // Update global maximum
            result = Math.max(result, maxProd);
        }
        return result;
    }

    // Alternative: Swap max and min when current number is negative
    public static int alternativeSolution(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // If current is negative, max and min roles swap
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Either start fresh at current element or extend previous product
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            // Track best result seen
            result = Math.max(result, maxProd);
        }
        return result;
    }
}