package org.example.problems.dynamicprogramming.medium;

/**
 * Problem: Longest Common Subsequence (LeetCode 1143)
 * Topic: Dynamic Programming
 * Level: Medium
 *
 * Problem Description:
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no common subsequence so return 0.
 *
 * Video Explanation: https://www.youtube.com/watch?v=lPnPdSIliII
 * LeetCode Problem Link: https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1 (DP 2D): " + solution("abcde", "ace"));  // Expected: 3

        // Test case 2
        System.out.println("Test 2 (DP 2D): " + solution("abc", "abc"));    // Expected: 3

        // Test case 3
        System.out.println("Test 3 (DP 2D): " + solution("abc", "def"));    // Expected: 0

        // Test case 4
        System.out.println("Test 4 (DP 2D): " + solution("absdf", "abcdf")); // Expected: 4

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution("abcde", "ace"));  // Expected: 3
        System.out.println("Test 2: " + alternativeSolution("abcf", "acef"));  // Expected: 3
    }

    /**
     * Dynamic Programming approach using 2D array.
     * dp[i][j] = length of LCS of text1[0..i-1] and text2[0..j-1]
     * Transition:
     * - If text1[i-1] == text2[j-1]: dp[i][j] = dp[i-1][j-1] + 1
     * - Otherwise: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * Time Complexity: O(m * n) where m and n are lengths of the strings
     * Space Complexity: O(m * n)
     *
     * @param text1 first string
     * @param text2 second string
     * @return length of longest common subsequence
     */
    public static int solution(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        // dp[i][j] represents LCS length for text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match, extend the LCS
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters don't match, take the maximum of excluding either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Space-optimized approach using two rows instead of full 2D matrix.
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n))
     *
     * @param text1 first string
     * @param text2 second string
     * @return length of LCS
     */
    public static int alternativeSolution(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        // Use shorter string for the column dimension to save space
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Move current row to previous
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
