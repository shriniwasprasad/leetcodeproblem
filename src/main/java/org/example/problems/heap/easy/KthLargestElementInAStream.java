package org.example.problems.heap.easy;

import java.util.*;

/**
 * Problem: Kth Largest Element in a Stream (LeetCode 703)
 * Topic: Heap / Priority Queue, Design
 * Level: Easy
 *
 * Problem Description:
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Implement KthLargest class:
 * - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * - int add(int val) Appends the integer val to the stream and returns the element representing
 *   the kth largest element in the stream.
 *
 * Example:
 * Input:
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output:
 * [null, 4, 5, 5, 8, 8]
 *
 * LeetCode Problem Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInAStream {

    public static void main(String[] args) {
        // Test case from LeetCode
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println("add(3): " + kthLargest.add(3));   // return 4
        System.out.println("add(5): " + kthLargest.add(5));   // return 5
        System.out.println("add(10): " + kthLargest.add(10)); // return 5
        System.out.println("add(9): " + kthLargest.add(9));   // return 8
        System.out.println("add(4): " + kthLargest.add(4));   // return 8
    }

    /**
     * Inner class representing the KthLargest data structure.
     * Uses a min-heap to maintain the k largest elements seen so far.
     * The smallest element in the heap (the root) is the kth largest overall.
     */
    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        /**
         * Constructor to initialize the KthLargest object.
         * @param k the rank of the largest element to track
         * @param nums initial stream of numbers
         */
        public KthLargest(int k, int[] nums) {
            this.k = k;
            // Min-heap to store the k largest elements
            minHeap = new PriorityQueue<>();

            // Add initial elements
            for (int num : nums) {
                add(num);
            }
        }

        /**
         * Add a value to the stream and return the kth largest element.
         * Time Complexity: O(log k) for heap operations
         * @param val the value to add
         * @return the kth largest element in the stream
         */
        public int add(int val) {
            // Add the new value
            minHeap.offer(val);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // The root of min-heap is the kth largest element
            return minHeap.peek();
        }
    }

    /**
     * Alternative implementation using a max-heap with size tracking.
     * Stores all elements and iterates to find kth largest.
     * Less efficient but demonstrates different approach.
     */
    static class KthLargestAlternative {
        private List<Integer> elements;
        private int k;

        public KthLargestAlternative(int k, int[] nums) {
            this.k = k;
            this.elements = new ArrayList<>();
            for (int num : nums) {
                elements.add(num);
            }
            Collections.sort(elements, Collections.reverseOrder());
        }

        public int add(int val) {
            elements.add(val);
            Collections.sort(elements, Collections.reverseOrder());
            return elements.get(k - 1);
        }
    }
}
