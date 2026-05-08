package org.example.problems.interval.medium;

import java.util.*;

/**
 * Problem: Remove Interval (LeetCode 1288)
 * Topic: Interval, Array
 * Level: Medium
 *
 * Problem Description:
 * Given a sorted list of disjoint intervals representing a set of real numbers,
 * and another interval toBeRemoved, return a sorted list of disjoint intervals
 * after removing toBeRemoved from the intervals.
 *
 * Example 1:
 * Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
 * Output: [[0,1],[6,7]]
 *
 * Example 2:
 * Input: intervals = [[0,5]], toBeRemoved = [2,3]
 * Output: [[0,2],[3,5]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=YrB_zKEHgmQ
 * LeetCode Problem Link: https://leetcode.com/problems/remove-interval/
 */
public class RemoveInterval {

    public static void main(String[] args) {
        // Test case 1
        int[][] intervals1 = {{0, 2}, {3, 4}, {5, 7}};
        int[] toBeRemoved1 = {1, 6};
        int[][] result1 = solution(intervals1, toBeRemoved1);
        System.out.print("Test 1 - Result: ");
        printIntervals(result1);  // Expected: [0,1], [6,7]

        // Test case 2
        int[][] intervals2 = {{0, 5}};
        int[] toBeRemoved2 = {2, 3};
        int[][] result2 = solution(intervals2, toBeRemoved2);
        System.out.print("Test 2 - Result: ");
        printIntervals(result2);  // Expected: [0,2], [3,5]

        // Test case 3: Remove entire interval
        int[][] intervals3 = {{1, 4}};
        int[] toBeRemoved3 = {1, 4};
        int[][] result3 = solution(intervals3, toBeRemoved3);
        System.out.print("Test 3 - Result: ");
        printIntervals(result3);  // Expected: (empty)

        // Alternative solution test
        System.out.println("\nAlternative Solution Tests:");
        int[][] intervals4 = {{0, 2}, {3, 4}, {5, 7}};
        int[] toBeRemoved4 = {1, 6};
        int[][] result4 = alternativeSolution(intervals4, toBeRemoved4);
        System.out.print("Test 1 - Result: ");
        printIntervals(result4);
    }

    /**
     * Process each interval and handle different overlap cases.
     * For each interval, determine if it overlaps with toBeRemoved and split if necessary.
     * Time Complexity: O(n) - single pass through intervals
     * Space Complexity: O(n) for the result list
     *
     * @param intervals sorted list of disjoint intervals
     * @param toBeRemoved the interval to remove
     * @return modified list of intervals after removal
     */
    public static int[][] solution(int[][] intervals, int[] toBeRemoved) {
        List<int[]> result = new ArrayList<>();
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Case 1: Interval is completely before the removal interval
            if (end <= removeStart) {
                result.add(interval);
            }
            // Case 2: Interval is completely after the removal interval
            else if (start >= removeEnd) {
                result.add(interval);
            }
            // Case 3: Interval partially overlaps on the left
            else if (start < removeStart && end > removeStart && end <= removeEnd) {
                result.add(new int[]{start, removeStart});
            }
            // Case 4: Interval partially overlaps on the right
            else if (start >= removeStart && start < removeEnd && end > removeEnd) {
                result.add(new int[]{removeEnd, end});
            }
            // Case 5: Interval is completely within removal interval (skip it)
            else if (start >= removeStart && end <= removeEnd) {
                // Don't add - this interval is removed
            }
            // Case 6: Removal interval is completely within this interval (split it)
            else if (start < removeStart && end > removeEnd) {
                result.add(new int[]{start, removeStart});
                result.add(new int[]{removeEnd, end});
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * Alternative simplified approach.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param intervals sorted list of intervals
     * @param toBeRemoved the interval to remove
     * @return modified list of intervals
     */
    public static int[][] alternativeSolution(int[][] intervals, int[] toBeRemoved) {
        List<int[]> result = new ArrayList<>();
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If interval doesn't overlap, add it as-is
            if (end <= removeStart || start >= removeEnd) {
                result.add(interval);
            } else {
                // Add the part before removal interval if exists
                if (start < removeStart) {
                    result.add(new int[]{start, Math.min(end, removeStart)});
                }
                // Add the part after removal interval if exists
                if (end > removeEnd) {
                    result.add(new int[]{Math.max(start, removeEnd), end});
                }
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
