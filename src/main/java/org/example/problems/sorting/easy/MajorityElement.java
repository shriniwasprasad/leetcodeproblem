package org.example.problems.sorting.easy;

import java.util.*;

/**
 * Problem: Majority Element
 * Topic: Sorting / Boyer-Moore Voting
 * Level: Easy
 *
 * Problem Description:
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than floor(n/2) times.
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Video Explanation: https://www.youtube.com/watch?v=u_H6y瑾u3E
 * LeetCode Problem Link: https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println("=== MajorityElement ===");
        System.out.println(solution(new int[]{3, 2, 3})); // 3
        System.out.println(alternativeSolution(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
    }

    /**
     * Solution: Boyer-Moore Voting Algorithm.
     * Time: O(n), Space: O(1)
     */
    public static int solution(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * Alternative Solution: Sorting.
     * Since majority appears > n/2 times, the median is always the answer.
     * Time: O(n log n), Space: O(1) or O(n) depending on sort implementation
     */
    public static int alternativeSolution(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Alternative Solution: Stream API with frequency count.
     * Time: O(n), Space: O(n)
     */
    public static int alternativeStreamSolution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(p -> p, java.util.stream.Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length / 2)
                .map(e -> e.getKey())
                .findFirst()
                .orElse(-1);
    }
}
