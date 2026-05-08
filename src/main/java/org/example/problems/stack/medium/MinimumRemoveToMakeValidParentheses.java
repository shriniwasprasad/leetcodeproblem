package org.example.problems.stack.medium;

import java.util.*;

/**
 * Problem: Minimum Remove to Make Valid Parentheses
 * Topic: Stack
 * Level: Medium
 *
 * Problem Description:
 * Given a string s of '(' , ')' and lowercase English characters,
 * remove the minimum number of parentheses to make the string valid.
 * Return the result string in any order.
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de" or "lee(t(co)de)" or "lee(t(c)ode)"
 *
 * Video Explanation: https://www.youtube.com/watch?v=h9skhJ_UZQo
 * LeetCode Problem Link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println("=== MinimumRemoveToMakeValidParentheses ===");
        System.out.println(solution("lee(t(c)o)de)"));
        System.out.println(alternativeSolution("lee(t(c)o)de)"));
    }

    /**
     * Solution: Stack-based with mark-and-remove approach.
     * First pass marks invalid closing parentheses.
     * Second pass (via StringBuilder) removes marked characters and invalid opening parentheses.
     * Time: O(n), Space: O(n)
     */
    public static String solution(String s) {
        Set<Integer> invalidClose = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    invalidClose.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            invalidClose.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidClose.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * Alternative Solution: Two-pass string building.
     * Pass 1: Track balanced parentheses, building result for valid closing.
     * Pass 2: Remove unmatched opening parentheses.
     * Time: O(n), Space: O(n)
     */
    public static String alternativeSolution(String s) {
        StringBuilder intermediate = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                intermediate.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    intermediate.append(c);
                }
            } else {
                intermediate.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        int openingToRemove = balance;

        for (int i = intermediate.length() - 1; i >= 0; i--) {
            char c = intermediate.charAt(i);
            if (c == '(' && openingToRemove > 0) {
                openingToRemove--;
                continue;
            }
            result.append(c);
        }

        return result.reverse().toString();
    }

    /**
     * Alternative Solution: Stream API approach.
     * Note: Stream API is not ideal for this problem due to needing backward pass.
     * Time: O(n), Space: O(n)
     */
    public static String alternativeStreamSolution(String s) {
        int[] balance = {0};

        String forward = s.chars()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, (sb, c) -> {
                    if (c == '(') {
                        balance[0]++;
                        sb.append(c);
                    } else if (c == ')') {
                        if (balance[0] > 0) {
                            balance[0]--;
                            sb.append(c);
                        }
                    } else {
                        sb.append(c);
                    }
                }, StringBuilder::append)
                .toString();

        final int toRemove = balance[0];
        if (toRemove == 0) {
            return forward;
        }

        StringBuilder result = new StringBuilder();
        int removeCount = 0;

        for (int i = forward.length() - 1; i >= 0; i--) {
            char c = forward.charAt(i);
            if (c == '(' && removeCount < toRemove) {
                removeCount++;
            } else {
                result.append(c);
            }
        }

        return result.reverse().toString();
    }
}
