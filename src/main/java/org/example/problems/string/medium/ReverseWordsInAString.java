package org.example.problems.string.medium;

import java.util.Arrays;

/**
 * Problem: Reverse Words in a String
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Hint: You can split the string by whitespace, reverse the resulting array/list, and join them back with a single space.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Expected Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Expected Output: "world hello"
 *
 * Video Explanation: https://www.youtube.com/watch?v=WfkVe8egZbU
 * LeetCode Problem Link: https://leetcode.com/problems/reverse-words-in-a-string/description/
 */
public class ReverseWordsInAString {


    public static void main(String[] args) {
        System.out.println("=== ReverseWordsInAString ===");

        // Test cases
        System.out.println("Test 1: " + solution("the sky is blue")); // "blue is sky the"
        System.out.println("Test 2: " + solution("  hello world  ")); // "world hello"
        System.out.println("Test 3: " + solution1("a good   example")); // "example good a"
    }

    private static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;
        int left = right;
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s, left + 1, right + 1).append(' ');
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }

    //Using Stream API
    private static String solution1(String s) {
        return Arrays.stream(s.trim().split("\\s+"))
                .reduce((a,b)->b+" "+a)
                .orElse("");
    }
}
