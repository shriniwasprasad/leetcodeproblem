package org.example.problems.matrix.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Problem: Detect Squares
 * Topic: Math & Geometry
 * Level: Medium
 *
 * Problem Description:
 * You are given a stream of points on the X-Y plane. Design an algorithm that:
 * - Adds new points from the stream into a data structure.
 * - Counts the number of ways to choose three points from the data structure such that
 *   the three points and the new point form an axis-aligned square with positive area.
 *
 * Input: ["DetectSquares", "add", "add", "add", "count", "add", "count"]
 * Output: [null, null, null, null, 1, null, 0]
 *
 * Video Explanation: https://www.youtube.com/watch?v=1UooPSAHjfw
 * LeetCode Problem Link: https://leetcode.com/problems/detect-squares/
 */
public class DetectSquares {

    @SuppressWarnings("FieldMayBeFinal")
    private Map<String, Integer> pointCount;
    @SuppressWarnings("FieldMayBeFinal")
    private List<int[]> points;

    public DetectSquares() {
        this.pointCount = new HashMap<>();
        this.points = new ArrayList<>();
    }

    /**
     * Add a point to the data structure
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        pointCount.put(key, pointCount.getOrDefault(key, 0) + 1);
        points.add(point);
    }

    /**
     * Count the number of squares that can be formed with the given point
     * Time Complexity: O(n) where n is the number of points
     * Space Complexity: O(1)
     */
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;

        // Iterate through all points to find potential diagonal corners
        for (int[] p : points) {
            int x3 = p[0];
            int y3 = p[1];

            // Skip if the point is the same or doesn't form a diagonal
            if (x1 == x3 || y1 == y3) {
                continue;
            }

            // Check if the other two corners exist
            int x2 = x1;
            int y2 = y3;
            int x4 = x3;
            int y4 = y1;

            // Count the number of squares
            totalSquares += pointCount.getOrDefault(x2 + "," + y2, 0) *
                          pointCount.getOrDefault(x4 + "," + y4, 0) *
                          pointCount.getOrDefault(x3 + "," + y3, 0);
        }

        return totalSquares;
    }

    /**
     * Alternative solution using Stream API
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int alternativeCount(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        // Use Stream API to count squares
        return points.stream()
                .filter(p -> p[0] != x1 && p[1] != y1) // Filter out same row/column
                .mapToInt(p -> {
                    int x3 = p[0];
                    int y3 = p[1];

                    // Calculate other two corners
                    int x2 = x1;
                    int y2 = y3;
                    int x4 = x3;
                    int y4 = y1;

                    // Count squares using Stream API
                    return pointCount.getOrDefault(x2 + "," + y2, 0) *
                           pointCount.getOrDefault(x4 + "," + y4, 0) *
                           pointCount.getOrDefault(x3 + "," + y3, 0);
                })
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("=== DetectSquares ===");

        DetectSquares detectSquares = new DetectSquares();

        // Test case 1
        System.out.println("Test Case 1:");
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println("Count for point [11, 10]: " + detectSquares.count(new int[]{11, 10}));
        System.out.println();

        // Test case 2
        DetectSquares detectSquares2 = new DetectSquares();
        System.out.println("Test Case 2:");
        detectSquares2.add(new int[]{1, 1});
        detectSquares2.add(new int[]{2, 2});
        detectSquares2.add(new int[]{1, 2});
        System.out.println("Count for point [2, 1]: " + detectSquares2.count(new int[]{2, 1}));
        System.out.println();

        // Test case 3 - Stream API version
        DetectSquares detectSquares3 = new DetectSquares();
        System.out.println("Test Case 3 (Stream API):");
        detectSquares3.add(new int[]{3, 10});
        detectSquares3.add(new int[]{11, 2});
        detectSquares3.add(new int[]{3, 2});
        System.out.println("Count for point [11, 10]: " + detectSquares3.alternativeCount(new int[]{11, 10}));
    }
}
