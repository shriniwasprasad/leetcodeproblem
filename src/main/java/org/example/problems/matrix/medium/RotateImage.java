package org.example.problems.matrix.medium;

import java.util.stream.IntStream;

/**
 * Problem: Rotate Image (LeetCode 48)
 * Topic: Matrix
 * Level: Medium
 *
 * Problem Description:
 * Given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to do it in only constant extra space.
 * The rotation is done clockwise.
 *
 * Approach:
 * 1. Transpose the matrix (swap rows with columns)
 * 2. Reverse each row
 *
 * Example:
 * Input: [[1,2,3],
 *         [4,5,6],
 *         [7,8,9]]
 * Output: [[7,4,1],
 *          [8,5,2],
 *          [9,6,3]]
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Input: " + printMatrix(matrix1));
        rotateImage(matrix1);
        System.out.println("After rotation: " + printMatrix(matrix1));

        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        System.out.println("\nInput: " + printMatrix(matrix2));
        rotateImage(matrix2);
        System.out.println("After rotation: " + printMatrix(matrix2));
    }

    /**
     * Standard solution: Rotate 90 degrees clockwise
     * Steps:
     * 1. Transpose the matrix (swap matrix[i][j] with matrix[j][i])
     * 2. Reverse each row
     * Time: O(n^2), Space: O(1)
     */
    public static void rotateImage(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    /**
     * Alternative solution using Stream API
     * Creates a new matrix and returns the result
     * Time: O(n^2), Space: O(n^2) for the new matrix
     */
    public static int[][] rotateImageStream(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }

        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // New position after 90-degree clockwise rotation
                // (i, j) -> (j, n - 1 - i)
                result[j][n - 1 - i] = matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Stream API version using Java 8+ features
     * This approach uses streams to create a more functional style
     * Time: O(n^2), Space: O(n^2) for the new matrix
     */
    public static int[][] rotateImageStreamAdvanced(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }

        int n = matrix.length;
        int[][] result = new int[n][n];

        // Use streams to transpose
        for (int col = 0; col < n; col++) {
            final int currentCol = col;
            IntStream.range(0, n)
                    .forEach(row -> {
                        result[currentCol][n - 1 - row] = matrix[row][currentCol];
                    });
        }
        return result;
    }

    /**
     * Helper method to print matrix in readable format
     */
    private static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
