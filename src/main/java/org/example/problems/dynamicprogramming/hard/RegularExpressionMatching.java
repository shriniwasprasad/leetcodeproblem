package org.example.problems.dynamicprogramming.hard;

/**
 * Problem: Regular Expression Matching (LeetCode 10)
 * Topic: Dynamic Programming, Recursion
 * Level: Hard
 *
 * Problem Description:
 * Given an input string s and a pattern p, implement regular expression matching with support
 * for '.' and '*' where:
 * - '.' Matches any single character.
 * - '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)", which matches "ab".
 *
 * Video Explanation: https://www.youtube.com/watch?v=VFQddcCP46c
 * LeetCode Problem Link: https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1 (DP): " + solution("aa", "a")); // Expected: false

        // Test case 2
        System.out.println("Test 2 (DP): " + solution("aa", "a*")); // Expected: true

        // Test case 3
        System.out.println("Test 3 (DP): " + solution("ab", ".*")); // Expected: true

        // Test case 4
        System.out.println("Test 4 (DP): " + solution("aab", "c*a*b")); // Expected: true

        // Test case 5
        System.out.println("Test 5 (DP): " + solution("mississippi", "mis*is*p*.")); // Expected: false

        // Alternative solution tests
        System.out.println("\nAlternative Solution (Recursion with Memoization) Tests:");
        System.out.println("Test 1: " + alternativeSolution("aa", "a*")); // Expected: true
        System.out.println("Test 2: " + alternativeSolution("ab", ".*")); // Expected: true
        System.out.println("Test 3: " + alternativeSolution("aab", "c*a*b")); // Expected: true
    }

    /**
     * Dynamic Programming approach - Bottom-up.
     * dp[i][j] = true if s[0..i-1] matches p[0..j-1]
     *
     * Transition:
     * - If p[j-1] is a normal character: dp[i][j] = dp[i-1][j-1] && s[i-1] == p[j-1]
     * - If p[j-1] is '.': dp[i][j] = dp[i-1][j-1] (matches any character)
     * - If p[j-1] is '*':
     *   - Zero occurrence: dp[i][j] = dp[i][j-2]
     *   - One or more: dp[i][j] = dp[i-1][j] && (s[i-1] == p[j-2] || p[j-2] == '.')
     *
     * Time Complexity: O(m * n) where m = s.length(), n = p.length()
     * Space Complexity: O(m * n)
     *
     * @param s the input string
     * @param p the pattern
     * @return true if the string matches the pattern
     */
    public static boolean solution(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        // dp[i][j] represents whether s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // Check the character before '*'
                    char prevChar = p.charAt(j - 2);

                    // Case 1: Zero occurrence of prevChar (ignore prevChar and *)
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: One or more occurrence if prevChar matches current char
                    if (prevChar == '.' || prevChar == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pc == '.' || pc == sc) {
                    // Current characters match (or pattern has '.')
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // else: characters don't match, dp[i][j] remains false
            }
        }

        return dp[m][n];
    }

    /**
     * Recursive approach with memoization - Top-down.
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) for memoization and recursion stack
     *
     * @param s the input string
     * @param p the pattern
     * @return true if the string matches the pattern
     */
    public static boolean alternativeSolution(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(s, p, 0, 0, memo);
    }

    /**
     * Recursive helper with memoization.
     * @param s the input string
     * @param p the pattern
     * @param i current position in string
     * @param j current position in pattern
     * @param memo memoization table
     * @return true if s[i..] matches p[j..]
     */
    private static boolean match(String s, String p, int i, int j, Boolean[][] memo) {
        // Base case: both string and pattern are exhausted
        if (j == p.length()) {
            return i == s.length();
        }

        // Check memoization
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Check if current characters match
        boolean firstMatch = (i < s.length()) &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        boolean result;

        // Check if next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Two options:
            // 1. Skip the current pattern character and '*' (zero occurrences)
            // 2. Use the current pattern character if it matches and move string pointer
            result = match(s, p, i, j + 2, memo) ||
                    (firstMatch && match(s, p, i + 1, j, memo));
        } else {
            // Normal character matching
            result = firstMatch && match(s, p, i + 1, j + 1, memo);
        }

        // Store result in memoization table
        memo[i][j] = result;
        return result;
    }
}
