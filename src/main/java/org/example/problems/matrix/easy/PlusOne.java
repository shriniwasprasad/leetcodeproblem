package org.example.problems.matrix.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Problem: Plus One
 * Topic: Math & Geometry
 * Level: Easy
 *
 * Problem Description:
 * Given a non-empty array of decimal digits representing a non-negative integer,
 * increment the integer by one. The digits are stored such that the most significant
 * digit is at the head of the list, and each element contains a single digit.
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 *
 * Video Explanation: https://www.youtube.com/watch?v=1KIcZqCXNHU
 * LeetCode Problem Link: https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        int[] digits2 = {4, 3, 2, 1};
        int[] digits3 = {9};
        int[] digits4 = {9, 9, 9};

        System.out.println("=== PlusOne ===");
        System.out.println("Input: " + Arrays.toString(digits1));
        System.out.println("Output: " + Arrays.toString(solution(digits1.clone())));
        System.out.println();

        System.out.println("Input: " + Arrays.toString(digits2));
        System.out.println("Output: " + Arrays.toString(solution(digits2.clone())));
        System.out.println();

        System.out.println("Input: " + Arrays.toString(digits3));
        System.out.println("Output: " + Arrays.toString(solution(digits3.clone())));
        System.out.println();

        System.out.println("Input: " + Arrays.toString(digits4));
        System.out.println("Output: " + Arrays.toString(solution(digits4.clone())));
        System.out.println();

        System.out.println("=== Stream API Solution ===");
        System.out.println("Input: " + Arrays.toString(digits1));
        System.out.println("Output: " + Arrays.toString(alternativeSolution(digits1.clone())));
    }

    /**
     * Standard solution - iterate from right to left and handle carry
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1) extra space (modifies input array)
     */
    public static int[] solution(int[] digits) {
        // Start from the least significant digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // If current digit is less than 9, just increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If current digit is 9, set it to 0 and continue with carry
            digits[i] = 0;
        }

        // If we reach here, all digits were 9, so we need to add a new digit
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Most significant digit is 1, rest are 0
        return result;
    }

    /**
     * Alternative solution using Stream API
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the new array
     */
    public static int[] alternativeSolution(int[] digits) {
        // Convert array to stream, process from right to left
        // This is less efficient but demonstrates Stream API usage
        int[] carry = {1}; // Use array to allow modification inside lambda

        // Process digits from right to left using IntStream
        int[] result = IntStream.range(0, digits.length)
                .map(i -> digits[digits.length - 1 - i]) // Reverse the array
                .map(digit -> {
                    int sum = digit + carry[0];
                    carry[0] = sum / 10; // Update carry
                    return sum % 10; // Get current digit
                })
                .toArray();

        // If there's still a carry, prepend it
        if (carry[0] > 0) {
            int[] finalResult = new int[result.length + 1];
            finalResult[0] = carry[0];
            // Copy result in reverse order
            for (int i = 0; i < result.length; i++) {
                finalResult[result.length - i] = result[i];
            }
            return finalResult;
        }

        // Reverse the result back to original order
        return IntStream.range(0, result.length)
                .map(i -> result[result.length - 1 - i])
                .toArray();
    }
}
