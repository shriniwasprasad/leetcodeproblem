package org.example.problems.stack.hard;

import java.util.*;

/**
 * Problem: Max Stack
 * Topic: Stack / Design
 * Level: Hard
 *
 * Problem Description:
 * Design a stack that supports push, pop, top, and retrieving the maximum element.
 * All operations must run in O(1) time.
 *
 * Operations:
 * - MaxStack() Initializes the stack.
 * - void push(int x) Pushes element x onto the stack.
 * - int pop() Removes and returns the top of the stack.
 * - int top() Returns the top element.
 * - int peekMax() Retrieves the maximum element in the stack.
 * - int popMax() Retrieves and removes the maximum element in the stack.
 *
 * Video Explanation: https://www.youtube.com/watch?v=SyDmmNQFW_I
 * LeetCode Problem Link: https://leetcode.com/problems/max-stack/
 */
public class MaxStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        System.out.println("=== MaxStack ===");
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        System.out.println("peekMax: " + maxStack.peekMax()); // 5
        System.out.println("pop: " + maxStack.pop());        // 1
        System.out.println("peekMax: " + maxStack.peekMax()); // 5
    }

    /**
     * Solution: Use two stacks - one for elements and one for tracking maximums.
     * Time: O(1) for all operations, Space: O(n)
     */
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    public int peekMax() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }

    /**
     * Removes and returns the maximum element.
     * Time: O(n) in worst case, Space: O(1)
     */
    public int popMax() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }

        int max = maxStack.peek();
        Deque<Integer> temp = new ArrayDeque<>();

        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }

        stack.pop();
        maxStack.pop();

        while (!temp.isEmpty()) {
            int val = temp.pop();
            stack.push(val);
            if (maxStack.isEmpty() || val >= maxStack.peek()) {
                maxStack.push(val);
            } else {
                maxStack.push(maxStack.peek());
            }
        }

        return max;
    }

    /**
     * Alternative Solution: Using TreeMap for O(log n) max retrieval.
     * Time: O(log n) for push/pop/max operations, O(n) for popMax
     */
    public static class MaxStackWithTreeMap {
        private final Deque<Integer> stack;
        private final TreeMap<Integer, Integer> maxMap;

        public MaxStackWithTreeMap() {
            stack = new ArrayDeque<>();
            maxMap = new TreeMap<>();
        }

        public void push(int x) {
            stack.push(x);
            maxMap.merge(x, 1, Integer::sum);
        }

        public int pop() {
            if (stack.isEmpty()) throw new EmptyStackException();
            int val = stack.pop();
            int count = maxMap.get(val);
            if (count == 1) {
                maxMap.remove(val);
            } else {
                maxMap.put(val, count - 1);
            }
            return val;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxMap.lastKey();
        }

        public int popMax() {
            int max = maxMap.lastKey();
            int count = maxMap.get(max);
            if (count == 1) {
                maxMap.remove(max);
            } else {
                maxMap.put(max, count - 1);
            }

            Deque<Integer> temp = new ArrayDeque<>();
            while (stack.peek() != max) {
                temp.push(stack.pop());
            }
            stack.pop();

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }

            return max;
        }
    }

    /**
     * Alternative Stream-based approach for peekMax (O(n) not O(1)).
     * Time: O(n), Space: O(1)
     */
    public int peekMaxStream() {
        return stack.stream().max(Integer::compare).orElseThrow(NoSuchElementException::new);
    }
}
