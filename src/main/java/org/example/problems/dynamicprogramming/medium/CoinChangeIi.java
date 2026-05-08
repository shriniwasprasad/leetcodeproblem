package org.example.problems.dynamicprogramming.medium;

/**
 * Problem: Coin Change II
 * Topic: 2-D Dynamic Programming / Unbounded Knapsack
 * Level: Medium
 *
 * Problem Description:
 * Find the number of combinations that make up a given amount.
 * Each coin type can be used unlimited times.
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4 (combinations: 1+1+1+1+1, 1+1+1+2, 1+2+2, 5)
 *
 * Video Explanation: https://www.youtube.com/watch?v=khIBdTrRggk
 * LeetCode Problem Link: https://leetcode.com/problems/coin-change-ii/
 */
public class CoinChangeIi {

    public static void main(String[] args) {
        System.out.println("=== CoinChangeIi ===");
        System.out.println(solution(5, new int[]{1, 2, 5})); // 4
    }

    /**
     * Solution: DP where dp[i] = number of ways to make amount i.
     * Outer loop: coins, Inner loop: amounts (order matters, not combinations).
     * Time: O(amount * len(coins)), Space: O(amount)
     */
    public static int solution(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /**
     * Alternative Solution: 2D DP table.
     * dp[i][j] = ways to make j using first i coins.
     * Time: O(len(coins) * amount), Space: O(len(coins) * amount)
     */
    public static int alternativeSolution(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * Alternative Solution: Recursive with memoization.
     * Time: O(amount * len(coins)), Space: O(amount * len(coins))
     */
    public static int alternativeRecursiveSolution(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length + 1][amount + 1];
        return dp(coins.length, amount, coins, memo);
    }

    private static int dp(int i, int amount, int[] coins, Integer[][] memo) {
        if (i == 0) return amount == 0 ? 1 : 0;
        if (memo[i][amount] != null) return memo[i][amount];

        if (amount < coins[i - 1]) {
            memo[i][amount] = dp(i - 1, amount, coins, memo);
        } else {
            memo[i][amount] = dp(i - 1, amount, coins, memo)
                    + dp(i, amount - coins[i - 1], coins, memo);
        }
        return memo[i][amount];
    }
}
