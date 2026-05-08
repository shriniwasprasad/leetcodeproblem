package org.example.problems.stack.hard;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem: Longest Valid Parentheses
 * Topic: Stack / Dynamic Programming
 * Level: Hard
 *
 * Problem Description:
 * Given a string containing just '(' and ')', find the length of the longest
 * valid (well-formed) parentheses substring.
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid substring is "()()"
 *
 * Video Explanation: https://www.youtube.com/watch?v=GrSL3c8G6k8
 * LeetCode Problem Link: https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println("=== LongestValidParentheses ===");
        System.out.println(solution(")()())")); // 4
        System.out.println(alternativeSolution(")()())")); // 4
    }

    /**
     * Solution: Stack-based approach.
     * Push indices, when valid pair found, calculate length.
     * Time: O(n), Space: O(n)
     */
    public static int solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    /**
     * Alternative Solution: Two-pass scanning.
     * Left-to-right pass handles cases where ')' is more than '('.
     * Right-to-left pass handles cases where '(' is more than ')'.
     * Time: O(n), Space: O(1)
     */
    public static int alternativeSolution(String s) {
        int left = 0, right = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLength;
    }

    /**
     * Alternative Solution: Stream API (limited applicability).
     * Stream API is not well-suited for this problem due to O(n^2) nature.
     * Time: O(n^2), Space: O(n)
     */
    public static int alternativeStreamSolution(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(i -> s.substring(i))
                .mapToInt(sub -> longestValid(sub))
                .max()
                .orElse(0);
    }

    private static int longestValid(String s) {
        int max = 0, depth = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                if (depth > 0) {
                    depth--;
                    count += 2;
                    if (depth == 0) {
                        max = Math.max(max, count);
                        count = 0;
                    }
                } else {
                    max = Math.max(max, count);
                    count = 0;
                    depth = 0;
                }
            }
        }
        return Math.max(max, count);
    }
}
