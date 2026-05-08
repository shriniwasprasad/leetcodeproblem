package org.example.problems.interval.medium;

import java.util.*;

/**
 * Problem: Insert Interval (LeetCode 57)
 * Topic: Interval, Array
 * Level: Medium
 *
 * Problem Description:
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Video Explanation: https://www.youtube.com/watch?v=16YiKk6ga7Y
 * LeetCode Problem Link: https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public static void main(String[] args) {
        // Test case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = solution(intervals1, newInterval1);
        System.out.print("Test 1 - Result: ");
        printIntervals(result1);  // Expected: [1,5], [6,9]

        // Test case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = solution(intervals2, newInterval2);
        System.out.print("Test 2 - Result: ");
        printIntervals(result2);  // Expected: [1,2], [3,10], [12,16]

        // Test case 3: Insert at beginning
        int[][] intervals3 = {{3, 5}, {6, 9}};
        int[] newInterval3 = {1, 2};
        int[][] result3 = solution(intervals3, newInterval3);
        System.out.print("Test 3 - Result: ");
        printIntervals(result3);  // Expected: [1,2], [3,5], [6,9]

        // Test case 4: Insert at end
        int[][] intervals4 = {{1, 2}, {3, 5}};
        int[] newInterval4 = {6, 8};
        int[][] result4 = solution(intervals4, newInterval4);
        System.out.print("Test 4 - Result: ");
        printIntervals(result4);  // Expected: [1,2], [3,5], [6,8]

        // Alternative solution test
        System.out.println("\nAlternative Solution Tests:");
        int[][] intervals5 = {{1, 3}, {6, 9}};
        int[] newInterval5 = {2, 5};
        int[][] result5 = alternativeSolution(intervals5, newInterval5);
        System.out.print("Test 1 - Result: ");
        printIntervals(result5);
    }

    /**
     * Three-pass approach: add non-overlapping intervals before, merge, then add after.
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(n) for the result list
     *
     * @param intervals sorted array of non-overlapping intervals
     * @param newInterval the interval to insert
     * @return new array with inserted interval and merged overlaps
     */
    public static int[][] solution(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that end before newInterval starts (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * Single-pass approach with explicit state handling.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param intervals sorted array of intervals
     * @param newInterval the interval to insert
     * @return new array with inserted interval
     */
    public static int[][] alternativeSolution(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        boolean added = false;  // Track if newInterval has been added

        while (i < n) {
            // If current interval ends before newInterval starts
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }
            // If newInterval ends before current interval starts
            else if (newInterval[1] < intervals[i][0]) {
                if (!added) {
                    result.add(newInterval);
                    added = true;
                }
                result.add(intervals[i]);
                i++;
            }
            // Overlapping - merge
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }

        // If newInterval wasn't added yet, add it at the end
        if (!added) {
            result.add(newInterval);
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
