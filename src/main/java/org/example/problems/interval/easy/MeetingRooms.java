package org.example.problems.interval.easy;

import java.util.*;

/**
 * Problem: Meeting Rooms (LeetCode 252)
 * Topic: Interval, Sorting
 * Level: Easy
 *
 * Problem Description:
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 *
 * Video Explanation: https://www.youtube.com/watch?v=5nqLiwo0oC0
 * LeetCode Problem Link: https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {

    public static void main(String[] args) {
        // Test case 1: Overlapping meetings
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test 1 (Overlapping): " + solution(intervals1));  // Expected: false

        // Test case 2: Non-overlapping meetings
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test 2 (Non-overlapping): " + solution(intervals2));  // Expected: true

        // Test case 3: Single meeting
        int[][] intervals3 = {{1, 5}};
        System.out.println("Test 3 (Single meeting): " + solution(intervals3));  // Expected: true

        // Test case 4: Empty array
        int[][] intervals4 = {};
        System.out.println("Test 4 (Empty): " + solution(intervals4));  // Expected: true

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(intervals1));  // Expected: false
        System.out.println("Test 2: " + alternativeSolution(intervals2));  // Expected: true
    }

    /**
     * Sort by start time and check for overlaps.
     * After sorting, if any meeting starts before the previous one ends, there's a conflict.
     * Time Complexity: O(n log n) for sorting
     * Space Complexity: O(1) or O(log n) depending on sorting implementation
     *
     * @param intervals array of meeting time intervals [start, end]
     * @return true if a person can attend all meetings, false otherwise
     */
    public static boolean solution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Check for overlapping meetings
        for (int i = 1; i < intervals.length; i++) {
            // If current meeting starts before previous meeting ends
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Alternative approach using Comparator for sorting.
     * Same logic but with explicit Comparator.
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     *
     * @param intervals array of meeting time intervals
     * @return true if a person can attend all meetings, false otherwise
     */
    public static boolean alternativeSolution(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        // Sort using Comparator
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < previousEnd) {
                return false;
            }
            previousEnd = intervals[i][1];
        }

        return true;
    }
}
