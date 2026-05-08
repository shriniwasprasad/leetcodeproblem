package org.example.problems.string.medium;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem: Permutation In String
 * Topic: Sliding Window / Fixed Window
 * Level: Medium
 *
 * Problem Description:
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1.
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true (s2 contains "ba" which is a permutation of "ab")
 *
 * Video Explanation: https://www.youtube.com/watch?v=mIorIJvhl8E
 * LeetCode Problem Link: https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println("=== PermutationInString ===");
        System.out.println(solution("ab", "eidbaooo")); // true
        System.out.println(alternativeSolution("ab", "eidboaoo")); // false
    }

    /**
     * Solution: Sliding window with character frequency comparison.
     * Time: O(n) where n = length of s2, Space: O(26)
     */
    public static boolean solution(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                count2[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (i >= s1.length() - 1 && matches(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    /**
     * Alternative Solution: Using HashMap for clarity.
     * Time: O(n), Space: O(26) or O(n)
     */
    public static boolean alternativeSolution(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, matched = 0;

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.getOrDefault(c, 0).equals(window.get(c))) {
                matched++;
            }

            if (right >= s1.length()) {
                char leftChar = s2.charAt(left);
                if (need.getOrDefault(leftChar, 0).equals(window.get(leftChar))) {
                    matched--;
                }
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }

            if (matched == need.size()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Alternative Solution: Stream API (inefficient).
     * Time: O(n * s1.length()), Space: O(n)
     */
    public static boolean alternativeStreamSolution(String s1, String s2) {
        int len1 = s1.length();
        char[] s2Chars = s2.toCharArray();

        return IntStream.range(0, s2.length() - len1 + 1)
                .anyMatch(i -> {
                    String substring = new String(s2Chars, i, len1);
                    return hasSameChars(s1, substring);
                });
    }

    private static boolean hasSameChars(String a, String b) {
        int[] count = new int[26];
        for (char c : a.toCharArray()) count[c - 'a']++;
        for (char c : b.toCharArray()) count[c - 'a']--;
        for (int i : count) if (i != 0) return false;
        return true;
    }
}
