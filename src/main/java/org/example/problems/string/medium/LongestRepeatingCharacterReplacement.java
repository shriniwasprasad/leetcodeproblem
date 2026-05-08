package org.example.problems.string.medium;

import java.util.*;

/**
 * Problem: Longest Repeating Character Replacement
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 * Hint: Use a sliding window. The window is valid as long as (window_length - max_frequency_of_any_char) <= k.
 *
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Expected Output: 4
 *
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Expected Output: 4
 *
 * Video Explanation: https://www.youtube.com/watch?v=FYyWsqFjkZk
 * LeetCode Problem Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println("=== LongestRepeatingCharacterReplacement ===");

        System.out.println("Test 1: s=\"ABAB\", k=2");
        System.out.println("Result: " + solution("ABAB", 2)); // 4
        System.out.println("Expected: 4\n");

        System.out.println("Test 2: s=\"AABABBA\", k=1");
        System.out.println("Result: " + solution("AABABBA", 1)); // 4
        System.out.println("Expected: 4\n");

        System.out.println("=== Alternative Solution ===");
        System.out.println("Alt Test 1: s=\"ABAB\", k=2");
        System.out.println("Result: " + alternativeSolution("ABAB", 2)); // 4
        System.out.println("Expected: 4\n");
    }

    /**
     * Solution 1: Sliding Window
     *
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) as the character set is fixed (26 uppercase letters)
     *
     * Algorithm:
     * - Use a sliding window defined by left and right pointers.
     * - Maintain a frequency map of characters in the current window.
     * - Track the maximum frequency of any single character in the window.
     * - The window is valid if: (window size - max frequency) <= k.
     * - If the window becomes invalid, shrink it from the left.
     */
    public static int solution(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freq[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);

            // Window is invalid if changes needed > k
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                // Note: we don't strictly need to update maxFreq here because
                // maxFreq only helps us expand the maxLength.
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Solution 2: Slightly different sliding window approach
     *
     * This version doesn't use a while loop but an if, because we only need
     * to find the maximum window size, and the window doesn't need to shrink
     * more than once per step to maintain the maximum possible size.
     */
    public static int alternativeSolution(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left++)]--;
            }
        }

        return s.length() - left; // Total length minus the amount we shifted the left pointer
    }
}
