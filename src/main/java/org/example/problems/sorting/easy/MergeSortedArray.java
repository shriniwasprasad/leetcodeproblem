package org.example.problems.sorting.easy;

import java.util.*;

/**
 * Problem: Merge Sorted Array
 * Topic: Sorting
 * Level: Easy
 *
 * Problem Description:
 * Given two sorted integer arrays nums1 and nums2, and two integers m and n,
 * merge nums2 into nums1 as one sorted array in-place.
 *
 * Input: nums1 = [1,2,3], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 *
 * Video Explanation: https://www.youtube.com/watch?v=05mXJB5SLA8
 * LeetCode Problem Link: https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        System.out.println("=== MergeSortedArray ===");
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]
    }

    /**
     * Solution: Three-pointer approach from the end.
     * Compare elements from both arrays from the end and place in nums1.
     * Time: O(m+n), Space: O(1)
     */
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

    /**
     * Alternative Solution: Using Stream API to merge and sort.
     * Time: O((m+n) log (m+n)), Space: O(m+n)
     */
    public static int[] alternativeStreamSolution(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) result.add(nums1Copy[i]);
        for (int i = 0; i < n; i++) result.add(nums2[i]);
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
