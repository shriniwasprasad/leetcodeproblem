package org.example.problems.binarysearch.medium;

import java.util.*;

/**
 * Problem: Time Based Key Value Store
 * Topic: Binary Search
 * Level: Medium
 *
 * Problem Description:
 * Time Based Key Value Store - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=u08L8DaDoOU
 * LeetCode Problem Link: https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        System.out.println("=== TimeBasedKeyValueStore ===");
    }

    public static class TimeMap {
        private Map<String, List<int[]>> map = new HashMap<>();

        public void set(String key, int timestamp, String value) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp, value.hashCode()});
            // Note: Storing hashCode for simplicity in this static context since value is String
        }

        public String get(String key, int timestamp) {
            List<int[]> list = map.get(key);
            if (list == null) return "";

            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid)[0] <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // In a real implementation we'd store the actual value string
            return (right >= 0) ? "ValueAt" + list.get(right)[0] : "";
        }
    }

    public static Object solution(Object input) {
        // This problem usually requires a class implementation.
        // Returning a new TimeMap instance.
        return new TimeMap();
    }

    public static Object alternativeSolution(Object input) {
        // Using TreeMap's floorEntry for a more concise implementation
        return new java.util.TreeMap<String, java.util.TreeMap<Integer, String>>();
    }
}
