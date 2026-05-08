package org.example.problems.interval.medium;

import java.util.*;

/**
 * Problem: Merge Intervals (LeetCode 56)
 * Topic: Interval, Sorting
 * Level: Medium
 *
 * Problem Description:
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Video Explanation: https://www.youtube.com/watch?v=n3F2v9f8OfY
 * LeetCode Problem Link: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static void main(String[] args) {
        // Test case 1: Basic merging
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution(intervals1);
        System.out.print("Test 1 - Merged: ");
        printIntervals(result1);  // Expected: [1,6], [8,10], [15,18]

        // Test case 2: Adjacent intervals
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution(intervals2);
        System.out.print("Test 2 - Merged: ");
        printIntervals(result2);  // Expected: [1,5]

        // Test case 3: All overlapping
        int[][] intervals3 = {{1, 4}, {2, 3}, {0, 5}};
        int[][] result3 = solution(intervals3);
        System.out.print("Test 3 - Merged: ");
        printIntervals(result3);  // Expected: [0,5]

        // Alternative solution test
        System.out.println("\nAlternative Solution Tests:");
        int[][] intervals4 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result4 = alternativeSolution(intervals4);
        System.out.print("Test 1 - Merged: ");
        printIntervals(result4);
    }

    /**
     * Sort and merge approach.
     * Sort intervals by start time, then merge overlapping intervals.
     * Time Complexity: O(n log n) for sorting
     * Space Complexity: O(n) for the result list
     *
     * @param intervals array of intervals [start, end]
     * @return merged non-overlapping intervals
     */
    public static int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // If intervals overlap, merge them
            if (nextStart <= currentEnd) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to next interval
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Alternative approach with explicit loop and cleaner merge logic.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     *
     * @param intervals array of intervals
     * @return merged non-overlapping intervals
     */
    public static int[][] alternativeSolution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMerged = result.get(result.size() - 1);
            int[] current = intervals[i];

            // Check if current interval overlaps with last merged interval
            if (current[0] <= lastMerged[1]) {
                // Merge by updating the end time
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // Add current interval to result
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * Helper method to print intervals.
     */
    private static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
            if (i < intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
