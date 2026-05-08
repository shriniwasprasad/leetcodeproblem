package org.example.problems.greedy.medium;

import java.util.*;

/**
 * Problem: Merge Triplets to Form Target Triplet (LeetCode 1899)
 * Topic: Greedy, Array
 * Level: Medium
 *
 * Problem Description:
 * A triplet is an array of three integers. You are given a 2D integer array triplets,
 * where triplets[i] = [ai, bi, ci] represents the ith triplet. You are also given an
 * integer array target = [x, y, z] that represents the triplet you want to obtain.
 *
 * To obtain target, we apply the following operation on triplets any number of times:
 * - Choose two indices (0-indexed) i and j (i != j) and update triplets[i] to become
 *   [max(ai, aj), max(bi, bj), max(ci, cj)].
 *
 * Return true if it is possible to obtain the target triplet [x, y, z] as an element of triplets,
 * or false otherwise.
 *
 * Example 1:
 * Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
 * Output: true
 *
 * Example 2:
 * Input: triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
 * Output: false
 *
 * Video Explanation: https://www.youtube.com/watch?v=OVjB6kGr29g
 * LeetCode Problem Link: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 */
public class MergeTripletsToFormTargetTriplet {

    public static void main(String[] args) {
        // Test case 1
        int[][] triplets1 = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target1 = {2, 7, 5};
        System.out.println("Test 1 (Greedy): " + solution(triplets1, target1));  // Expected: true

        // Test case 2
        int[][] triplets2 = {{3, 4, 5}, {4, 5, 6}};
        int[] target2 = {3, 2, 5};
        System.out.println("Test 2 (Greedy): " + solution(triplets2, target2));  // Expected: false

        // Test case 3
        int[][] triplets3 = {{2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}};
        int[] target3 = {2, 5, 5};
        System.out.println("Test 3 (Greedy): " + solution(triplets3, target3));  // Expected: true

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(triplets1, target1));  // Expected: true
        System.out.println("Test 2: " + alternativeSolution(triplets2, target2));  // Expected: false
    }

    /**
     * Greedy approach - track which target values we can achieve.
     * Only consider triplets where all values are <= corresponding target values.
     * Time Complexity: O(n) - single pass through triplets
     * Space Complexity: O(1)
     *
     * @param triplets array of triplets
     * @param target the target triplet to form
     * @return true if target can be formed, false otherwise
     */
    public static boolean solution(int[][] triplets, int[] target) {
        if (triplets == null || triplets.length == 0 || target == null) {
            return false;
        }

        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;
        int x = target[0];
        int y = target[1];
        int z = target[2];

        for (int[] triplet : triplets) {
            // Only consider triplets where all values are <= target values
            // (otherwise merging would exceed target)
            if (triplet[0] <= x && triplet[1] <= y && triplet[2] <= z) {
                // Mark which target values we've found
                if (triplet[0] == x) foundX = true;
                if (triplet[1] == y) foundY = true;
                if (triplet[2] == z) foundZ = true;
            }

            // Early termination if we've found all three
            if (foundX && foundY && foundZ) {
                return true;
            }
        }

        return foundX && foundY && foundZ;
    }

    /**
     * Alternative approach with explicit max tracking.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param triplets array of triplets
     * @param target the target triplet
     * @return true if target can be formed, false otherwise
     */
    public static boolean alternativeSolution(int[][] triplets, int[] target) {
        if (triplets == null || triplets.length == 0 || target == null) {
            return false;
        }

        int max0 = 0, max1 = 0, max2 = 0;
        int x = target[0], y = target[1], z = target[2];

        for (int[] triplet : triplets) {
            // Skip triplets that have any value exceeding target
            if (triplet[0] > x || triplet[1] > y || triplet[2] > z) {
                continue;
            }

            // Update maximums
            max0 = Math.max(max0, triplet[0]);
            max1 = Math.max(max1, triplet[1]);
            max2 = Math.max(max2, triplet[2]);

            // Check if we've achieved target
            if (max0 == x && max1 == y && max2 == z) {
                return true;
            }
        }

        return max0 == x && max1 == y && max2 == z;
    }
}
