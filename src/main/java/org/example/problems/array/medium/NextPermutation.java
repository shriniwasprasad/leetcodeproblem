package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Next Permutation
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given an array of integers nums, find the next permutation of nums.
 * A permutation is an arrangement of all elements where order matters.
 *
 * Input: int[] nums = {1, 2, 3}
 * Output: [1, 3, 2]
 *
 * Video Explanation: https://www.youtube.com/watch?v=oc3OOtGmH6U
 * LeetCode Problem Link: https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Input: nums = [1, 2, 3]");
        solution(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    // In-place algorithm: O(n) time, O(1) space
    // Steps: 1) Find largest index i where nums[i] < nums[i+1]
    //        2) Find largest index j > i where nums[j] > nums[i]
    //        3) Swap nums[i] and nums[j]
    //        4) Reverse the suffix from i+1 to end
    public static void solution(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from the right
        // This is the "pivot" that we need to swap
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the element just larger than nums[i] in the suffix
            // The suffix is already in non-increasing order, so scanning from right finds it fastest
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap pivot with the found element
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix (now it's the smallest permutation)
        // This gives us the next lexicographic permutation
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Alternative: Generate all permutations and find next (inefficient)
    public static void alternativeSolution(int[] nums) {
        int n = nums.length;
        List<int[]> permutations = new ArrayList<>();

        // Generate all permutations via backtracking
        permute(permutations, nums.clone(), 0);

        // Sort permutations lexicographically
        Collections.sort(permutations, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return a[i] - b[i];
            }
            return 0;
        });

        // Find current permutation and return the next one
        for (int i = 0; i < permutations.size(); i++) {
            if (Arrays.equals(permutations.get(i), nums)) {
                if (i + 1 < permutations.size()) {
                    System.arraycopy(permutations.get(i + 1), 0, nums, 0, n);
                }
                break;
            }
        }
    }

    private static void permute(List<int[]> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(nums.clone());
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(result, nums, start + 1);
                swap(nums, start, i); // Backtrack
            }
        }
    }
}