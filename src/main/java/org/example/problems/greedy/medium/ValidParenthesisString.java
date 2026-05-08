package org.example.problems.greedy.medium;

import java.util.*;

/**
 * Problem: Valid Parenthesis String (LeetCode 678)
 * Topic: Greedy, Stack, String
 * Level: Medium
 *
 * Problem Description:
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 * - Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * - Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * - Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * - '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 *
 * Example 3:
 * Input: s = "(*))"
 * Output: true
 *
 * Video Explanation: https://www.youtube.com/watch?v=h5YxPLC4lWs
 * LeetCode Problem Link: https://leetcode.com/problems/valid-parenthesis-string/
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        // Test case 1
        String s1 = "()";
        System.out.println("Test 1 (Greedy): " + solution(s1));  // Expected: true

        // Test case 2
        String s2 = "(*)";
        System.out.println("Test 2 (Greedy): " + solution(s2));  // Expected: true

        // Test case 3
        String s3 = "(*))";
        System.out.println("Test 3 (Greedy): " + solution(s3));  // Expected: true

        // Test case 4
        String s4 = "(";
        System.out.println("Test 4 (Greedy): " + solution(s4));  // Expected: false

        // Test case 5
        String s5 = "*";
        System.out.println("Test 5 (Greedy): " + solution(s5));  // Expected: true

        // Alternative solution (Stack) tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(s1));  // Expected: true
        System.out.println("Test 2: " + alternativeSolution(s2));  // Expected: true
        System.out.println("Test 3: " + alternativeSolution(s3));  // Expected: true
    }

    /**
     * Greedy approach - track the range of possible open parentheses.
     * Use min and max to track the possible range of open parenthesis counts.
     * Time Complexity: O(n) - single pass through the string
     * Space Complexity: O(1)
     *
     * @param s input string containing '(', ')', and '*'
     * @return true if the string is valid, false otherwise
     */
    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // minOpen: minimum possible open parentheses (treat * as ')' when beneficial)
        // maxOpen: maximum possible open parentheses (treat * as '(' when beneficial)
        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {  // c == '*'
                minOpen--;  // Treat '*' as ')'
                maxOpen++;  // Treat '*' as '('
            }

            // If maxOpen is negative, we have too many ')' to match
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative (we can't have negative open parentheses)
            minOpen = Math.max(minOpen, 0);
        }

        // Valid if we can have exactly 0 open parentheses
        return minOpen == 0;
    }

    /**
     * Two-stack approach - track positions of '(' and '*'.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param s input string
     * @return true if the string is valid, false otherwise
     */
    public static boolean alternativeSolution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {  // c == ')'
                // Try to match with '(' first
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    // Use '*' as '('
                    starStack.pop();
                } else {
                    // No matching '(' or '*'
                    return false;
                }
            }
        }

        // Match remaining '(' with '*' (ensuring '*' comes after '(')
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() > starStack.peek()) {
                // '(' appears after '*' - cannot match
                return false;
            }
            openStack.pop();
            starStack.pop();
        }

        // Valid if all '(' are matched
        return openStack.isEmpty();
    }
}
