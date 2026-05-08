package string.medium;

import java.util.*;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Hint: Use a sliding window with a map to store the last seen index of each character. When a duplicate is found, move the left pointer of the window.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Expected Output: 3
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Expected Output: 1
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Expected Output: 3
 *
 * Example 4:
 * Input: s = "au"
 * Expected Output: 2
 *
 * Constraints:
 * - 0 <= s.length() <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces
 *
 * Video Explanation: https://www.youtube.com/watch?v=RMQ-gRQAY0o
 * LeetCode Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println("=== LongestSubstringWithoutRepeatingCharacters ===");
        
        // Test cases
        System.out.println("Test 1: " + solution("abcabcbb")); // 3 ("abc")
        System.out.println("Test 2: " + solution("bbbbb")); // 1 ("b")
        System.out.println("Test 3: " + solution("pwwkew")); // 3 ("wke")
        System.out.println("Test 4: " + solution("au")); // 2 ("au")
        System.out.println("Test 5: " + solution("")); // 0 (empty)
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: " + alternativeSolution("abcabcbb")); // 3
        System.out.println("Test 2: " + alternativeSolution("bbbbb")); // 1
    }

    /**
     * Solution 1: Sliding Window with HashMap (Optimal)
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(min(m, n)) where m is charset size (at most 26 for lowercase letters)
     * 
     * Algorithm:
     * - Use two pointers (left and right) for the sliding window
     * - Use a HashMap to store the most recent index of each character
     * - Expand the window by moving right pointer
     * - When we encounter a repeating character, move left pointer to skip the previous occurrence
     * - Keep track of the maximum length seen
     * 
     * How it works with "abcabcbb":
     * Initial: left = 0, right = 0, maxLen = 0
     * 1. 'a' at 0: {a:0}, len = 1, maxLen = 1
     * 2. 'b' at 1: {a:0,b:1}, len = 2, maxLen = 2
     * 3. 'c' at 2: {a:0,b:1,c:2}, len = 3, maxLen = 3
     * 4. 'a' at 3: found duplicate at 0, move left to 1, {a:3,b:1,c:2}, len = 3
     * 5. 'b' at 4: found duplicate at 1, move left to 2, {a:3,b:4,c:2}, len = 3
     * 6. 'c' at 5: found duplicate at 2, move left to 3, {a:3,b:4,c:5}, len = 3
     * 7. 'b' at 6: found duplicate at 4, move left to 5, {a:3,b:6,c:5}, len = 2
     * 8. 'b' at 7: found duplicate at 6, move left to 7, {a:3,b:7,c:5}, len = 1
     * Result: maxLen = 3
     */
    public static Object solution(Object input) {
        String s = (String) input;
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If character is already in current window
            if (charIndex.containsKey(c) && charIndex.get(c) >= left) {
                // Move left pointer to skip the previous occurrence
                left = charIndex.get(c) + 1;
            }
            
            // Update the most recent index of this character
            charIndex.put(c, right);
            
            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }

    /**
     * Solution 2: Sliding Window with Character Array (Even More Efficient)
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(m) where m is charset size (typically 256 for ASCII)
     * 
     * Algorithm:
     * - Use an array instead of HashMap for storing character indices
     * - Faster than HashMap since it's direct array access
     * - Still uses sliding window approach
     * 
     * Advantage: Faster than HashMap for fixed character sets
     * Works well with ASCII or Unicode characters
     */
    public static Object alternativeSolution(Object input) {
        String s = (String) input;
        if (s == null || s.length() == 0) return 0;
        
        // Array to store the last seen index of each character
        int[] charIndex = new int[256];
        Arrays.fill(charIndex, -1); // Initialize with -1 (not seen)
        
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If character is already in current window
            if (charIndex[c] >= left) {
                // Move left pointer to skip the previous occurrence
                left = charIndex[c] + 1;
            }
            
            // Update the most recent index of this character
            charIndex[c] = right;
            
            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
