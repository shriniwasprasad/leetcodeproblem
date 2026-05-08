package org.example.problems.stack.medium;

import java.util.*;

/**
 * Problem: Min Stack
 * Topic: Stack
 * Level: Medium
 *
 * Problem Description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * - push(x) -- Push element x onto stack.
 * - pop() -- Removes the element on top of the stack.
 * - top() -- Get the top element.
 * - getMin() -- Retrieve the minimum element in the stack.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=To2iap-ac3g
 * LeetCode Problem Link: https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        System.out.println("=== MinStack ===");
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin: " + minStack.getMin()); // returns -3
        minStack.pop();
        System.out.println("top: " + minStack.top());        // returns 0
        System.out.println("getMin: " + minStack.getMin()); // returns -2
    }

    /**
     * Solution: Use two stacks - one for elements and one for tracking minimums.
     * Each time we push, we also push the current minimum to minStack.
     * Time: O(1) for all operations, Space: O(n)
     */
    public void push(int val) {
        stack.push(val);
        int currentMin = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
        minStack.push(currentMin);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /**
     * Alternative Solution: Stream-based approach for getMin operation
     * Note: This defeats the O(1) purpose but shows stream API usage
     * Time: O(n) for getMin, Space: O(1)
     */
    public int getMinStream() {
        return stack.stream().min(Integer::compare).orElseThrow(NoSuchElementException::new);
    }
}
