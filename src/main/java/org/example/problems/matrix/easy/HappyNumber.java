package org.example.problems.matrix.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem: Happy Number
 * Topic: Math & Geometry
 * Level: Easy
 *
 * Problem Description:
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy numbers.
 *
 * Input: 19
 * Output: true
 * Explanation: 1² + 9² = 82, 8² + 2² = 68, 6² + 8² = 100, 1² + 0² + 0² = 1
 *
 * Video Explanation: https://www.youtube.com/watch?v=d5SvCvRmmww
 * LeetCode Problem Link: https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public static void main(String[] args) {
        int[] testCases = {19, 2, 7, 1, 20};

        System.out.println("=== HappyNumber ===");
        for (int n : testCases) {
            System.out.println("Input: " + n);
            System.out.println("Output (Standard): " + solution(n));
            System.out.println("Output (Stream): " + alternativeSolution(n));
            System.out.println();
        }
    }

    /**
     * Standard solution using HashSet to detect cycles
     * Time Complexity: O(log n) - number of digits decreases as we process
     * Space Complexity: O(log n) - for storing seen numbers
     */
    public static boolean solution(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    /**
     * Alternative solution using Stream API
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public static boolean alternativeSolution(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            // Use Stream API to calculate sum of squares of digits
            n = Integer.toString(n)
                    .chars()
                    .map(Character::getNumericValue)
                    .map(digit -> digit * digit)
                    .sum();
        }

        return n == 1;
    }

    /**
     * Helper method to calculate sum of squares of digits
     */
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
