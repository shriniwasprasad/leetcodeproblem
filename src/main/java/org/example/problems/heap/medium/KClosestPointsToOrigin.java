package org.example.problems.heap.medium;

import java.util.*;

/**
 * Problem: K Closest Points to Origin (LeetCode 973)
 * Topic: Heap / Priority Queue, Sorting, Divide and Conquer
 * Level: Medium
 *
 * Problem Description:
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance
 * sqrt((x1 - x2)^2 + (y1 - y2)^2).
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]] or [[-2,4],[3,3]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=RLyF_-4Izg0
 * LeetCode Problem Link: https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        // Test case 1
        int[][] points1 = {{1, 3}, {-2, 2}};
        int[][] result1 = solution(points1, 1);
        System.out.print("Test 1 - K Closest: ");
        printPoints(result1);  // Expected: [[-2, 2]]

        // Test case 2
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] result2 = solution(points2, 2);
        System.out.print("Test 2 - K Closest: ");
        printPoints(result2);  // Expected: [[3,3], [-2,4]] (in any order)

        // Test case 3
        int[][] points3 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};
        int[][] result3 = solution(points3, 3);
        System.out.print("Test 3 - K Closest: ");
        printPoints(result3);  // Expected: [[1,1], [2,2], [3,3]]

        // Alternative solution tests (Quick Select)
        System.out.println("\nAlternative Solution Tests:");
        int[][] points4 = {{1, 3}, {-2, 2}};
        int[][] result4 = alternativeSolution(points4, 1);
        System.out.print("Test 1 - K Closest: ");
        printPoints(result4);
    }

    /**
     * Max-Heap approach to find k closest points.
     * Maintain a heap of size k with the k closest points seen so far.
     * Time Complexity: O(n log k) - n heap operations of O(log k) each
     * Space Complexity: O(k) for the heap
     *
     * @param points array of points [x, y]
     * @param k number of closest points to return
     * @return k closest points to origin
     */
    public static int[][] solution(int[][] points, int k) {
        // Max-heap based on distance squared
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(distanceSquared(b), distanceSquared(a))
        );

        // Process each point
        for (int[] point : points) {
            maxHeap.offer(point);
            // If heap exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract results from heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    /**
     * Quick Select approach for optimal average time complexity.
     * Uses partitioning similar to QuickSort to find k smallest elements.
     * Time Complexity: O(n) average, O(n^2) worst case
     * Space Complexity: O(1) excluding output
     *
     * @param points array of points [x, y]
     * @param k number of closest points to return
     * @return k closest points to origin
     */
    public static int[][] alternativeSolution(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;

        while (left <= right) {
            // Partition and get pivot position
            int pivotIndex = partition(points, left, right);

            // If pivot is at k-1, we found our k closest elements
            if (pivotIndex == k - 1) {
                // Extract first k points
                int[][] result = new int[k][2];
                System.arraycopy(points, 0, result, 0, k);
                return result;
            } else if (pivotIndex < k - 1) {
                // Pivot is too small, search right partition
                left = pivotIndex + 1;
            } else {
                // Pivot is too large, search left partition
                right = pivotIndex - 1;
            }
        }

        // Should not reach here
        int[][] result = new int[k][2];
        System.arraycopy(points, 0, result, 0, k);
        return result;
    }

    /**
     * Helper method to partition array around a pivot.
     * @param points array of points
     * @param left left boundary
     * @param right right boundary
     * @return final position of pivot
     */
    private static int partition(int[][] points, int left, int right) {
        // Use rightmost element as pivot
        int pivotDistance = distanceSquared(points[right]);
        int storeIndex = left;

        // Move all elements closer than pivot to the left
        for (int i = left; i < right; i++) {
            if (distanceSquared(points[i]) < pivotDistance) {
                swap(points, i, storeIndex);
                storeIndex++;
            }
        }

        // Place pivot in its correct position
        swap(points, storeIndex, right);
        return storeIndex;
    }

    /**
     * Helper method to swap two elements in the array.
     */
    private static void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    /**
     * Calculate squared Euclidean distance from origin.
     * Using squared distance avoids expensive sqrt calculation.
     */
    private static int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /**
     * Helper method to print points array.
     */
    private static void printPoints(int[][] points) {
        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            System.out.print("[" + points[i][0] + ", " + points[i][1] + "]");
            if (i < points.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
