package org.example.problems.stack.hard;

import java.util.*;

/**
 * Problem: Largest Rectangle in Histogram
 * Topic: Stack / Monotonic Stack
 * Level: Hard
 *
 * Problem Description:
 * Given an array of integers representing the heights of bars in a histogram,
 * find the largest rectangle area that can be formed in the histogram.
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The largest rectangle is of height 5, spanning bars at indices 2 and 3.
 *
 * Video Explanation: https://www.youtube.com/watch?v=IasMlShanvc
 * LeetCode Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println("=== LargestRectangleInHistogram ===");
        System.out.println(solution(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(alternativeSolution(new int[]{2, 1, 5, 6, 2, 3})); // 10
    }

    /**
     * Solution: Monotonic increasing stack.
     * Push indices, when height decreases, pop and calculate areas.
     * Time: O(n), Space: O(n)
     */
    public static int solution(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    /**
     * Alternative Solution: Divide and conquer.
     * Recursively find max in left half, right half, and crossing middle.
     * Time: O(n log n) average, O(n^2) worst case, Space: O(log n)
     */
    public static int alternativeSolution(int[] heights) {
        return divideAndConquer(heights, 0, heights.length - 1);
    }

    private static int divideAndConquer(int[] heights, int left, int right) {
        if (left > right) {
            return 0;
        }

        int minIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }

        int maxArea = heights[minIndex] * (right - left + 1);
        maxArea = Math.max(maxArea, divideAndConquer(heights, left, minIndex - 1));
        maxArea = Math.max(maxArea, divideAndConquer(heights, minIndex + 1, right));

        return maxArea;
    }

    /**
     * Alternative Solution: Brute force approach.
     * For each bar, expand left and right to find the largest rectangle including it.
     * Time: O(n^2), Space: O(1)
     */
    public static int bruteForceSolution(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;

            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }

            maxArea = Math.max(maxArea, heights[i] * (right - left + 1));
        }
        return maxArea;
    }

    /**
     * Alternative Solution: Stream API with helper methods.
     * Not truly streaming due to stateful calculations.
     * Time: O(n^2), Space: O(n)
     */
    public static int alternativeStreamSolution(int[] heights) {
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i <= heights.length; i++) {
            int finalI = i;
            int height = (i == heights.length) ? 0 : heights[i];
            results.add(new int[]{finalI, height});
        }

        return results.stream()
                .reduce(new int[]{0, 0, 0}, (state, item) -> {
                    int i = item[0];
                    int h = item[1];
                    if (h > 0) {
                        int width = state[2] == 0 ? i : i - state[2] - 1;
                        state[0] = Math.max(state[0], h * width);
                        if (state[1] == 0 || h < state[1]) {
                            state[1] = h;
                            state[2] = i;
                        }
                    }
                    return state;
                })[0];
    }
}
