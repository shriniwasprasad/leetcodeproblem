package org.example.problems.sorting.medium;

import java.util.*;

/**
 * Problem: Largest Number
 * Topic: Sorting / Custom Comparator
 * Level: Medium
 *
 * Problem Description:
 * Given a list of non-negative integers, arrange them to form the largest possible number.
 *
 * Input: [10, 2]
 * Output: "210"
 *
 * Video Explanation: https://www.youtube.com/watch?v=q6tyGuVVbfE
 * LeetCode Problem Link: https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

    public static void main(String[] args) {
        System.out.println("=== LargestNumber ===");
        System.out.println(solution(new int[]{10, 2})); // "210"
        System.out.println(alternativeSolution(new int[]{3, 30, 34, 5, 9})); // "9534330"
    }

    /**
     * Solution: Custom comparator to compare concatenation order.
     * For numbers a and b, compare "ab" vs "ba" to decide order.
     * Time: O(n log n), Space: O(n)
     */
    public static String solution(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s);
        }
        return result.toString();
    }

    /**
     * Alternative Solution: Using Stream API with custom comparator.
     * Time: O(n log n), Space: O(n)
     */
    public static String alternativeSolution(int[] nums) {
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .reduce("", String::concat);

        if (result.length() > 0 && result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }
}
