package org.example.problems.binarysearch.medium;

import java.util.*;

/**
 * Problem: Search a 2D Matrix
 * Topic: Binary Search
 * Level: Medium
 *
 * Problem Description:
 * Search a 2D Matrix - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=dP4cb8zbohY
 * LeetCode Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        System.out.println("=== SearchA2dMatrix ===");
    }

    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / cols][mid % cols];
            if (midVal == target) return true;
            else if (midVal < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static boolean alternativeSolution(int[][] matrix, int target) {
        // Using Stream API to flatten matrix and search for target
        return java.util.Arrays.stream(matrix)
                .flatMapToInt(java.util.Arrays::stream)
                .anyMatch(val -> val == target);
    }
}
