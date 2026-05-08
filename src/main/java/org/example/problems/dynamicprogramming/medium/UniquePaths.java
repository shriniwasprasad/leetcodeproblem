package org.example.problems.dynamicprogramming.medium;

/**
 * Problem: Unique Paths (LeetCode 62)
 * Topic: Dynamic Programming, Math
 * Level: Medium
 *
 * Problem Description:
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m-1][n-1]).
 *
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 *
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Video Explanation: https://www.youtube.com/watch?v=klWLMgdMWCY
 * LeetCode Problem Link: https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1 (DP - Space Optimized): " + solution(3, 7));  // Expected: 28

        // Test case 2
        System.out.println("Test 2 (DP - Space Optimized): " + solution(3, 2));  // Expected: 3

        // Test case 3
        System.out.println("Test 3 (DP - Space Optimized): " + solution(3, 3));  // Expected: 6

        // Test case 4
        System.out.println("Test 4 (DP - Space Optimized): " + solution(1, 1));  // Expected: 1

        // Alternative solution (2D DP) tests
        System.out.println("\nAlternative Solution (2D DP) Tests:");
        System.out.println("Test 1: " + alternativeSolution(3, 7));  // Expected: 28
        System.out.println("Test 2: " + alternativeSolution(3, 2));  // Expected: 3
    }

    /**
     * Space-optimized Dynamic Programming approach.
     * Use only one row to store the counts since we only need the previous row.
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     *
     * @param m number of rows
     * @param n number of columns
     * @return number of unique paths
     */
    public static int solution(int m, int n) {
        // dp[j] represents number of paths to reach cell in current row at column j
        int[] dp = new int[n];

        // Initialize with 1s since there's only one way to reach any cell in first row
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // Process remaining rows
        for (int i = 1; i < m; i++) {
            // First column always has 1 way (all down moves)
            // Update other columns: paths = paths from top + paths from left
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];  // dp[j] = top + left
            }
        }

        return dp[n - 1];
    }

    /**
     * Standard 2D Dynamic Programming approach.
     * dp[i][j] = number of unique paths to reach cell (i, j)
     * Transition: dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * @param m number of rows
     * @param n number of columns
     * @return number of unique paths
     */
    public static int alternativeSolution(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize first row and first column with 1s
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
