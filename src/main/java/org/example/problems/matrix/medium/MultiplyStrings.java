package org.example.problems.matrix.medium;

import java.util.stream.IntStream;

/**
 * Problem: Multiply Strings
 * Topic: Math & Geometry
 * Level: Medium
 *
 * Problem Description:
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Video Explanation: https://www.youtube.com/watch?v=1Hftrgb30BQ
 * LeetCode Problem Link: https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String[][] testCases = {
                {"2", "3"},
                {"123", "456"},
                {"0", "123"},
                {"999", "999"},
                {"123456789", "987654321"}
        };

        System.out.println("=== MultiplyStrings ===");
        for (String[] testCase : testCases) {
            String num1 = testCase[0];
            String num2 = testCase[1];
            System.out.println("Input: num1 = \"" + num1 + "\", num2 = \"" + num2 + "\"");
            System.out.println("Output (Standard): " + solution(num1, num2));
            System.out.println("Output (Stream): " + alternativeSolution(num1, num2));
            System.out.println();
        }
    }

    /**
     * Standard solution using manual multiplication
     * Time Complexity: O(m*n) where m and n are lengths of the two strings
     * Space Complexity: O(m+n) for the result array
     */
    public static String solution(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        // Result can have at most m + n digits
        int[] result = new int[m + n];

        // Multiply each digit from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Multiply current digits
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // Add to current position (i + j + 1)
                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                // Update current position
                result[pos2] = sum % 10;

                // Carry over to the next position
                result[pos1] += sum / 10;
            }
        }

        // Convert result array to string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        // Handle case where result is 0
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * Alternative solution using Stream API
     * Time Complexity: O(m*n)
     * Space Complexity: O(m+n)
     */
    public static String alternativeSolution(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        // Result can have at most m + n digits
        int[] result = new int[m + n];

        // Use Stream API to multiply digits
        IntStream.range(0, m).forEach(i -> {
            IntStream.range(0, n).forEach(j -> {
                // Calculate positions from right to left
                int pos1 = (m - 1 - i) + (n - 1 - j);
                int pos2 = pos1 + 1;

                // Multiply digits
                int product = (num1.charAt(m - 1 - i) - '0') * (num2.charAt(n - 1 - j) - '0');

                // Add to result
                int sum = product + result[pos2];
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            });
        });

        // Convert result array to string using Stream API
        String resultStr = IntStream.range(0, result.length)
                .mapToObj(i -> String.valueOf(result[i]))
                .reduce("", (a, b) -> a + b);

        // Remove leading zeros
        resultStr = resultStr.replaceFirst("^0+(?!$)", "");

        return resultStr.isEmpty() ? "0" : resultStr;
    }
}
