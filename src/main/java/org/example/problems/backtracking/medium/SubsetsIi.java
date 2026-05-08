package org.example.problems.backtracking.medium;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Subsets II
 * Topic: Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums that may contain duplicates, return all possible subsets.
 * The solution set must not contain duplicate subsets.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsIi {

    public static void main(String[] args) {
        System.out.println("=== SubsetsIi ===");
        int[] nums = {1, 2, 2};
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Result: " + solution(nums));
        System.out.println("Alternative Result: " + alternativeSolution(nums));
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> alternativeSolution(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        return backtrackStream(sortedNums, 0);
    }

    private static List<List<Integer>> backtrackStream(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Base case: empty subset

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            int finalI = i;
            List<List<Integer>> nextSubsets = backtrackStream(nums, i + 1).stream()
                .map(subset -> {
                    List<Integer> newSubset = new ArrayList<>();
                    newSubset.add(nums[finalI]);
                    newSubset.addAll(subset);
                    return newSubset;
                })
                .collect(Collectors.toList());
            result.addAll(nextSubsets);
        }
        return result;
    }
}
