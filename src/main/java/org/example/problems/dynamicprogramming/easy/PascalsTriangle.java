package org.example.problems.dynamicprogramming.easy;

import java.util.*;

/**
 * Problem: Pascal's Triangle (LeetCode 118)
 * Topic: Dynamic Programming, Array
 * Level: Easy
 *
 * Problem Description:
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=f0EEHwaY3HY
 * LeetCode Problem Link: https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println("Test 1 (numRows = 5):");
        printTriangle(solution(5));

        System.out.println("\nTest 2 (numRows = 1):");
        printTriangle(solution(1));

        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1:");
        printTriangle(alternativeSolution(5));
    }

    /**
     * Dynamic Programming approach to generate Pascal's Triangle.
     * Each element is the sum of the two elements above it.
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(numRows^2) for output
     *
     * @param numRows number of rows to generate
     * @return Pascal's triangle as list of lists
     */
    public static List<List<Integer>> solution(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        // First row is always [1]
        triangle.add(Collections.singletonList(1));

        // Generate subsequent rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // First element is always 1
            currentRow.add(1);

            // Middle elements are sum of two elements from previous row
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element is always 1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }

    /**
     * Alternative approach with slightly different structure.
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(numRows^2)
     *
     * @param numRows number of rows
     * @return Pascal's triangle
     */
    public static List<List<Integer>> alternativeSolution(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements are 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of two elements from previous row
                    List<Integer> prevRow = triangle.get(i - 1);
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }

            triangle.add(row);
        }

        return triangle;
    }

    /**
     * Helper method to print the triangle.
     */
    private static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            System.out.print(row);
            System.out.println();
        }
    }
}
