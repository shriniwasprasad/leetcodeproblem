package org.example.problems.array.medium;


/**
 * Problem: Search in Rotated Sorted Array
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated.
 * Given the array nums after rotation and an integer target, return the index of target if it is in nums, or -1 otherwise.
 *
 * Input: int[] nums = {4, 5, 6, 7, 0, 1, 2}; int target = 0
 * Output: int = 4
 *
 * Video Explanation: https://www.youtube.com/watch?v=sE_4DzVc71w
 * LeetCode Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Input: nums = [4, 5, 6, 7, 0, 1, 2], target = " + target);
        System.out.println("Output: " + solution(nums, target));
    }

    // Modified binary search: Determine which half is properly sorted
    // Then check if target lies within the sorted half
    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found target
            }

            // Check if left half is sorted (no rotation between left and mid)
            if (nums[left] <= nums[mid]) {
                // Left half is sorted, check if target is in this range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in left half
                } else {
                    left = mid + 1;  // Target is in right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target is in right half
                } else {
                    right = mid - 1; // Target is in left half
                }
            }
        }
        return -1; // Target not found
    }

    // Alternative: Find pivot first, then search appropriate half
    public static int alternativeSolution(int[] nums, int target) {
        // Find the rotation pivot (minimum element)
        int pivot = findPivot(nums);
        if (pivot == -1) {
            // Array is not rotated, binary search normally
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Check if target is at pivot
        if (nums[pivot] == target) {
            return pivot;
        }

        // Determine which half to search based on first element
        if (nums[0] <= target) {
            // Target is in left half (elements before pivot)
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            // Target is in right half (elements after pivot)
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    // Find index of minimum element (rotation point)
    private static int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if mid is the point of rotation
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return mid; // Found pivot
            }
            if (mid > left && nums[mid] < nums[mid - 1]) {
                return mid - 1; // Mid-1 is pivot
            }

            // Decide which half to search
            if (nums[left] >= nums[mid]) {
                right = mid - 1; // Pivot is in left half
            } else {
                left = mid + 1;  // Pivot is in right half
            }
        }
        return -1; // Not found (array not rotated)
    }

    // Standard binary search
    private static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}