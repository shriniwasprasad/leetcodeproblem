package org.example.problems.string.medium;

import java.util.*;

/**
 * Problem: Palindromic Substrings
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * Given a string s, return the number of palindromic substrings in it.
 *
 * Hint: Expand around each character (odd length) and each pair of adjacent characters (even length) to count all palindromes.
 *
 * Example 1:
 * Input: s = "abcb"
 * Expected Output: 4 ("a", "b", "c", "bcb")
 *
 * Example 2:
 * Input: s = "aaa"
 * Expected Output: 6 ("a", "a", "a", "aa", "aa", "aaa")
 *
 * Video Explanation: https://www.youtube.com/watch?v=WfkVe8egZbU
 * LeetCode Problem Link: https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println("=== PalindromicSubstrings ===");

        System.out.println("Test 1: s=\"abcb\"");
        System.out.println("Result: " + solution("abcb")); // 4
        System.out.println("Expected: 4\n");

        System.out.println("Test 2: s=\"aaa\"");
        System.out.println("Result: " + solution("aaa")); // 6
        System.out.println("Expected: 6\n");

        System.out.println("=== Alternative Solution ===");
        System.out.println("Alt Test 1: s=\"abcb\"");
        System.out.println("Result: " + alternativeSolution("abcb")); // 4
        System.out.println("Expected: 4\n");
    }

    /**
     * Solution 1: Expand Around Center
     *
     * Time Complexity: O(n^2) where n is the length of the string
     * Space Complexity: O(1)
     *
     * Algorithm:
     * - Each character can be the center of an odd-length palindrome.
     * - Each pair of characters can be the center of an even-length palindrome.
     * - For each center, expand outward as long as the characters match.
     */
    public static int solution(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (center is i)
            count += countPalindromes(s, i, i);
            // Even length palindromes (center is between i and i+1)
            count += countPalindromes(s, i, i + 1);
        }

        return count;
    }

    private static int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    /**
     * Solution 2: Dynamic Programming
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2) for the DP table
     *
     * Algorithm:
     * - Create a boolean table dp[i][j] where dp[i][j] is true if s[i...j] is a palindrome.
     * - Base cases: single characters are palindromes, two identical characters are palindromes.
     * - Recurrence: dp[i][j] is true if s[i] == s[j] and dp[i+1][j-1] is true.
     */
    public static int alternativeSolution(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
