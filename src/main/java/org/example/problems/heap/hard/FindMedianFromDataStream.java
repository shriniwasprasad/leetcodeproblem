package org.example.problems.heap.hard;

import java.util.*;

/**
 * Problem: Find Median from Data Stream
 * Topic: Heap
 * Level: Hard
 *
 * Problem Description:
 * The median is the middle value in an ordered list. MedianFinder
 * adds a number and returns the median of all numbers seen so far.
 *
 * Input: addNum(1), addNum(2), findMedian(), addNum(3), findMedian()
 * Output: 1.5, 2.0
 *
 * Video Explanation: https://www.youtube.com/watch?v=IKpM6Q8wTIY
 * LeetCode Problem Link: https://leetcode.com/problems/find-median-from-data-stream/
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median after 1, 2: " + mf.findMedian());
        mf.addNum(3);
        System.out.println("Median after 1, 2, 3: " + mf.findMedian());
    }

    // Two heaps approach: O(log n) time for add, O(1) for findMedian
    // Key insight: maxHeap for lower half, minHeap for upper half
    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap; // Lower half (max at top)
        private PriorityQueue<Integer> minHeap;  // Upper half (min at top)

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            // Balance: move max from maxHeap to minHeap
            minHeap.offer(maxHeap.poll());

            // If minHeap has more elements, move one to maxHeap
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }

    // Alternative: Same two-heap approach
    public static double alternativeSolution(int[] stream) {
        MedianFinder mf = new MedianFinder();
        for (int num : stream) {
            mf.addNum(num);
        }
        return mf.findMedian();
    }
}