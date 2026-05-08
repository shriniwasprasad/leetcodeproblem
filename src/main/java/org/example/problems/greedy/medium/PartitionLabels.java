package org.example.problems.greedy.medium;

import java.util.*;

/**
 * Problem: Partition Labels (LeetCode 763)
 * Topic: Greedy, Hash Map, Two Pointers
 * Level: Medium
 *
 * Problem Description:
 * You are given a string s. We want to partition the string into as many parts as possible
 * so that each letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order,
 * the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation: The partition is "ababcbaca", "defegde", "hijhklij".
 *
 * Example 2:
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 * Video Explanation: https://www.youtube.com/watch?v=TvWEYhHPO0w
 * LeetCode Problem Link: https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {

    public static void main(String[] args) {
        // Test case 1
        String s1 = "ababcbacadefegdehijhklij";
        List<Integer> result1 = solution(s1);
        System.out.println("Test 1 (Greedy): " + result1);  // Expected: [9, 7, 8]

        // Test case 2
        String s2 = "eccbbbbdec";
        List<Integer> result2 = solution(s2);
        System.out.println("Test 2 (Greedy): " + result2);  // Expected: [10]

        // Test case 3
        String s3 = "abcdefghijklmnopqrstuvwxyz";
        List<Integer> result3 = solution(s3);
        System.out.println("Test 3 (Greedy): " + result3);  // Expected: [1, 1, 1, ...]

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(s1));  // Expected: [9, 7, 8]
        System.out.println("Test 2: " + alternativeSolution(s2));  // Expected: [10]
    }

    /**
     * Greedy approach - track last occurrence of each character.
     * Extend partition until we reach the farthest last occurrence.
     * Time Complexity: O(n) - two passes: one to find last positions, one to partition
     * Space Complexity: O(1) - fixed size array of 26 for lowercase letters
     *
     * @param s input string
     * @return list of partition sizes
     */
    public static List<Integer> solution(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        // Store last occurrence of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        // Partition the string
        for (int i = 0; i < s.length(); i++) {
            // Extend the partition end to include all occurrences of current character
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);

            // If we've reached the end of current partition
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

    /**
     * Alternative approach using HashMap for more flexibility with character set.
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the size of character set
     *
     * @param s input string
     * @return list of partition sizes
     */
    public static List<Integer> alternativeSolution(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        // Map to store last index of each character
        Map<Character, Integer> lastMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastMap.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, lastMap.get(c));

            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }
}
