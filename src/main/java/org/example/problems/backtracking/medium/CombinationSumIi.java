package org.example.problems.backtracking.medium;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Combination Sum II
 * Topic: Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumIi {

    public static void main(String[] args) {
        System.out.println("=== CombinationSumIi ===");
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println("Candidates: " + Arrays.toString(candidates) + ", Target: " + target);
        System.out.println("Result: " + solution(candidates, target));
        System.out.println("Alternative Result: " + alternativeSolution(candidates, target));
    }

    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] <= remaining) {
                currentCombination.add(candidates[i]);
                backtrack(result, currentCombination, candidates, remaining - candidates[i], i + 1);
                currentCombination.remove(currentCombination.size() - 1);
            } else {
                break;
            }
        }
    }

    public static List<List<Integer>> alternativeSolution(int[] candidates, int target) {
        int[] sortedCandidates = candidates.clone();
        Arrays.sort(sortedCandidates);
        return backtrackStream(sortedCandidates, target, 0);
    }

    private static List<List<Integer>> backtrackStream(int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        if (remaining < 0) return Collections.emptyList();

        return IntStream.range(start, candidates.length)
            .filter(i -> i == start || candidates[i] != candidates[i - 1])
            .filter(i -> candidates[i] <= remaining)
            .mapToObj(i -> {
                List<List<Integer>> subResults = backtrackStream(candidates, remaining - candidates[i], i + 1);
                return subResults.stream()
                    .map(list -> {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(candidates[i]);
                        newList.addAll(list);
                        return newList;
                    })
                    .collect(Collectors.toList());
            })
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}
