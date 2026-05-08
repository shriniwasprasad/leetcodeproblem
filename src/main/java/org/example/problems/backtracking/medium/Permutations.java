package org.example.problems.backtracking.medium;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Permutations
 * Topic: Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given an array nums of distinct integers, return all possible permutations.
 * This is the complete set of permutations in any order.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println("=== Permutations ===");
        int[] nums = {1, 2, 3};
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Result: " + solution(nums));
        System.out.println("Alternative Result: " + alternativeSolution(nums));
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static List<List<Integer>> alternativeSolution(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        if (nums.length == 1) {
            return Collections.singletonList(Collections.singletonList(nums[0]));
        }

        return IntStream.range(0, nums.length)
            .mapToObj(i -> {
                int[] remaining = new int[nums.length - 1];
                int idx = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i != j) remaining[idx++] = nums[j];
                }

                return alternativeSolution(remaining).stream()
                    .map(list -> {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(nums[i]);
                        newList.addAll(list);
                        return newList;
                    })
                    .collect(Collectors.toList());
            })
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}
