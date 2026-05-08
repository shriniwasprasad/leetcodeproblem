package org.example.problems.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Contains Duplicate II
 * Topic: Array
 * Level: Easy
 * <p>
 * Problem Description:
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Input: int[] nums = {1, 2, 3, 1}; int k = 3
 * Output: boolean = true (nums[0] == nums[3] and |0-3| = 3 <= k)
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=Te_MCY4uG-M">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/contains-duplicate-ii/">...</a>
 */
public class ContainsDuplicateIi {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println("Input: nums = [1, 2, 3, 1], k = " + k);
        System.out.println("Output: " + solution(nums, k));
    }

    // Sliding window with HashSet: O(n) time, O(k) space
    // Maintain a window of size k+1, check if current element exists in window
    public static boolean solution(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove element that is now too far (more than k indices behind)
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // If current element exists in window (within k distance), found match
            if (window.contains(nums[i])) {
                return true;
            }

            // Add current element to window
            window.add(nums[i]);
        }
        return false;
    }

    // Alternative: HashMap storing last seen index - O(n) time, O(n) space
    // Track most recent index of each value, check if distance <= k
    public static boolean alternativeSolution(int[] nums, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Check if current number was seen within k distance
            if (lastSeen.containsKey(nums[i]) && i - lastSeen.get(nums[i]) <= k) {
                return true;
            }
            // Update last seen index
            lastSeen.put(nums[i], i);
        }
        return false;
    }
}