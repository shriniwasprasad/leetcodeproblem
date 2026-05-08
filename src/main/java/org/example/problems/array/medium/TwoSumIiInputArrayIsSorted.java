package org.example.problems.array.medium;

import java.util.Arrays;


/**
 * Problem: Two Sum II Input Array Is Sorted
 * Topic: Two Pointers
 * Level: Medium
 *
 * Problem Description:
 * Given a 1-indexed array of integers nums sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers, added by one, as an array [index1, index2] of length 2.
 *
 * Example 1:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Expected Output: [1, 2]
 *
 * Example 2:
 * Input: nums = [2, 3, 4], target = 6
 * Expected Output: [1, 3]
 *
 * Example 3:
 * Input: nums = [-1, 0], target = -1
 * Expected Output: [1, 2]
 *
 * Video Explanation: https://www.youtube.com/watch?v=c9ywRRJcP1Y
 * LeetCode Problem Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIiInputArrayIsSorted {

    public static void main(String[] args) {
        System.out.println("=== TwoSumIiInputArrayIsSorted ===");

        int[] test1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test 1: nums=" + Arrays.toString(test1) + ", target=" + target1);
        System.out.println("Result: " + Arrays.toString(solution(test1, target1))); // [1, 2]
        System.out.println("Expected: [1, 2]\n");

        int[] test2 = {2, 3, 4};
        int target2 = 6;
        System.out.println("Test 2: nums=" + Arrays.toString(test2) + ", target=" + target2);
        System.out.println("Result: " + Arrays.toString(solution(test2, target2))); // [1, 3]
        System.out.println("Expected: [1, 3]\n");
    }

    /**
     * Solution 1: Two-Pointer Approach (Optimal for Sorted Arrays)
     *
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1)
     *
     * Algorithm:
     * - Initialize left pointer at 0 and right pointer at length-1.
     * - While left < right:
     *   - Calculate current sum = nums[left] + nums[right].
     *   - If sum == target: return indices [left + 1, right + 1].
     *   - If sum < target: increment left pointer to increase sum.
     *   - If sum > target: decrement right pointer to decrease sum.
     */
    public static int[] solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Solution 2: Binary Search Approach (Alternative)
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     *
     * Algorithm:
     * - For each element nums[i], binary search for (target - nums[i]) in the remaining part of the array.
     */
    public static int[] alternativeSolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int low = i + 1, high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == complement) {
                    return new int[]{i + 1, mid + 1};
                } else if (nums[mid] < complement) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
