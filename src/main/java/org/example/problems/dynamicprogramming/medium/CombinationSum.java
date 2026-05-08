package org.example.problems.dynamicprogramming.medium;

import java.util.*;

/**
 * Problem: Combination Sum (LeetCode 39)
 * Topic: Backtracking, Dynamic Programming
 * Level: Medium
 *
 * Problem Description:
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=dJBbuDK4ZRk
 * LeetCode Problem Link: https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {
        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Test 1: " + solution(candidates1, target1));
        // Expected: [[2,2,3],[7]]

        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Test 2: " + solution(candidates2, target2));
        // Expected: [[2,2,2,2],[2,3,3],[3,5]]

        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Test 3: " + solution(candidates3, target3));
        // Expected: []

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        int[] candidates4 = {2, 3, 6, 7};
        System.out.println("Test 1: " + alternativeSolution(candidates4, 7));
        int[] candidates5 = {2, 3, 5};
        System.out.println("Test 2: " + alternativeSolution(candidates5, 8));
    }

    /**
     * Backtracking approach to find all combinations that sum to target.
     * At each step, we can either:
     * - Include the current candidate (and stay at same index since we can reuse)
     * - Skip the current candidate (move to next index)
     * Time Complexity: O(2^n) where n is the number of candidates
     * Space Complexity: O(target/min(candidates)) for recursion stack
     *
     * @param candidates array of distinct integers
     * @param target the target sum
     * @return list of all unique combinations
     */
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to enable early termination
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    /**
     * Backtracking helper method.
     * @param result list to store valid combinations
     * @param current current combination being built
     * @param candidates array of candidate numbers
     * @param target remaining target sum
     * @param start index to start considering candidates from
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> current,
                                   int[] candidates, int target, int start) {
        // Base case: found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Base case: exceeded target
        if (target < 0) {
            return;
        }

        // Try each candidate from start index
        for (int i = start; i < candidates.length; i++) {
            // Early termination: if current candidate exceeds target, no point continuing
            if (candidates[i] > target) {
                break;
            }

            // Include current candidate
            current.add(candidates[i]);

            // Recurse: note we pass i (not i+1) because we can reuse the same element
            backtrack(result, current, candidates, target - candidates[i], i);

            // Backtrack: remove the last added element
            current.remove(current.size() - 1);
        }
    }

    /**
     * Dynamic Programming approach to find all combinations.
     * dp[i] = all combinations that sum to i
     * For each candidate, update all dp entries where the candidate can be included.
     * Time Complexity: O(2^n) in worst case
     * Space Complexity: O(target * 2^n) to store all combinations
     *
     * @param candidates array of candidate numbers
     * @param target the target sum
     * @return list of all unique combinations
     */
    public static List<List<Integer>> alternativeSolution(int[] candidates, int target) {
        // dp[i] stores all combinations that sum to i
        List<List<Integer>>[] dp = new List[target + 1];

        // Initialize all entries
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }

        // Base case: empty combination sums to 0
        dp[0].add(new ArrayList<>());

        // For each candidate, update all possible sums
        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                // For each combination that sums to (i - candidate)
                for (List<Integer> prevCombo : dp[i - candidate]) {
                    // Create a new combination by adding current candidate
                    List<Integer> newCombo = new ArrayList<>(prevCombo);
                    newCombo.add(candidate);

                    // Sort to maintain consistent ordering
                    Collections.sort(newCombo);

                    // Add to dp[i] if not already present
                    if (!dp[i].contains(newCombo)) {
                        dp[i].add(newCombo);
                    }
                }
            }
        }

        return dp[target];
    }
}
