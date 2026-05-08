package org.example.problems.stack.medium;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem: Daily Temperatures
 * Topic: Stack
 * Level: Medium
 *
 * Problem Description:
 * Given an array of integers representing daily temperatures, return an array
 * where answer[i] is the number of days to wait for a warmer temperature.
 * If no warmer temperature exists, answer[i] = 0.
 *
 * Input: temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
 * Output: [1, 1, 4, 2, 1, 1, 0, 0]
 *
 * Video Explanation: https://www.youtube.com/watch?v=jmuo4BBfl3I
 * LeetCode Problem Link: https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println("=== DailyTemperatures ===");
        System.out.println(Arrays.toString(solution(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(alternativeBruteForce(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    /**
     * Solution: Monotonic decreasing stack storing indices.
     * For each day, pop indices with lower temperatures and set their answer.
     * Time: O(n), Space: O(n)
     */
    public static int[] solution(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    /**
     * Alternative Solution: Brute force approach.
     * For each temperature, search forward for a warmer day.
     * Time: O(n^2), Space: O(1)
     */
    public static int[] alternativeBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                count++;
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = count;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * Alternative Solution: Stream API approach.
     * Note: Stream API is not ideal for this problem due to stateful nature.
     * This is a pedagogical example showing stream limitations.
     * Time: O(n^2), Space: O(n) for stream processing
     */
    public static int[] alternativeStreamSolution(int[] temperatures) {
        int n = temperatures.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final int currentTemp = temperatures[i];
            int finalI = i;
            int days = IntStream.range(i + 1, n)
                    .filter(j -> temperatures[j] > currentTemp)
                    .findFirst()
                    .orElse(-1);
            result.add(days == -1 ? 0 : days - finalI);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
