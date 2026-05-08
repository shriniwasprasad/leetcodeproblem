package org.example.problems.array.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Two Sum
 * Topic: Array
 * Level: Easy
 * <p>
 * Problem Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume exactly one solution exists.
 * <p>
 * Input: int[] nums = {2, 7, 11, 15}; int target = 9
 * Output: int[] = {0, 1} (nums[0] + nums[1] = 2 + 7 = 9)
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=BQ2IJ-fouJ4">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/two-sum/">...</a>
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Input: nums = [2, 7, 11, 15], target = " + target);
        System.out.println("Output: " + Arrays.toString(solution(nums, target)));
    }

    // HashMap approach: O(n) time, O(n) space
    // For each number, check if its complement (target - num) already exists in map
    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Calculate what number we need to pair with nums[i]
            int complement = target - nums[i];

            // If complement exists in map, we found our pair
            if (map.containsKey(complement)) {
                // Return indices: complement's index and current index
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index for future lookups
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Alternative: Brute force - O(n²) time, O(1) space
    // Check all pairs to find matching sum
    public static int[] alternativeSolution(int[] nums, int target) {
        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{i, j}))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No two sum solution"));
    }
}