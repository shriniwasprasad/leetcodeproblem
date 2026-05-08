package org.example.problems.dynamicprogramming.medium;

import java.util.*;

/**
 * Problem: Partition Equal Subset Sum
 * Topic: 1-D Dynamic Programming / Subset Sum
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums, determine if it can be partitioned into two subsets
 * with equal sum.
 *
 * Input: nums = [1,5,11,5]
 * Output: true (partition into [1,5,5] and [11])
 *
 * Video Explanation: https://www.youtube.com/watch?v=X50Rknzenus
 * LeetCode Problem Link: https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println("=== PartitionEqualSubsetSum ===");
        System.out.println(solution(new int[]{1, 5, 11, 5})); // true
    }

    /**
     * Solution: Subset sum DP.
     * Find if there's a subset with sum = total/2.
     * Time: O(n * sum), Space: O(sum)
     */
    public static boolean solution(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    /**
     * Alternative Solution: 2D DP table.
     * Time: O(n * sum), Space: O(n * sum)
     */
    public static boolean alternativeSolution(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    /**
     * Alternative Solution: Recursive with memoization.
     * Time: O(n * sum), Space: O(n * sum)
     */
    public static boolean alternativeRecursiveSolution(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        Map<String, Boolean> memo = new HashMap<>();
        return canPartition(nums, 0, target, memo);
    }

    private static boolean canPartition(int[] nums, int index, int target, Map<String, Boolean> memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        String key = index + "," + target;
        if (memo.containsKey(key)) return memo.get(key);

        boolean result = canPartition(nums, index + 1, target, memo)
                || canPartition(nums, index + 1, target - nums[index], memo);
        memo.put(key, result);
        return result;
    }
}
