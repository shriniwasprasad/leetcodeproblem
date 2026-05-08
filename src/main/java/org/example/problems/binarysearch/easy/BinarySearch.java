package org.example.problems.binarysearch.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Binary Search
 * Topic: Binary Search
 * Level: Easy
 * <p>
 * Problem Description:
 * Binary Search - See LeetCode for full problem statement.
 * <p>
 * Input: int[] nums = {-1, 0, 3, 5, 9, 12}; int target = 9
 * Output: int = 4
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=t3yPHFyKxr4">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/binary-search/">...</a>
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("=== BinarySearch ===");
    }

    public static int solution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int alternativeSolution(int[] nums, int target) {
        int[] result = IntStream.range(0, nums.length)
                .filter(i -> nums[i] == target)
                .limit(1)
                .toArray();
        return result.length > 0 ? result[0] : -1;
    }
}
