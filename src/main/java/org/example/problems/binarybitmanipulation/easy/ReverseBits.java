package org.example.problems.binarybitmanipulation.easy;

import java.util.*;

/**
 * Problem: Reverse Bits
 * Topic: Binary-Bit Manipulation
 * Level: Easy
 *
 * Problem Description:
 * Reverse Bits - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=-7bpRBMPXh8
 * LeetCode Problem Link: https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println("=== ReverseBits ===");
    }

    public static int solution(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static int alternativeSolution(int n) {
        // Using built-in Java method for reversing bits
        return Integer.reverse(n);
    }
}
