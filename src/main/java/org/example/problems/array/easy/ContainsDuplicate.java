package org.example.problems.array.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Contains Duplicate
 * Topic: Array
 * Level: Easy
 * <p>
 * Problem Description:
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and false if every element is distinct.
 * <p>
 * Input: int[] nums = {1, 2, 3, 1}
 * Output: boolean = true (1 appears twice)
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=c_q_Pc2yg_0">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/contains-duplicate/">...</a>
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Input: nums = [1, 2, 3, 1]");
        System.out.println("Output: " + solution(nums));
    }

    // HashSet approach: O(n) time, O(n) space
    // If we encounter an element already in set, there's a duplicate
    public static boolean solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            // If set already contains this number, we found a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Add current number to set
            set.add(num);
        }
        // No duplicates found
        return false;
    }

    // Alternative: Compare set size to array length - O(n) time, O(n) space
    // If set has fewer elements than array, duplicates must exist
    public static boolean alternativeSolution(int[] nums) {
        return nums.length != Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();
    }
}