package org.example.problems.array.hard;


/**
 * Problem: Median of Two Sorted Arrays
 * Topic: Array
 * Level: Hard
 * <p>
 * Problem Description:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * <p>
 * Input: int[] nums1 = {1, 3}; int[] nums2 = {2}
 * Output: double = 2.0
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=LRM4qiHLYCE">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">...</a>
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Input: nums1 = [1, 3], nums2 = [2]");
        System.out.println("Output: " + solution(nums1, nums2));
    }

    // Binary search on partition: O(log(min(m,n))) time
    // Key idea: Find partition in smaller array such that all left elements <= all right elements
    public static double solution(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for binary search efficiency
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // Binary search on nums1 to find correct partition
        int left = 0;
        int right = m;

        while (left <= right) {
            // Partition nums1 at midX, nums2 at midY
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX; // +1 for odd handling

            // Get boundary elements (use MIN/MAX for edge cases)
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if partition is correct:
            // maxLeftX <= minRightY AND maxLeftY <= minRightX
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found correct partition
                if ((m + n) % 2 == 0) {
                    // Even total: average of max left and min right
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // Odd total: max of left elements
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // Partition is too far right in nums1, move left
                right = partitionX - 1;
            } else {
                // Partition is too far left in nums1, move right
                left = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }

    // Alternative: Merge arrays then find median (O(m+n) time, O(m+n) space)
    public static double alternativeSolution(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int[] merged = new int[totalLen];

        // Merge two sorted arrays
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) merged[k++] = nums1[i++];
        while (j < nums2.length) merged[k++] = nums2[j++];

        // Find median from merged array
        int mid = totalLen / 2;
        if (totalLen % 2 == 0) {
            return (merged[mid - 1] + merged[mid]) / 2.0;
        } else {
            return merged[mid];
        }
    }
}