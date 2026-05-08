package org.example.problems.heap.medium;

import java.util.*;

/**
 * Problem: Kth Largest Element in an Array
 * Topic: Heap
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Input: int[] nums = {3, 2, 1, 5, 6, 4}; int k = 2
 * Output: int = 5 (2nd largest is 5)
 *
 * Video Explanation: https://www.youtube.com/watch?v=kmUL7CAOSwc
 * LeetCode Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Input: nums = [3, 2, 1, 5, 6, 4], k = " + k);
        System.out.println("Output: " + solution(nums, k));
    }

    // Min-heap approach: O(n log k) time, O(k) space
    // Key insight: Keep k largest elements in min-heap, top of heap is kth largest
    public static int solution(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest to maintain k elements
            }
        }
        return minHeap.peek(); // Top is kth largest
    }

    // Alternative: Quickselect algorithm O(n) average time, O(1) space
    public static int alternativeSolution(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int kth) {
        int pivot = left;
        int l = left + 1;
        int r = right;

        while (r >= l) {
            if (nums[r] < nums[pivot] && nums[l] > nums[pivot]) {
                swap(nums, l, r);
            }
            if (nums[l] <= nums[pivot]) l++;
            if (nums[r] >= nums[pivot]) r--;
        }
        swap(nums, pivot, r);

        if (kth == r) return nums[r];
        else if (kth < r) return quickSelect(nums, left, r - 1, kth);
        else return quickSelect(nums, r + 1, right, kth);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}