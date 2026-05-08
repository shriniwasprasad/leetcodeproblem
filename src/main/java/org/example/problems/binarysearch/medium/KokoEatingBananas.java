package org.example.problems.binarysearch.medium;

import java.util.*;

/**
 * Problem: Koko Eating Bananas
 * Topic: Binary Search
 * Level: Medium
 *
 * Problem Description:
 * Koko Eating Bananas - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=3m3QZeiH3KI
 * LeetCode Problem Link: https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println("=== KokoEatingBananas ===");
    }

    public static int solution(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) right = Math.max(right, pile);

        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean canEatAll(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }

    public static int alternativeSolution(int[] piles, int h) {
        // Using Stream API to check canEatAll’s total hours
        int left = 1, right = java.util.Arrays.stream(piles).max().orElse(0);
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalHours = java.util.Arrays.stream(piles)
                    .mapToLong(p -> (p + mid - 1) / mid)
                    .sum();
            if (totalHours <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
