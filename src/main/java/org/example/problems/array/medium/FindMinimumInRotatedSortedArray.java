package org.example.problems.array.medium;


/**
 * Problem: Find Minimum in Rotated Sorted Array
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * Given the sorted rotated array nums of unique elements, return the minimum element.
 *
 * Input: int[] nums = {3, 4, 5, 1, 2}
 * Output: int = 1
 *
 * Video Explanation: https://www.youtube.com/watch?v=Dr69TSfv9JI
 * LeetCode Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Input: nums = [3, 4, 5, 1, 2]");
        System.out.println("Output: " + solution(nums));
    }

    // Binary Search: Minimum element is where the "rotation" starts
    // In a rotated array, the minimum is the only point where next element is smaller
    public static int solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than right element,
            // minimum must be in the right half (including mid)
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right]: minimum is in left half (including mid)
                // This means mid could be the minimum or it's to the left
                right = mid;
            }
        }
        // left == right is the index of minimum element
        return nums[left];
    }

    // Alternative: Same binary search logic, different condition placement
    public static int alternativeSolution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // If middle element is less than right element,
            // search left side (mid could be minimum)
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // nums[mid] >= nums[right]: minimum must be in right half
                left = mid + 1;
            }
        }
        return nums[right];
    }
}