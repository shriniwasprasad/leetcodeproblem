package org.example.problems.string.hard;

import java.util.*;

/**
 * Problem: Sliding Window Maximum
 * Topic: Sliding Window / Deque
 * Level: Hard
 *
 * Problem Description:
 * Given an array nums and a sliding window of size k,
 * return the maximum value in each window as it moves from left to right.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Video Explanation: https://www.youtube.com/watch?v=GIYk1wit12k
 * LeetCode Problem Link: https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println("=== SlidingWindowMaximum ===");
        System.out.println(Arrays.toString(solution(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // [3, 3, 5, 5, 6, 7]
    }

    /**
     * Solution: Monotonic decreasing deque.
     * Store indices in deque, maintain decreasing order of values.
     * Time: O(n), Space: O(k)
     */
    public static int[] solution(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    /**
     * Alternative Solution: Using PriorityQueue (max heap).
     * Time: O(n log k), Space: O(k)
     */
    public static int[] alternativeSolution(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);

            if (i >= k) {
                maxHeap.remove(nums[i - k]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek();
            }
        }
        return result;
    }

    /**
     * Alternative Solution: Stream API (inefficient).
     * Time: O(n * k), Space: O(k)
     */
    public static int[] alternativeStreamSolution(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            int windowMax = Arrays.stream(nums, i, i + k)
                    .max()
                    .getAsInt();
            result.add(windowMax);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
