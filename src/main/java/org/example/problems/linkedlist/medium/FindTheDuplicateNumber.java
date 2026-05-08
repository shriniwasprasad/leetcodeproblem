package org.example.problems.linkedlist.medium;

import java.util.*;

/**
 * Problem: Find the Duplicate Number (LeetCode 287)
 * Topic: Array, Binary Search, Two Pointers
 * Level: Medium
 *
 * Problem Description:
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 *
 * Video Explanation: https://www.youtube.com/watch?v=Lu3if4xOA1s
 * LeetCode Problem Link: https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Test 1 (Hash Set): " + solution(nums1));  // Expected: 2

        // Test case 2
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Test 2 (Hash Set): " + solution(nums2));  // Expected: 3

        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test 3 (Hash Set): " + solution(nums3));  // Expected: 3

        // Alternative solution tests (Floyd's Tortoise and Hare)
        System.out.println("\nAlternative Solution Tests:");
        int[] nums4 = {1, 3, 4, 2, 2};
        System.out.println("Test 1 (Floyd's): " + alternativeSolution(nums4));  // Expected: 2

        int[] nums5 = {3, 1, 3, 4, 2};
        System.out.println("Test 2 (Floyd's): " + alternativeSolution(nums5));  // Expected: 3
    }

    /**
     * Hash Set approach to find the duplicate number.
     * Track seen numbers and return when we find a duplicate.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums array of integers with one duplicate
     * @return the duplicate number
     */
    public static int solution(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // If already seen, this is the duplicate
            if (!seen.add(num)) {
                return num;
            }
        }

        return -1;  // Should never reach here per problem constraints
    }

    /**
     * Floyd's Tortoise and Hare algorithm (Cycle Detection).
     * Treat array as a linked list where nums[i] is the next pointer.
     * The duplicate creates a cycle, which we detect.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums array of integers with one duplicate
     * @return the duplicate number
     */
    public static int alternativeSolution(int[] nums) {
        // Phase 1: Find intersection point of two runners
        // Move slow by 1 step and fast by 2 steps
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
