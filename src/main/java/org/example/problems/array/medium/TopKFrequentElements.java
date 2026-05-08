package org.example.problems.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Problem: Top K Frequent Elements
 * Topic: Arrays & Hashing
 * Level: Medium
 *
 * Problem Description:
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Input: int[] nums = {1, 1, 1, 2, 2, 3}; int k = 2
 * Output: int[] = {1, 2}
 *
 * Video Explanation: https://www.youtube.com/watch?v=QubWUx59QCk
 * LeetCode Problem Link: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println("=== TopKFrequentElements ===");

        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Input: nums=" + Arrays.toString(nums1) + ", k=" + k1);
        System.out.println("Output: " + Arrays.toString(solution(nums1, k1)));
        System.out.println();

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Input: nums=" + Arrays.toString(nums2) + ", k=" + k2);
        System.out.println("Output: " + Arrays.toString(solution(nums2, k2)));
    }

    /**
     * Solution: Bucket Sort with Frequency
     * ----------------------------------------
     * Step-by-step explanation:
     *
     * 1. First, count frequency of each element using HashMap
     * 2. Create a bucket array where index = frequency, value = list of elements
     *    - Maximum frequency possible is n (array length)
     * 3. Iterate bucket from end (highest frequency) to find top k elements
     *
     * Time Complexity: O(n) - counting O(n), bucketing O(n), collecting O(k)
     * Space Complexity: O(n) - for frequency map and buckets
     */
    public static int[] solution(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets - index is frequency, value is list of numbers
        int n = nums.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = (List<Integer>[]) new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            buckets[freq].add(entry.getKey());
        }

        // Step 3: Collect top k from buckets (highest frequency first)
        List<Integer> result = new ArrayList<>();
        for (int freq = n; freq > 0 && result.size() < k; freq--) {
            for (int num : buckets[freq]) {
                result.add(num);
                if (result.size() == k) break;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Alternative Solution: Priority Queue (Min-Heap)
     * ----------------------------------------
     * Maintain a min-heap of size k with most frequent elements.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(n) for frequency map
     */
    public static int[] alternativeSolution(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use Priority Queue to get k most frequent
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract results
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(minHeap.poll()).getKey();
        }

        return result;
    }
}
