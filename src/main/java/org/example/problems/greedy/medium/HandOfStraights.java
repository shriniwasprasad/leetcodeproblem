package org.example.problems.greedy.medium;

import java.util.*;

/**
 * Problem: Hand of Straights (LeetCode 846)
 * Topic: Greedy, Hash Map, Sorting
 * Level: Medium
 *
 * Problem Description:
 * Alice has some number of cards and she wants to rearrange the cards into groups so that
 * each group is of size groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the ith card and
 * an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 *
 * Example 1:
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 *
 * Example 2:
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 *
 * Video Explanation: https://www.youtube.com/watch?v=ISHUyNJVq_M
 * LeetCode Problem Link: https://leetcode.com/problems/hand-of-straights/
 */
public class HandOfStraights {

    public static void main(String[] args) {
        // Test case 1
        int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println("Test 1 (TreeMap): " + solution(hand1, 3));  // Expected: true

        // Test case 2
        int[] hand2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2 (TreeMap): " + solution(hand2, 4));  // Expected: false

        // Test case 3
        int[] hand3 = {1, 1, 2, 2, 3, 3};
        System.out.println("Test 3 (TreeMap): " + solution(hand3, 2));  // Expected: true

        // Test case 4
        int[] hand4 = {1};
        System.out.println("Test 4 (TreeMap): " + solution(hand4, 1));  // Expected: true

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        System.out.println("Test 1: " + alternativeSolution(hand1, 3));  // Expected: true
        System.out.println("Test 2: " + alternativeSolution(hand2, 4));  // Expected: false
    }

    /**
     * TreeMap approach - process cards in sorted order.
     * Use TreeMap to maintain sorted order and count of each card.
     * Time Complexity: O(n log n) for TreeMap operations
     * Space Complexity: O(n) for the TreeMap
     *
     * @param hand array of card values
     * @param groupSize the size of each group
     * @return true if cards can be rearranged into groups, false otherwise
     */
    public static boolean solution(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0) {
            return true;
        }

        // Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count frequency of each card using TreeMap (sorted by key)
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Process cards in sorted order
        while (!countMap.isEmpty()) {
            // Get the smallest card
            int firstCard = countMap.firstKey();

            // Try to form a group starting from firstCard
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!countMap.containsKey(currentCard)) {
                    return false;  // Cannot form consecutive sequence
                }

                // Decrease count or remove the card
                int count = countMap.get(currentCard);
                if (count == 1) {
                    countMap.remove(currentCard);
                } else {
                    countMap.put(currentCard, count - 1);
                }
            }
        }

        return true;
    }

    /**
     * Sorting approach - sort the array and process greedily.
     * Time Complexity: O(n log n) for sorting
     * Space Complexity: O(n) for the HashMap
     *
     * @param hand array of card values
     * @param groupSize the size of each group
     * @return true if cards can be rearranged, false otherwise
     */
    public static boolean alternativeSolution(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0) {
            return true;
        }

        if (hand.length % groupSize != 0) {
            return false;
        }

        // Sort the hand
        Arrays.sort(hand);

        // Count frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Process each card in sorted order
        for (int card : hand) {
            // Skip if this card has already been used
            if (countMap.get(card) == 0) {
                continue;
            }

            // Try to form a group starting from this card
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (!countMap.containsKey(currentCard) || countMap.get(currentCard) == 0) {
                    return false;
                }
                countMap.put(currentCard, countMap.get(currentCard) - 1);
            }
        }

        return true;
    }
}
