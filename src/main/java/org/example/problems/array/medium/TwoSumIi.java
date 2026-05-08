package org.example.problems.array.medium;

import java.util.*;

/**
 * Problem: Two Sum - II
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 *
 * Input: int[] numbers = {2, 7, 11, 15}; int target = 9
 * Output: int[] = {0, 1} (0-indexed in output)
 *
 * Video Explanation: https://www.youtube.com/watch?v=c9ywRRJcP1Y
 * LeetCode Problem Link: https://leetcode.com/problems/two-sum-ii/
 */
public class TwoSumIi {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Input: numbers = [2, 7, 11, 15], target = " + target);
        System.out.println("Output: " + Arrays.toString(solution(numbers, target)));
    }

    // Two-pointer technique: start from both ends, move inward based on sum comparison
    public static int[] solution(int[] numbers, int target) {
        int left = 0;                    // Pointer at start
        int right = numbers.length - 1;  // Pointer at end

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // Found the pair that adds up to target
                return new int[]{left, right};
            } else if (sum < target) {
                // Sum is too small, need larger values, move left pointer right
                left++;
            } else {
                // Sum is too large, need smaller values, move right pointer left
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Alternative: HashMap approach (O(n) but uses extra space)
    public static int[] alternativeSolution(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}