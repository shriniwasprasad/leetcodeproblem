package org.example.problems.stack.medium;

import java.util.*;

/**
 * Problem: Evaluate Reverse Polish Notation
 * Topic: Stack
 * Level: Medium
 *
 * Problem Description:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators: +, -, *, /
 * Each operand may be an integer or another expression.
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Video Explanation: https://www.youtube.com/watch?v=vDRZN5i4b8U
 * LeetCode Problem Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println("=== EvaluateReversePolishNotation ===");
        System.out.println(solution(new String[]{"2","1","+","3","*"})); // 9
        System.out.println(alternativeSolution(new String[]{"2","1","+","3","*"})); // 9
    }

    /**
     * Solution: Stack-based evaluation.
     * Push operands, pop two operands when operator encountered, compute and push result.
     * Time: O(n), Space: O(n)
     */
    public static int solution(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int result;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        result = 0;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /**
     * Alternative Solution: Using ArrayList as stack.
     * Time: O(n), Space: O(n)
     */
    public static int alternativeSolution(String[] tokens) {
        List<Integer> stack = new ArrayList<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                int result;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        result = 0;
                }
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.get(0);
    }

    /**
     * Alternative Solution: Using Stream with reduce.
     * Note: Stream API is not well-suited for this problem due to mutable state.
     * This is a pedagogical example showing stream limitations for stateful operations.
     * Time: O(n), Space: O(n)
     */
    public static int alternativeStreamSolution(String[] tokens) {
        return Arrays.stream(tokens)
                .reduce(new ArrayDeque<String>(), (stack, token) -> {
                    if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                        String b = stack.pop();
                        String a = stack.pop();
                        int result;
                        switch (token) {
                            case "+":
                                result = Integer.parseInt(a) + Integer.parseInt(b);
                                break;
                            case "-":
                                result = Integer.parseInt(a) - Integer.parseInt(b);
                                break;
                            case "*":
                                result = Integer.parseInt(a) * Integer.parseInt(b);
                                break;
                            case "/":
                                result = Integer.parseInt(a) / Integer.parseInt(b);
                                break;
                            default:
                                result = 0;
                        }
                        stack.push(String.valueOf(result));
                    } else {
                        stack.push(token);
                    }
                    return stack;
                }, (a, b) -> b)
                .stream()
                .mapToInt(Integer::parseInt)
                .findFirst()
                .orElse(0);
    }
}
