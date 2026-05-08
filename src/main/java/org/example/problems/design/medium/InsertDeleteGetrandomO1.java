package org.example.problems.design.medium;

import java.util.*;

/**
 * Problem: Insert Delete GetRandom O(1) (LeetCode 380)
 * Topic: Design, Hash Table, Array
 * Level: Medium
 *
 * Problem Description:
 * Implement the RandomizedSet class:
 * - RandomizedSet() Initializes the RandomizedSet object.
 * - bool insert(int val) Inserts an item val into the set if not present.
 *   Returns true if the item was not present, false otherwise.
 * - bool remove(int val) Removes an item val from the set if present.
 *   Returns true if the item was present, false otherwise.
 * - int getRandom() Returns a random element from the current set of elements.
 *   Each element must have the same probability of being returned.
 *
 * All functions must work in average O(1) time complexity.
 *
 * Example:
 * Input:
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output:
 * [null, true, false, true, 2, true, false, 2]
 *
 * LeetCode Problem Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetrandomO1 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println("insert(1): " + randomizedSet.insert(1));        // true (1 was not present)
        System.out.println("remove(2): " + randomizedSet.remove(2));        // false (2 was not present)
        System.out.println("insert(2): " + randomizedSet.insert(2));        // true (2 was not present)
        System.out.println("getRandom(): " + randomizedSet.getRandom());    // 1 or 2
        System.out.println("remove(1): " + randomizedSet.remove(1));        // true (1 was present)
        System.out.println("insert(2): " + randomizedSet.insert(2));        // false (2 already present)
        System.out.println("getRandom(): " + randomizedSet.getRandom());    // 2 (only 2 in set)
    }

    /**
     * RandomizedSet class with O(1) operations.
     * Uses ArrayList for O(1) random access and HashMap for O(1) lookup.
     */
    static class RandomizedSet {
        private List<Integer> nums;
        private Map<Integer, Integer> valToIndex;
        private Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts an item if not present.
         * Time Complexity: O(1) amortized
         * @param val the value to insert
         * @return true if inserted, false if already present
         */
        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }

            // Add to end of list and record its index
            valToIndex.put(val, nums.size());
            nums.add(val);

            return true;
        }

        /**
         * Removes an item if present.
         * Swaps with last element for O(1) removal.
         * Time Complexity: O(1)
         * @param val the value to remove
         * @return true if removed, false if not present
         */
        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }

            int index = valToIndex.get(val);
            int lastVal = nums.get(nums.size() - 1);

            // Move last element to the position of element to remove
            nums.set(index, lastVal);
            valToIndex.put(lastVal, index);

            // Remove last element
            nums.remove(nums.size() - 1);
            valToIndex.remove(val);

            return true;
        }

        /**
         * Gets a random element from the set.
         * Time Complexity: O(1)
         * @return a random element
         */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
