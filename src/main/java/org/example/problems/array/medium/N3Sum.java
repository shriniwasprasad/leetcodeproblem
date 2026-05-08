package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: 3 Sum
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Input: int[] nums = {-1, 0, 1, 2, -1, -4}
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * Video Explanation: https://www.youtube.com/watch?v?v=wtloSzFYvho
 * LeetCode Problem Link: https://leetcode.com/problems/3-sum/
 */
public class N3Sum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: nums = [-1, 0, 1, 2, -1, -4]");
        System.out.println("Output: " + solution(nums));
    }

    // Sort + Two-pointer: Fix one element, find pair that sums to negative of it
    // Time: O(n²), Space: O(1) excluding output
    public static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums); // Sort to enable two-pointer and duplicate handling
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;   // Second pointer
            int right = nums.length - 1; // Third pointer

            // Two-pointer search for pair that sums to -nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers after finding a match
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum too small, need larger left value
                    left++;
                } else {
                    // Sum too large, need smaller right value
                    right--;
                }
            }
        }
        return result;
    }

    // Alternative: Brute force with HashSet for deduplication (O(n³) time)
    public static List<List<Integer>> alternativeSolution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> seen = new HashSet<>(); // Deduplication set

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Create unique key for triplet to avoid duplicates
                        String key = nums[i] + "," + nums[j] + "," + nums[k];
                        if (!seen.contains(key)) {
                            seen.add(key);
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return result;
    }
}