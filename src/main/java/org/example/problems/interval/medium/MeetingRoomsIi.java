package org.example.problems.interval.medium;

import java.util.*;

/**
 * Problem: Meeting Rooms II (LeetCode 253)
 * Topic: Interval, Greedy, Heap
 * Level: Medium
 *
 * Problem Description:
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Video Explanation: https://www.youtube.com/watch?v=sQkgNfoPrDw
 * LeetCode Problem Link: https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsIi {

    public static void main(String[] args) {
        // Test case 1
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test 1 (Min-Heap): " + solution(intervals1));  // Expected: 2

        // Test case 2
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test 2 (Min-Heap): " + solution(intervals2));  // Expected: 1

        // Test case 3
        int[][] intervals3 = {{1, 5}, {8, 9}, {8, 9}};
        System.out.println("Test 3 (Min-Heap): " + solution(intervals3));  // Expected: 2

        // Test case 4
        int[][] intervals4 = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        System.out.println("Test 4 (Min-Heap): " + solution(intervals4));  // Expected: 4

        // Alternative solution tests (Chronological Ordering)
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(intervals1));  // Expected: 2
        System.out.println("Test 2: " + alternativeSolution(intervals2));  // Expected: 1
    }

    /**
     * Min-Heap approach to find minimum meeting rooms needed.
     * Use a min-heap to track end times of meetings in each room.
     * Time Complexity: O(n log n) for sorting + O(n log n) for heap operations
     * Space Complexity: O(n) for the heap
     *
     * @param intervals array of meeting time intervals [start, end]
     * @return minimum number of conference rooms required
     */
    public static int solution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to track end times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first meeting
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If the earliest ending meeting is done before current meeting starts
            if (minHeap.peek() <= intervals[i][0]) {
                // Reuse that room - remove the ended meeting
                minHeap.poll();
            }

            // Add current meeting's end time
            minHeap.offer(intervals[i][1]);
        }

        // Heap size = number of rooms needed
        return minHeap.size();
    }

    /**
     * Chronological ordering approach using separate start and end arrays.
     * Track when meetings start and end separately.
     * Time Complexity: O(n log n) for sorting
     * Space Complexity: O(n) for start and end arrays
     *
     * @param intervals array of meeting time intervals
     * @return minimum number of conference rooms required
     */
    public static int alternativeSolution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        // Extract start and end times
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // Sort both arrays
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endPtr = 0;

        // Process all start times
        for (int startPtr = 0; startPtr < n; startPtr++) {
            // If a meeting has ended before current meeting starts
            if (starts[startPtr] < ends[endPtr]) {
                // Need a new room
                rooms++;
            } else {
                // A room became free, reuse it
                endPtr++;
            }
        }

        return rooms;
    }
}
