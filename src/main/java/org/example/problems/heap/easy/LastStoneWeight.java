package org.example.problems.heap.easy;

import java.util.*;

/**
 * Problem: Last Stone Weight (LeetCode 1046)
 * Topic: Heap / Priority Queue, Greedy
 * Level: Easy
 *
 * Problem Description:
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones
 * and smash them together. Suppose the heaviest two stones have weights x and y with x <= y.
 * The result of this smash is:
 * - If x == y, both stones are destroyed
 * - If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 *
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 *
 * Example 1:
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 *
 * Example 2:
 * Input: stones = [1]
 * Output: 1
 *
 * Video Explanation: https://www.youtube.com/watch?v=xq4RoS0vVfM
 * LeetCode Problem Link: https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        // Test case 1
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Test 1 (Max Heap): " + solution(stones1));  // Expected: 1

        // Test case 2
        int[] stones2 = {1};
        System.out.println("Test 2 (Max Heap): " + solution(stones2));  // Expected: 1

        // Test case 3
        int[] stones3 = {2, 2};
        System.out.println("Test 3 (Max Heap): " + solution(stones3));  // Expected: 0

        // Test case 4
        int[] stones4 = {3, 7, 2};
        System.out.println("Test 4 (Max Heap): " + solution(stones4));  // Expected: 2

        // Alternative solution tests (Sorting-based)
        System.out.println("\nAlternative Solution Tests:");
        int[] stones5 = {2, 7, 4, 1, 8, 1};
        System.out.println("Test 1 (Sorting): " + alternativeSolution(stones5));  // Expected: 1

        int[] stones6 = {1};
        System.out.println("Test 2 (Sorting): " + alternativeSolution(stones6));  // Expected: 1
    }

    /**
     * Max-Heap approach to simulate the stone smashing game.
     * Use a priority queue to efficiently get the two heaviest stones.
     * Time Complexity: O(n log n) - each heap operation takes O(log n), done n times
     * Space Complexity: O(n) for the priority queue
     *
     * @param stones array of stone weights
     * @return weight of the last remaining stone, or 0 if none remain
     */
    public static int solution(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        // Create max-heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Process until at most one stone remains
        while (maxHeap.size() > 1) {
            // Get two heaviest stones
            int stone1 = maxHeap.poll();  // Heaviest
            int stone2 = maxHeap.poll();  // Second heaviest

            // If they're not equal, put the difference back
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
            // If equal, both are destroyed (do nothing)
        }

        // Return remaining stone weight or 0 if none
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    /**
     * Sorting-based approach to simulate the stone smashing game.
     * Sort the array each iteration to find the two heaviest stones.
     * Time Complexity: O(n^2 log n) - sorting takes O(n log n), done up to n times
     * Space Complexity: O(1) excluding input array
     *
     * @param stones array of stone weights
     * @return weight of the last remaining stone, or 0 if none remain
     */
    public static int alternativeSolution(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        int size = stones.length;

        while (size > 1) {
            // Sort descending to get heaviest stones at the end
            Arrays.sort(stones);

            // Get two heaviest stones
            int stone1 = stones[size - 1];
            int stone2 = stones[size - 2];

            if (stone1 == stone2) {
                // Both destroyed
                size -= 2;
            } else {
                // Put difference back
                stones[size - 2] = stone1 - stone2;
                size -= 1;
            }
        }

        return size == 0 ? 0 : stones[0];
    }
}
