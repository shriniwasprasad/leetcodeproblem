package org.example.problems.string.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Is Subsequence
 * Topic: String / Two Pointers
 * Level: Easy
 *
 * Problem Description:
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters.
 *
 * Hint: Use two pointers, one for each string. Advance the pointer for t always, and advance the pointer for s only when characters match.
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Expected Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Expected Output: false
 *
 * Example 3:
 * Input: s = "ace", t = "abcde"
 * Expected Output: true
 *
 * Example 4:
 * Input: s = "aec", t = "abcde"
 * Expected Output: false
 *
 * Example 5:
 * Input: s = "", t = "abc"
 * Expected Output: true
 *
 * Constraints:
 * - 0 <= s.length() <= 100
 * - 0 <= t.length() <= 10^4
 * - s and t consist only of lowercase English letters
 *
 * Video Explanation: https://www.youtube.com/watch?v=I1yvLEkI6oo
 * LeetCode Problem Link: https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println("=== IsSubsequence ===\n");
        
        // Test case 1: Simple subsequence
        System.out.println("Test 1: s=\"abc\", t=\"ahbgdc\"");
        System.out.println("Result: " + solution("abc", "ahbgdc")); // true
        System.out.println("Expected: true\n");
        
        // Test case 2: Not a subsequence
        System.out.println("Test 2: s=\"axc\", t=\"ahbgdc\"");
        System.out.println("Result: " + solution("axc", "ahbgdc")); // false
        System.out.println("Expected: false\n");
        
        // Test case 3: Subsequence in longer string
        System.out.println("Test 3: s=\"ace\", t=\"abcde\"");
        System.out.println("Result: " + solution("ace", "abcde")); // true
        System.out.println("Expected: true\n");
        
        // Test case 4: Wrong order
        System.out.println("Test 4: s=\"aec\", t=\"abcde\"");
        System.out.println("Result: " + solution("aec", "abcde")); // false
        System.out.println("Expected: false\n");
        
        // Test case 5: Empty s
        System.out.println("Test 5: s=\"\", t=\"abc\"");
        System.out.println("Result: " + solution("", "abc")); // true
        System.out.println("Expected: true\n");
        
        // Test case 6: s equals t
        System.out.println("Test 6: s=\"abc\", t=\"abc\"");
        System.out.println("Result: " + solution("abc", "abc")); // true
        System.out.println("Expected: true\n");
        
        System.out.println("=== Alternative Solution (Stream API) ===\n");
        
        // Alternative solution tests
        System.out.println("Alt Test 1: s=\"abc\", t=\"ahbgdc\"");
        System.out.println("Result: " + alternativeSolution("abc", "ahbgdc")); // true
        System.out.println("Expected: true\n");
        
        System.out.println("Alt Test 2: s=\"axc\", t=\"ahbgdc\"");
        System.out.println("Result: " + alternativeSolution("axc", "ahbgdc")); // false
        System.out.println("Expected: false\n");
    }

    /**
     * Solution 1: Two-Pointer Approach
     * 
     * Time Complexity: O(n) where n is the length of t
     * Space Complexity: O(1) - only using pointers
     * 
     * Algorithm:
     * - Use two pointers: one for string s (sPointer) and one for string t (tPointer)
     * - Iterate through t using tPointer
     * - When we find a character that matches s[sPointer], increment sPointer
     * - If sPointer reaches end of s, s is a subsequence of t
     * - If tPointer reaches end of t and sPointer hasn't reached end of s, return false
     * 
     * Key Insight:
     * - We don't need to backtrack or use recursion
     * - The order must be preserved in t
     * - We're trying to "match" characters of s sequentially in t
     * 
     * Example: s="abc", t="ahbgdc"
     * - sPointer=0 ('a'), tPointer=0 ('a'): MATCH → sPointer=1
     * - sPointer=1 ('b'), tPointer=1-2 ('h','b'): MATCH at 'b' → sPointer=2
     * - sPointer=2 ('c'), tPointer=3-5 ('g','d','c'): MATCH at 'c' → sPointer=3
     * - sPointer=3 (end of s) → return true
     */
    public static boolean solution(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        
        // Try to match each character of s in t sequentially
        while (tPointer < t.length() && sPointer < s.length()) {
            // If characters match, move s pointer forward
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            // Always move t pointer forward
            tPointer++;
        }
        
        // If s pointer reached end, we matched all of s
        return sPointer == s.length();
    }

    /**
     * Solution 2: Stream API Approach
     * 
     * Time Complexity: O(n) where n is the length of t
     * Space Complexity: O(1) - only using a counter
     * 
     * Algorithm:
     * - Use a holder (array) to track position in s (because we need mutable counter in lambda)
     * - Convert t to stream of characters
     * - For each character in t:
     *   - If sPointer hasn't reached end of s
     *   - And current character matches s[sPointer]
     *   - Increment sPointer
     * - After stream process, check if sPointer equals s.length()
     * 
     * Advantages:
     * - Functional programming style
     * - More declarative approach
     * - Easier to chain with other stream operations
     * 
     * Trade-offs:
     * - Slightly more overhead from stream operations
     * - Needs a holder array for mutable counter (Java streams don't allow mutable access)
     * 
     * Example: s="abc", t="ahbgdc"
     * - Stream processes 'a': matches s[0]='a' → sPointer[0]=1
     * - Stream processes 'h': no match → sPointer[0]=1
     * - Stream processes 'b': matches s[1]='b' → sPointer[0]=2
     * - Stream processes 'g': no match → sPointer[0]=2
     * - Stream processes 'd': no match → sPointer[0]=2
     * - Stream processes 'c': matches s[2]='c' → sPointer[0]=3
     * - Final check: sPointer[0]==3 (s.length) → return true
     */
    public static boolean alternativeSolution(String s, String t) {
        if (s.isEmpty()) {
            return true;  // Empty string is subsequence of any string
        }
        
        // Use array to hold mutable counter (lambda can't modify local variables)
        int[] sPointer = {0};
        
        // Process each character in t using streams
        t.chars()
                .mapToObj(c -> (char) c)
                .forEach(tChar -> {
                    // If we haven't matched entire s and current char matches
                    if (sPointer[0] < s.length() && s.charAt(sPointer[0]) == tChar) {
                        sPointer[0]++;
                    }
                });
        
        // Check if we've matched all characters in s
        return sPointer[0] == s.length();
    }
}
