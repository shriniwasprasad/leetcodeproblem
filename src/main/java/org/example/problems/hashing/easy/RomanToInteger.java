package org.example.problems.hashing.easy;

import java.util.*;

/**
 * Problem: Roman to Integer
 * Topic: Hashing
 * Level: Easy
 *
 * Problem Description:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D, M.
 * Given a Roman numeral, convert it to an integer.
 *
 * Input: String s = "III"
 * Output: int = 3
 *
 * Video Explanation: https://www.youtube.com/watch?v=qmkr61ySQwQ
 * LeetCode Problem Link: https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        String s = "III";
        System.out.println("Input: s = \"" + s + "\"");
        System.out.println("Output: " + solution(s));
    }

    // HashMap lookup: O(n) time, O(1) space
    // Key insight: When a smaller value appears before a larger value, subtract it
    public static int solution(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // If current value is less than next value, subtract it (e.g., IV = -1 + 5 = 4)
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                result -= roman.get(s.charAt(i));
            } else {
                result += roman.get(s.charAt(i));
            }
        }
        return result;
    }

    // Alternative: Array-based lookup for better performance
    public static int alternativeSolution(String s) {
        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = getValue(s.charAt(i));
            // If current value is less than previous, subtract it
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}