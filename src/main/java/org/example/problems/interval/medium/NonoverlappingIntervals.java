package org.example.problems.interval.medium;

import java.util.*;

/**
 * Problem: Non-overlapping Intervals (LeetCode 435)
 * Topic: Interval, Greedy, Sorting
 * Level: Medium
 *
 * Problem Description:
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest
 * of the intervals non-overlapping.
 *
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 * Example 2:
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * Example 3:
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * Video Explanation: https://www.youtube.com/watch?v=y8nBFmPsAF8
 * LeetCode Problem Link: https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonoverlappingIntervals {

    public static void main(String[] args) {
        // Test case 1
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Test 1 (Greedy - Sort by End): " + solution(intervals1));  // Expected: 1

        // Test case 2
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Test 2 (Greedy - Sort by End): " + solution(intervals2));  // Expected: 2

        // Test case 3
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println("Test 3 (Greedy - Sort by End): " + solution(intervals3));  // Expected: 0

        // Test case 4
        int[][] intervals4 = {{1, 100}, {11, 22}, {1, 10}, {1, 5}};
        System.out.println("Test 4 (Greedy - Sort by End): " + solution(intervals4));  // Expected: 2

        // Alternative solution tests (Sort by Start)
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(intervals1));  // Expected: 1
        System.out.println("Test 2: " + alternativeSolution(intervals2));  // Expected: 2
    }

    /**
     * Greedy approach - sort by end time.
     * Always keep the interval that ends earliest to maximize room for others.
     * Time Complexity: O(n log n) for sorting
     * Space Complexity: O(1)
     *
     * @param intervals array of intervals [start, end]
     * @return minimum number of intervals to remove
     */
    public static int solution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;  // Count of non-overlapping intervals (always keep first)
        int end = intervals[0][1];  // End of last added interval

        for (int i = 1; i < intervals.length; i++) {
            // If current interval doesn't overlap with last added
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        // Intervals to remove = total - non-overlapping
        return intervals.length - count;
    }

    /**
     * Greedy approach - sort by start time.
     * When overlap occurs, remove the interval that ends later.
     * Time Complexity: O(n log n) for sorting
     * Space Complexity: O(1)
     *
     * @param intervals array of intervals
     * @return minimum number of intervals to remove
     */
    public static int alternativeSolution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removeCount = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlap found - remove the interval that ends later
                end = Math.min(end, intervals[i][1]);
                removeCount++;
            } else {
                // No overlap - update end
                end = intervals[i][1];
            }
        }

        return removeCount;
    }
}
