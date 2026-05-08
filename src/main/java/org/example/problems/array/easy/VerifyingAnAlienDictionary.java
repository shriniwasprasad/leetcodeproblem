package org.example.problems.array.easy;

import java.util.*;

/**
 * Problem: Verifying an Alien Dictionary
 * Topic: Array
 * Level: Easy
 * <p>
 * Problem Description:
 * Given an array of strings `words` and a string `order`, return true if the strings are sorted
 * lexicographically according to the custom ordering defined by `order`.
 * <p>
 * Input: words = ["hello","leetcode"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: boolean = true (because "hello" < "leetcode" in the given alphabet)
 * <p>
 * Video Explanation: <a href="https://www.youtube.com/watch?v=8NoyVvm1v88">...</a>
 * LeetCode Problem Link: <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">...</a>
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Input: words = [\"hello\", \"leetcode\"], order = \"" + order + "\"");
        System.out.println("Output: " + solution(words, order));
    }

    // Array-based order mapping: O(n * m) time, O(1) space
    // Build lookup table for character order, then compare adjacent words
    public static boolean solution(String[] words, String order) {
        // Create mapping: character -> its position in custom order
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        // Check each adjacent pair of words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isInOrder(words[i], words[i + 1], index)) {
                return false;
            }
        }
        return true;
    }

    // Compare two strings character by character using custom order
    private static boolean isInOrder(String s1, String s2, int[] index) {
        int minLen = Math.min(s1.length(), s2.length());

        // Compare characters one by one
        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                // Return true if first differing character comes first in order
                return index[c1 - 'a'] < index[c2 - 'a'];
            }
        }
        // All compared characters equal: shorter word comes first
        return s1.length() <= s2.length();
    }

    // Alternative: HashMap-based order mapping - same logic, different data structure
    public static boolean alternativeSolution(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isInOrderAlt(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInOrderAlt(String s1, String s2, Map<Character, Integer> orderMap) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return orderMap.get(c1) < orderMap.get(c2);
            }
        }
        return s1.length() <= s2.length();
    }
}