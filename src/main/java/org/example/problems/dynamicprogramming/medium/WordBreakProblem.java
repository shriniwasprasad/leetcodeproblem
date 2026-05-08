package org.example.problems.dynamicprogramming.medium;

import java.util.*;

/**
 * Problem: Word Break (LeetCode 139)
 * Topic: Dynamic Programming
 * Level: Medium
 *
 * Problem Description:
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Video Explanation: https://www.youtube.com/watch?v=XD9tXO9HW40
 * LeetCode Problem Link: https://leetcode.com/problems/word-break/
 */
public class WordBreakProblem {

    public static void main(String[] args) {
        // Test case 1
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Test 1 (DP): " + solution("leetcode", dict1));  // Expected: true

        // Test case 2
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Test 2 (DP): " + solution("applepenapple", dict2));  // Expected: true

        // Test case 3
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Test 3 (DP): " + solution("catsandog", dict3));  // Expected: false

        // Test case 4
        List<String> dict4 = Arrays.asList("a", "aa", "aaa", "aaaa");
        System.out.println("Test 4 (DP): " + solution("aaaa", dict4));  // Expected: true

        // Alternative solution tests
        System.out.println("\nAlternative Solution (DFS with Memoization) Tests:");
        System.out.println("Test 1: " + alternativeSolution("leetcode", dict1));  // Expected: true
        System.out.println("Test 2: " + alternativeSolution("catsandog", dict3));  // Expected: false
    }

    /**
     * Dynamic Programming approach.
     * dp[i] = true if s[0..i-1] can be segmented into dictionary words
     * Time Complexity: O(n^2 * m) where n = string length, m = average word length
     * Space Complexity: O(n)
     *
     * @param s the input string
     * @param wordDict the dictionary of words
     * @return true if string can be segmented, false otherwise
     */
    public static boolean solution(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // Convert to HashSet for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] = true if s[0..i-1] can be segmented
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If s[0..j-1] is segmentable and s[j..i-1] is in dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * DFS with memoization approach.
     * Time Complexity: O(n^2 * m)
     * Space Complexity: O(n)
     *
     * @param s the input string
     * @param wordDict the dictionary
     * @return true if string can be segmented
     */
    public static boolean alternativeSolution(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return dfs(s, 0, wordSet, memo);
    }

    /**
     * DFS helper with memoization.
     * @param s the string
     * @param start current starting position
     * @param wordSet dictionary as set
     * @param memo memoization array
     * @return true if remaining string can be segmented
     */
    private static boolean dfs(String s, int start, Set<String> wordSet, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) &&
                dfs(s, end, wordSet, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}
