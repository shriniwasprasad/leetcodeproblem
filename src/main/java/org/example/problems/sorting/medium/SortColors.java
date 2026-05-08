package org.example.problems.sorting.medium;

import java.util.*;

/**
 * Problem: Sort Colors (Dutch National Flag)
 * Topic: Sorting / Three-way Partition
 * Level: Medium
 *
 * Problem Description:
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Video Explanation: https://www.youtube.com/watch?v=HO-qzdL_x8U
 * LeetCode Problem Link: https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public static void main(String[] args) {
        System.out.println("=== SortColors ===");
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution(nums);
        System.out.println(Arrays.toString(nums)); // [0, 0, 1, 1, 2, 2]
    }

    /**
     * Solution: Dutch National Flag algorithm with three pointers.
     * Time: O(n), Space: O(1)
     */
    public static void solution(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Alternative Solution: Counting sort (two-pass).
     * Count occurrences of each color, then fill the array.
     * Time: O(n), Space: O(1)
     */
    public static void alternativeSolution(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int i = 0;
        while (count0-- > 0) nums[i++] = 0;
        while (count1-- > 0) nums[i++] = 1;
        while (count2-- > 0) nums[i++] = 2;
    }

    /**
     * Alternative Solution: Stream API.
     * Time: O(n log n), Space: O(n)
     */
    public static int[] alternativeStreamSolution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
