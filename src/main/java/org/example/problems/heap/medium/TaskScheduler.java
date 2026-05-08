package org.example.problems.heap.medium;

import java.util.*;

/**
 * Problem: Task Scheduler (LeetCode 621)
 * Topic: Heap / Priority Queue, Greedy, Queue
 * Level: Medium
 *
 * Problem Description:
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n.
 * Each CPU interval can be idle or allow the completion of one task. Tasks can be completed
 * in any order, but there's a constraint: there has to be a gap of at least n intervals
 * between two tasks with the same label.
 *
 * Return the minimum number of CPU intervals required to complete all tasks.
 *
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B
 *
 * Example 2:
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * Output: 6
 * Explanation: A -> B -> C -> D -> A -> B
 *
 * Example 3:
 * Input: tasks = ["A","A","A","B","B","B"], n = 3
 * Output: 10
 * Explanation: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B
 *
 * Video Explanation: https://www.youtube.com/watch?v=IcjlqToRGWI
 * LeetCode Problem Link: https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {

    public static void main(String[] args) {
        // Test case 1
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("Test 1 (Max Heap): " + solution(tasks1, 2));  // Expected: 8

        // Test case 2
        char[] tasks2 = {'A', 'C', 'A', 'B', 'D', 'B'};
        System.out.println("Test 2 (Max Heap): " + solution(tasks2, 1));  // Expected: 6

        // Test case 3
        char[] tasks3 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("Test 3 (Max Heap): " + solution(tasks3, 3));  // Expected: 10

        // Test case 4
        char[] tasks4 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println("Test 4 (Max Heap): " + solution(tasks4, 2));  // Expected: 12

        // Alternative solution (Math-based formula) test
        System.out.println("\nAlternative Solution Tests:");
        int[] tasks5 = convertToCounts(tasks1);
        System.out.println("Test 1 (Math): " + alternativeSolution(tasks5, 2));  // Expected: 8
    }

    /**
     * Max-Heap approach to schedule tasks with cooling period.
     * At each interval, pick the task with highest remaining count.
     * Time Complexity: O(n log m) where n=total tasks, m=number of unique tasks
     * Space Complexity: O(m) for the heap and count array
     *
     * @param tasks array of task characters
     * @param n cooling interval between same tasks
     * @return minimum number of CPU intervals required
     */
    public static int solution(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        // Count frequency of each task
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        // Max-heap to store task frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : counts) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int intervals = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> remaining = new ArrayList<>();
            int processed = 0;

            // Process up to (n+1) tasks in this cycle
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll() - 1;
                    if (count > 0) {
                        remaining.add(count);
                    }
                    processed++;
                }
            }

            // Add back remaining task counts to heap
            for (int count : remaining) {
                maxHeap.offer(count);
            }

            // Add intervals
            if (!maxHeap.isEmpty()) {
                // Full cycle of (n+1) intervals
                intervals += n + 1;
            } else {
                // Last cycle - only count tasks actually processed
                intervals += processed;
            }
        }

        return intervals;
    }

    /**
     * Math-based approach using the maximum frequency formula.
     * The key insight is that the bottleneck is the most frequent task.
     * Time Complexity: O(n) to count frequencies
     * Space Complexity: O(1) - fixed size array of 26
     *
     * @param counts array of task frequencies (indices 0-25 for A-Z)
     * @param n cooling interval between same tasks
     * @return minimum number of CPU intervals required
     */
    public static int alternativeSolution(int[] counts, int n) {
        if (counts == null || counts.length == 0) {
            return 0;
        }

        // Find maximum frequency and count of tasks with max frequency
        int maxFreq = 0;
        int maxCount = 0;

        for (int count : counts) {
            if (count > maxFreq) {
                maxFreq = count;
                maxCount = 1;
            } else if (count == maxFreq) {
                maxCount++;
            }
        }

        // Calculate number of partitions and slots per partition
        int partitions = maxFreq - 1;
        int emptySlots = partitions * n;
        int availableTasks = counts.length - maxCount;
        int idleSlots = Math.max(0, emptySlots - availableTasks);

        // Total = tasks + idle time
        return counts.length + idleSlots;
    }

    /**
     * Helper method to convert char array to frequency counts.
     */
    private static int[] convertToCounts(char[] tasks) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        return counts;
    }
}
