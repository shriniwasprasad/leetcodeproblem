package org.example.problems.greedy.medium;

/**
 * Problem: Gas Station (LeetCode 134)
 * Topic: Greedy, Array
 * Level: Medium
 *
 * Problem Description:
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
 * to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel
 * around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique.
 *
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation: Start at station 3 (index 3) and fill up with 4 unit of gas.
 *
 * Example 2:
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 *
 * Video Explanation: https://www.youtube.com/watch?v=ENDr9IfRMMw
 * LeetCode Problem Link: https://leetcode.com/problems/gas-station/
 */
public class GasStation {

    public static void main(String[] args) {
        // Test case 1
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Test 1 (Greedy): " + solution(gas1, cost1));  // Expected: 3

        // Test case 2
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Test 2 (Greedy): " + solution(gas2, cost2));  // Expected: -1

        // Test case 3
        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        System.out.println("Test 3 (Greedy): " + solution(gas3, cost3));  // Expected: 4

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(gas1, cost1));  // Expected: 3
        System.out.println("Test 2: " + alternativeSolution(gas2, cost2));  // Expected: -1
    }

    /**
     * Greedy approach - single pass with early termination.
     * Key insight: If total gas >= total cost, a solution exists.
     * Start from station 0, if we run out of gas, restart from next station.
     * Time Complexity: O(n) - single pass through the arrays
     * Space Complexity: O(1)
     *
     * @param gas array of gas available at each station
     * @param cost array of cost to travel to next station
     * @return starting station index, or -1 if impossible
     */
    public static int solution(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0) {
            return -1;
        }

        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];

            // If we run out of gas, we can't reach station i+1 from current start
            // So try starting from station i+1
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        // If total gas is less than total cost, impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        return startStation;
    }

    /**
     * Alternative greedy approach - verify total first then find starting point.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param gas array of gas at each station
     * @param cost array of travel costs
     * @return starting station index, or -1 if impossible
     */
    public static int alternativeSolution(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0) {
            return -1;
        }

        int totalSurplus = 0;
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];

            // If surplus becomes negative, can't reach station i+1
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        // Check if it's possible to complete the circuit
        return totalSurplus < 0 ? -1 : start;
    }
}
