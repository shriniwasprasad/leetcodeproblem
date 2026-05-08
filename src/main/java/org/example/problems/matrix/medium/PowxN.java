package org.example.problems.matrix.medium;

import java.util.stream.IntStream;

/**
 * Problem: Pow(x, n)
 * Topic: Math & Geometry
 * Level: Medium
 *
 * Problem Description:
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Video Explanation: https://www.youtube.com/watch?v=OUKFuUkb4p0
 * LeetCode Problem Link: https://leetcode.com/problems/powx-n/
 */
public class PowxN {

    public static void main(String[] args) {
        double[] xValues = {2.0, 2.1, 2.0, 1.0, -2.0};
        int[] nValues = {10, 3, -2, 0, 3};

        System.out.println("=== PowxN ===");
        for (int i = 0; i < xValues.length; i++) {
            System.out.println("Input: x = " + xValues[i] + ", n = " + nValues[i]);
            System.out.println("Output (Standard): " + solution(xValues[i], nValues[i]));
            System.out.println("Output (Stream): " + alternativeSolution(xValues[i], nValues[i]));
            System.out.println();
        }
    }

    /**
     * Standard solution using binary exponentiation
     * Time Complexity: O(log n) - we divide the problem in half each time
     * Space Complexity: O(log n) - for the recursion stack
     */
    public static double solution(double x, int n) {
        // Handle negative exponent
        long longN = n; // Use long to handle Integer.MIN_VALUE
        if (longN < 0) {
            x = 1 / x;
            longN = -longN;
        }

        return fastPow(x, longN);
    }

    /**
     * Helper method for fast power calculation using binary exponentiation
     */
    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        // Calculate x^(n/2)
        double half = fastPow(x, n / 2);

        // If n is even, result is half * half
        // If n is odd, result is half * half * x
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * Alternative solution using Stream API
     * Time Complexity: O(n) - less efficient than binary exponentiation
     * Space Complexity: O(1)
     */
    public static double alternativeSolution(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        // Handle negative exponent
        final double base = (n < 0) ? 1 / x : x;
        final int exp = (n < 0) ? -n : n;

        // Use Stream API to multiply base by itself exp times
        // This is less efficient but demonstrates Stream API usage
        return IntStream.range(0, exp)
                .mapToDouble(i -> base)
                .reduce(1.0, (a, b) -> a * b);
    }
}
