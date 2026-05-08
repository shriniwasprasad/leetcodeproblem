package org.example.problems.backtracking.medium;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Subsets
 * Topic: Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println("=== Subsets ===");
        int[] nums = {1, 2, 3};
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Result: " + solution(nums));
        System.out.println("Alternative Result: " + alternativeSolution(nums));
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> alternativeSolution(int[] nums) {
        int n = nums.length;
        return IntStream.range(0, 1 << n)
            .mapToObj(i -> IntStream.range(0, n)
                .filter(j -> (i & (1 << j)) != 0)
                .map(j -> nums[j])
                .boxed()
                .collect(Collectors.toList()))
            .collect(Collectors.toList());
    }
}
