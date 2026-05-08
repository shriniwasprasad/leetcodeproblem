package org.example.problems.dynamicprogramming.medium;

import java.util.*;

/**
 * Problem: Target Sum
 * Topic: 2-D Dynamic Programming / Subset Sum
 * Level: Medium
 *
 * Problem Description:
 * Assign + or - signs to each element to make the sum equal to target.
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5 (ways to assign signs)
 *
 * Video Explanation: https://www.youtube.com/watch?v=9QqOX57nMAY
 * LeetCode Problem Link: https://leetcode.com/problems/target-sum/
 */
public class TargetSum {

    public static void main(String[] args) {
        System.out.println("=== TargetSum ===");
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
    }

    /**
     * Solution: Transform to subset sum problem.
     * Let P = sum of elements with +, N = sum of elements with -
     * P - N = target, P + N = total sum
     * So P = (target + total) / 2
     * Time: O(n * sum), Space: O(sum)
     */
    public static int solution(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (Math.abs(target) > total) return 0;
        if ((total + target) % 2 != 0) return 0;

        int sum = (total + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[sum];
    }

    /**
     * Alternative Solution: 2D DP table.
     * dp[i][j] = number of ways to get sum j using first i elements.
     * Time: O(n * sum), Space: O(n * sum)
     */
    public static int alternativeSolution(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (Math.abs(target) > total) return 0;
        if ((total + target) % 2 != 0) return 0;

        int sum = (total + target) / 2;
        int[][] dp = new int[nums.length + 1][sum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * Alternative Solution: Recursive with memoization.
     * Time: O(n * sum), Space: O(n * sum)
     */
    public static int alternativeRecursiveSolution(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (Math.abs(target) > total) return 0;
        if ((total + target) % 2 != 0) return 0;

        int sum = (total + target) / 2;
        Map<String, Integer> memo = new HashMap<>();
        return findWays(nums, nums.length - 1, sum, memo);
    }

    private static int findWays(int[] nums, int i, int sum, Map<String, Integer> memo) {
        if (i < 0) return sum == 0 ? 1 : 0;
        String key = i + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        int result = 0;
        result += findWays(nums, i - 1, sum, memo);
        if (sum >= nums[i]) {
            result += findWays(nums, i - 1, sum - nums[i], memo);
        }
        memo.put(key, result);
        return result;
    }
}
