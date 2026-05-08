package binarybitmanipulation.easy;

import java.util.*;

/**
 * Problem: Counting Bits
 * Topic: Binary-Bit Manipulation
 * Level: Easy
 *
 * Problem Description:
 * Counting Bits - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=f9vCuICgRpU
 * LeetCode Problem Link: https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    public static void main(String[] args) {
        System.out.println("=== CountingBits ===");
    }

    public static int[] solution(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static int[] alternativeSolution(int n) {
        // Using Stream API to generate the array, though less efficient for this specific DP problem
        return java.util.stream.IntStream.rangeClosed(0, n)
                .map(i -> Integer.bitCount(i))
                .toArray();
    }
}
