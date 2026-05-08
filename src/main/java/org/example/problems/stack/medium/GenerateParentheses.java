package org.example.problems.stack.medium;

import java.util.*;

/**
 * Problem: Generate Parentheses
 * Topic: Stack / Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Video Explanation: https://www.youtube.com/watch?v=VzMyeCMLdPI
 * LeetCode Problem Link: https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println("=== GenerateParentheses ===");
        System.out.println(solution(3));
        System.out.println(alternativeSolution(3));
    }

    /**
     * Solution: Backtracking with stack-like behavior.
     * At each step, we can add '(' if open count < n, and ')' if close count < open count.
     * Time: O(2^n), Space: O(n) for recursion stack
     */
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, StringBuilder current, int open, int close, int n) {
        if (current.length() == n * 2) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            generate(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            generate(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * Alternative Solution: Using explicit stack (iterative).
     * Time: O(2^n), Space: O(n) for stack
     */
    public static List<String> alternativeSolution(int n) {
        List<String> result = new ArrayList<>();
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State("", 0, 0));

        while (!stack.isEmpty()) {
            State state = stack.pop();
            if (state.str.length() == n * 2) {
                result.add(state.str);
            } else {
                if (state.open < n) {
                    stack.push(new State(state.str + "(", state.open + 1, state.close));
                }
                if (state.close < state.open) {
                    stack.push(new State(state.str + ")", state.open, state.close + 1));
                }
            }
        }
        return result;
    }

    /**
     * Alternative Solution: Stream API approach.
     * Using Stream.generate with a stateful generator (not truly functional).
     * Time: O(2^n), Space: O(n)
     */
    public static List<String> alternativeStreamSolution(int n) {
        List<String> result = new ArrayList<>();
        generateWithStream(result, new ArrayDeque<>(List.of(new State("", 0, 0))), n);
        return result;
    }

    private static void generateWithStream(List<String> result, Deque<State> stack, int n) {
        while (!stack.isEmpty()) {
            State state = stack.pop();
            if (state.str.length() == n * 2) {
                result.add(state.str);
            } else {
                if (state.open < n) {
                    stack.push(new State(state.str + "(", state.open + 1, state.close));
                }
                if (state.close < state.open) {
                    stack.push(new State(state.str + ")", state.open, state.close + 1));
                }
            }
        }
    }

    private static class State {
        String str;
        int open;
        int close;
        State(String str, int open, int close) {
            this.str = str;
            this.open = open;
            this.close = close;
        }
    }
}
