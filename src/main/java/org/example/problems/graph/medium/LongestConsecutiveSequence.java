package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Longest Consecutive Sequence
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive length = " + solution(nums));
    }

    /**
     * Use a HashSet to achieve O(n) time.
     */
    public static Object solution(Object input) {
        int[] nums = (int[]) input;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) { // start of a sequence
                int cur = num;
                int length = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static Object alternativeSolution(Object input) {
        // Stream API does not simplify the contiguous‑run detection.
        return solution(input);
    }
}
