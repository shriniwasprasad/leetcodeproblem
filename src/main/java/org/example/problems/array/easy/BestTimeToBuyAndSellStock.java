package org.example.problems.array.easy;


/**
 * Problem: Best Time to Buy and Sell Stock
 * Topic: Array
 * Level: Easy
 * <p>
 * Problem Description:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize profit by choosing a single day to buy and a different day in the future to sell.
 * <p>
 * Input: int[] prices = {7, 1, 5, 3, 6, 4}
 * Output: int = 5 (buy at 1, sell at 6)
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=CCQBvgPages">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">...</a>
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + solution(prices));
    }

    // Single pass tracking: O(n) time, O(1) space
    // Key insight: Track minimum price seen so far, calculate profit at each day
    public static int solution(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Lowest price seen so far
        int maxProfit = 0;                 // Maximum profit achievable

        for (int price : prices) {
            // Update minimum price if current is lower
            minPrice = Math.min(minPrice, price);

            // Calculate profit if we sell at current price (buy at minPrice)
            // Update max profit if this profit is higher
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // Alternative: Same tracking approach with slightly different variable names
    public static int alternativeSolution(int[] prices) {
        int minSoFar = prices[0];  // Minimum price from day 0 to current-1
        int maxProfit = 0;         // Best profit seen so far

        for (int i = 1; i < prices.length; i++) {
            // Calculate profit if we sell today
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);

            // Update minimum price for future calculations
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }
}