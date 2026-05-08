package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Product of Array Except Self
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums, return an array answer such that answer[i] is equal to the
 * product of all the elements of nums except nums[i].
 *
 * Input: int[] nums = {1, 2, 3, 4}
 * Output: int[] = {24, 12, 8, 6}
 *
 * Video Explanation: https://www.youtube.com/watch?v=UxmLwxH-lhM
 * LeetCode Problem Link: https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Input: nums = [1, 2, 3, 4]");
        System.out.println("Output: " + Arrays.toString(solution(nums)));
    }

    // Prefix-Suffix approach: O(n) time, O(1) extra space
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products
        // result[i] = product of all elements to the LEFT of i (excluding nums[i])
        result[0] = 1; // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products and combine
        // Maintain a running suffix product as we traverse from right to left
        int suffix = 1; // Product of all elements to the RIGHT
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix; // Multiply prefix by suffix
            suffix *= nums[i];   // Update suffix for next iteration
        }
        return result;
    }

    // Alternative: Explicit left and right arrays (O(n) space)
    public static int[] alternativeSolution(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // left[i] = product of all elements to the left of i
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // right[i] = product of all elements to the right of i
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Combine left and right products
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}