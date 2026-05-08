package org.example.problems.array.medium;

/**
 * Problem: Container With Most Water
 * Topic: Array
 * Level: Medium
 *
 * Problem Description:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is (i, 0) and (i, ai).
 * Find two lines that together with the x-axis form a container that holds the most water.
 *
 * Input: int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}
 * Output: int = 49
 *
 * Video Explanation: https://www.youtube.com/watch?v=wi8fqhNoV-Y
 * LeetCode Problem Link: https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]");
        System.out.println("Output: " + solution(height));
    }

    // Two-pointer: Start with widest container (full width)
    // Key insight: Area is limited by the SHORTER line, so move the shorter one inward
    public static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Width = distance between lines, Height = minimum of two heights
            int width = right - left;
            int h = Math.min(height[left], height[right]);

            // Calculate and update maximum area
            maxArea = Math.max(maxArea, width * h);

            // Move the pointer with the SHORTER line inward
            // Because moving the taller line would only decrease area (width decreases, height can't increase)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // Alternative: Same two-pointer approach with <= instead of <
    public static int alternativeSolution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            // Move pointer with shorter or equal height
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}