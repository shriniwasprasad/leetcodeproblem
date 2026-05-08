package org.example.problems.array.hard;


/**
 * Problem: Trapping Rain Water
 * Topic: Array
 * Level: Hard
 * <p>
 * Problem Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Input: int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 * Output: int = 6
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=AFl_VxaO_F0">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/trapping-rain-water/">...</a>
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Input: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]");
        System.out.println("Output: " + solution(height));
    }

    // Two-pointer approach: O(n) time, O(1) space
    // Key insight: Water at position = min(maxLeft, maxRight) - height[i]
    // Move pointer from side with smaller max height
    public static int solution(int[] height) {
        int left = 0;                    // Left pointer
        int right = height.length - 1;   // Right pointer
        int leftMax = 0;                 // Max height seen from left
        int rightMax = 0;                // Max height seen from right
        int water = 0;                   // Total water trapped

        while (left < right) {
            if (height[left] < height[right]) {
                // Left side is limiting, analyze from left
                if (height[left] >= leftMax) {
                    // Current bar is new maximum, no water can be trapped
                    leftMax = height[left];
                } else {
                    // Water trapped = max height seen - current height
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Right side is limiting, analyze from right
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    // Alternative: Precomputed leftMax and rightMax arrays
    // For each position, water = min(leftMax[i], rightMax[i]) - height[i]
    public static int alternativeSolution(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax: maximum height from left up to each position
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax: maximum height from right up to each position
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate water trapped at each position
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}