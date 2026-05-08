package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Find First and Last Position of Element in Sorted Array
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * Input: int[] nums = {5, 7, 7, 8, 8, 10}; int target = 8
 * Output: int[] = {3, 4}
 *
 * Video Explanation: https://www.youtube.com/watch?v=aPD6g96fRO4
 * LeetCode Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("Input: nums = [5, 7, 7, 8, 8, 10], target = " + target);
        System.out.println("Output: " + Arrays.toString(solution(nums, target)));
    }

    // Binary search to find both first and last position
    // Find first: when target found, continue searching LEFT
    // Find last: when target found, continue searching RIGHT
    public static int[] solution(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find first occurrence (search left half when target found)
        result[0] = findBound(nums, target, true);
        // Only search for last if first was found
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }
        return result;
    }

    // Helper: Binary search for first or last position
    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Found target, remember position
                // Continue searching in appropriate direction
                if (isFirst) {
                    right = mid - 1; // Search left for first occurrence
                } else {
                    left = mid + 1;  // Search right for last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }

    // Alternative: Separate binary searches for first and last
    public static int[] alternativeSolution(int[] nums, int target) {
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        return new int[]{first, last};
    }

    // Find first position: narrow to leftmost boundary
    private static int binarySearchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid; // mid could be first occurrence
            }
        }
        return nums[left] == target ? left : -1;
    }

    // Find last position: narrow to rightmost boundary
    private static int binarySearchLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2; // Round up to avoid infinite loop
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid; // mid could be last occurrence
            }
        }
        return nums[right] == target ? right : -1;
    }
}