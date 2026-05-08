package org.example.problems.design.easy;

import java.util.*;

/**
 * Problem: Moving Average from Data Stream (LeetCode 346)
 * Topic: Design, Queue, Array
 * Level: Easy
 *
 * Problem Description:
 * Given a stream of integers and a window size, calculate the moving average of all
 * integers in the sliding window.
 *
 * Implement the MovingAverage class:
 * - MovingAverage(int size) Initializes the object with the size of the window.
 * - double next(int val) Returns the moving average of the last size values of the stream.
 *
 * Example:
 * Input:
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output:
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * LeetCode Problem Link: https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverageFromDataStream {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("next(1): " + movingAverage.next(1));      // 1.0 = 1 / 1
        System.out.println("next(10): " + movingAverage.next(10));    // 5.5 = (1 + 10) / 2
        System.out.println("next(3): " + movingAverage.next(3));      // 4.66667 = (1 + 10 + 3) / 3
        System.out.println("next(5): " + movingAverage.next(5));      // 6.0 = (10 + 3 + 5) / 3
    }

    /**
     * MovingAverage class using Queue (LinkedList).
     * Maintains a sliding window of the last 'size' integers.
     */
    static class MovingAverage {
        private Queue<Integer> window;
        private int size;
        private double sum;

        /**
         * Initialize with window size.
         * Time Complexity: O(1)
         * @param size the size of the sliding window
         */
        public MovingAverage(int size) {
            this.size = size;
            this.window = new LinkedList<>();
            this.sum = 0;
        }

        /**
         * Add a new value and return the moving average.
         * Time Complexity: O(1)
         * Space Complexity: O(size)
         *
         * @param val the new integer value
         * @return the moving average of the last 'size' values
         */
        public double next(int val) {
            // If window is full, remove the oldest value
            if (window.size() == size) {
                sum -= window.poll();
            }

            // Add new value
            window.offer(val);
            sum += val;

            // Calculate and return average
            return sum / window.size();
        }
    }

    /**
     * Alternative implementation using a fixed-size array (Circular Buffer).
     * More memory efficient as it avoids object overhead.
     */
    static class MovingAverageArray {
        private int[] window;
        private int size;
        private int count;  // Number of elements currently in window
        private int index;  // Current position in circular buffer
        private double sum;

        public MovingAverageArray(int size) {
            this.size = size;
            this.window = new int[size];
            this.count = 0;
            this.index = 0;
            this.sum = 0;
        }

        public double next(int val) {
            // If window is full, subtract the value that's being replaced
            if (count == size) {
                sum -= window[index];
            } else {
                count++;
            }

            // Add new value at current position
            window[index] = val;
            sum += val;

            // Move to next position (circular)
            index = (index + 1) % size;

            return sum / count;
        }
    }
}
