package org.example.problems.binarybitmanipulation.easy;

import java.util.*;

/**
 * Problem: Missing Number
 * Topic: Binary-Bit Manipulation
 * Level: Easy
 *
 * Problem Description:
 * Missing Number - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=-pLW7935dlc
 * LeetCode Problem Link: https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {


    public static void main(String[] args) {
        System.out.println("=== MissingNumber ===");

    }

    public static int solution(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static int alternativeSolution(int[] nums) {
        // Using Stream API to calculate the expected sum and subtracting actual sum
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum;
    }
}
