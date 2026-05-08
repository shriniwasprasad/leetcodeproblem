package org.example.problems.binarybitmanipulation.medium;

import java.util.*;

/**
 * Problem: Sum of Two Integers
 * Topic: Binary-Bit Manipulation
 * Level: Medium
 *
 * Problem Description:
 * Sum of Two Integers - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=oQqe3N2aSd4
 * LeetCode Problem Link: https://leetcode.com/problems/sum-of-two-integers/
 */
public class SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println("=== SumOfTwoIntegers ===");
    }

    public static int solution(int a, int b) {
        while (b != 0) {
            int carry = (a & b) <<  1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static int alternativeSolution(int a, int b) {
        // Recursive implementation of the same bitwise sum logic
        if (b == 0) return a;
        return alternativeSolution(a ^ b, (a & b) <<  1);
    }
}
