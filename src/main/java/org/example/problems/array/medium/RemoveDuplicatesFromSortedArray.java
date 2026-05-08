package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Remove Duplicates from Sorted Array
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given a sorted array nums, remove the duplicates in-place such that each unique element appears only once.
 *
 * Input: int[] nums = {1, 1, 2}
 * Output: int = 2 (nums becomes [1, 2, _])
 *
 * Video Explanation: https://www.youtube.com/watch?v=0F49FLuzScU
 * LeetCode Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println("Input: nums = [1, 1, 2]");
        System.out.println("Output: " + solution(nums));
        System.out.println("Array after: " + Arrays.toString(nums));
    }

    // Two-pointer technique: slow pointer marks end of unique elements
    // Time: O(n), Space: O(1)
    public static int solution(int[] nums) {
        if (nums.length == 0) return 0;

        // Pointer for the position to place next unique element
        int unique = 1; // First element is always unique

        // Scan through array with read pointer
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                // Found new unique element, place it at unique position
                nums[unique] = nums[i];
                unique++;
            }
            // If duplicate, skip (don't increment unique)
        }
        return unique;
    }

    // Alternative: Write pointer technique (same logic, different variable names)
    public static int alternativeSolution(int[] nums) {
        int write = 0; // Position to write next unique element

        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write]) {
                write++; // Move to next write position
                nums[write] = nums[read]; // Write unique element
            }
            // If duplicate, read continues but write stays
        }
        return write + 1; // +1 because write is index, count is index + 1
    }
}