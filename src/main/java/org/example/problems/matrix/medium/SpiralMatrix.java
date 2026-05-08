package org.example.problems.matrix.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem: Spiral Matrix (LeetCode 54)
 * Topic: Matrix
 * Level: Medium
 *
 * Problem Description:
 * Given the matrix, return all elements of the matrix in spiral order.
 *
 * Approach:
 * 1. Define boundaries: top, bottom, left, right
 * 2. Traverse in spiral order: left->right, top->bottom, right->left, bottom->top
 * 3. Shrink boundaries after each traversal
 *
 * Time: O(m*n), Space: O(1) excluding result
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Input:");
        printMatrix(matrix1);
        System.out.println("Output: " + Arrays.toString(spiralOrder(matrix1)));

        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("\nInput:");
        printMatrix(matrix2);
        System.out.println("Output: " + Arrays.toString(spiralOrder(matrix2)));
    }

    /**
     * Standard solution using boundary traversal
     * Time: O(m*n), Space: O(m*n) for result
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int resultSize = m * n;
        int[] result = new int[resultSize];
        int index = 0;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (index < resultSize) {
            // Traverse from left to right
            for (int col = left; col <= right && index < resultSize; col++) {
                result[index++] = matrix[top][col];
            }
            top++;

            // Traverse from top to bottom
            for (int row = top; row <= bottom && index < resultSize; row++) {
                result[index++] = matrix[row][right];
            }
            right--;

            // Traverse from right to left
            for (int col = right; col >= left && index < resultSize; col--) {
                result[index++] = matrix[bottom][col];
            }
            bottom--;

            // Traverse from bottom to top
            for (int row = bottom; row >= top && index < resultSize; row--) {
                result[index++] = matrix[row][left];
            }
            left++;
        }

        return result;
    }

    /**
     * Alternative solution using Stream API
     * This version processes the matrix in a functional style
     * Time: O(m*n), Space: O(m*n) for result and intermediate lists
     */
    public static int[] spiralOrderStream(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Use ArrayList as a builder for streams
        ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // Left to right (top row)
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Top to bottom (right column)
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Right to left (bottom row)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Bottom to top (left column)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        // Convert to array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    /**
     * Helper method to print matrix
     */
    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
