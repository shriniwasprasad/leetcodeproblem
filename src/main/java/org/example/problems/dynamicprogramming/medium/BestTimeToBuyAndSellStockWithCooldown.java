package org.example.problems.dynamicprogramming.medium;

/**
 * Problem: Best Time to Buy And Sell Stock With Cooldown
 * Topic: 2-D Dynamic Programming / State Machine
 * Level: Medium
 *
 * Problem Description:
 * Best Time to Buy And Sell Stock With Cooldown - See LeetCode.
 * You cannot buy on day i if you sold on day i-1.
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3 (transactions: buy on day 0, sell on day 1, buy on day 3, sell on day 4)
 *
 * Video Explanation: https://www.youtube.com/watch?v=PH5jUN1cNHo
 * LeetCode Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        System.out.println("=== BestTimeToBuyAndSellStockWithCooldown ===");
        System.out.println(solution(new int[]{1, 2, 3, 0, 2})); // 3
    }

    /**
     * Solution: State machine with three states.
     * hold[i] = max profit on day i while holding stock
     * sold[i] = max profit on day i after selling (cooldown)
     * rest[i] = max profit on day i in rest state (not holding)
     * Time: O(n), Space: O(1)
     */
    public static int solution(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }

    /**
     * Alternative Solution: DP with arrays.
     * Time: O(n), Space: O(n)
     */
    public static int alternativeSolution(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }

    /**
     * Alternative Solution: Stream API (inefficient, not truly streaming).
     * Time: O(n^2), Space: O(1)
     */
    public static int alternativeStreamSolution(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (j + 2 < prices.length) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]
                            + maxProfit(prices, j + 2, prices.length - 1));
                } else {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    private static int maxProfit(int[] prices, int start, int end) {
        if (start > end) return 0;
        int max = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
