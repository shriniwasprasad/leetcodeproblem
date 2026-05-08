package org.example.problems.heap.hard;

import java.util.*;

/**
 * Problem: Employee Free Time
 * Topic: Heap
 * Level: Hard
 *
 * Problem Description:
 * We are given a list of employees' working hours. Each employee has a list
 * of non-overlapping intervals. Return a list of finite intervals representing
 * the common free time for all employees.
 *
 * Input: [[1,2],[5,6]], [[1,3]], [[4,10]]
 * Output: [[3,4]] (Employee 1 free [1,2], Employee 2 free [1,3], Employee 3 free [4,10])
 *
 * Video Explanation: https://www.youtube.com/watch?v=99l7goR4y0U
 * LeetCode Problem Link: https://leetcode.com/problems/employee-free-time/
 */
public class EmployeeFreeTime {

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedule.add(Arrays.asList(new Interval(1, 3)));
        schedule.add(Arrays.asList(new Interval(4, 10)));
        System.out.println("Input: [[1,2],[5,6]], [[1,3]], [[4,10]]");
        System.out.println("Output: " + solution(schedule));
    }

    // Min-heap approach: O(N log N) time where N is total intervals
    // Key insight: Use min-heap to track the current earliest available interval
    public static List<Interval> solution(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        // Min-heap stores index of employee and current interval index
        // Priority by interval start time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start
        );

        // Find the common free time range
        int lastEnd = -1;

        // Initialize heap with each employee's first interval
        for (int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int empIdx = top[0];
            int intIdx = top[1];
            Interval current = schedule.get(empIdx).get(intIdx);

            // If there's a gap between last end and current start, it's free time
            if (lastEnd != -1 && lastEnd < current.start) {
                result.add(new Interval(lastEnd, current.start));
            }

            // Update last end to be the maximum of the intervals we've seen
            lastEnd = Math.max(lastEnd, current.end);

            // Add next interval from same employee
            if (intIdx + 1 < schedule.get(empIdx).size()) {
                minHeap.offer(new int[]{empIdx, intIdx + 1});
            }
        }

        return result;
    }

    // Alternative: Merge all intervals then find gaps
    public static List<Interval> alternativeSolution(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> emp : schedule) {
            allIntervals.addAll(emp);
        }

        // Sort by start time
        Collections.sort(allIntervals, (a, b) -> a.start - b.start);

        List<Interval> merged = new ArrayList<>();
        for (Interval interval : allIntervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).end < interval.start) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1).end =
                    Math.max(merged.get(merged.size() - 1).end, interval.end);
            }
        }

        // Find gaps between merged intervals
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            result.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }
        return result;
    }

    // Interval class definition
    static class Interval {
        int start;
        int end;
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString() { return "[" + start + "," + end + "]"; }
    }
}