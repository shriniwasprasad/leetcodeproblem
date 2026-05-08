package string.hard;

import java.util.*;

/**
 * Problem: Minimum Window Substring
 * Topic: String
 * Level: Hard
 *
 * Problem Description:
 * Given two strings s and t of characters, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return an empty string "".
 *
 * Note: If there are duplicate characters in t, then every occurrence of that character in t is to be counted.
 *
 * Hint: Use a sliding window. Expand the right pointer until the window contains all required characters, then contract from the left as much as possible.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Expected Output: "BANC"
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Expected Output: "a"
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Expected Output: ""
 *
 * Example 4:
 * Input: s = "ab", t = "b"
 * Expected Output: "b"
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 10^5
 * - s and t consist of English letters (uppercase and lowercase)
 * - It is guaranteed that the answer exists. If not, return ""
 *
 * Video Explanation: https://www.youtube.com/watch?v=tMx5JZSBWIE
 * LeetCode Problem Link: https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println("=== MinimumWindowSubstring ===");
        
        // Test case 1: "ADOBECODEBANC", "ABC" -> "BANC"
        System.out.println("Test 1: '" + solution("ADOBECODEBANC", "ABC") + "'"); // "BANC"
        
        // Test case 2: "a", "a" -> "a"
        System.out.println("Test 2: '" + solution("a", "a") + "'"); // "a"
        
        // Test case 3: "a", "aa" -> ""
        System.out.println("Test 3: '" + solution("a", "aa") + "'"); // ""
        
        // Test case 4: "ab", "b" -> "b"
        System.out.println("Test 4: '" + solution("ab", "b") + "'"); // "b"
        
        // Test case 5: "bba", "ab" -> "bba"
        System.out.println("Test 5: '" + solution("bba", "ab") + "'"); // "bba"
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: '" + alternativeSolution("ADOBECODEBANC", "ABC") + "'"); // "BANC"
        System.out.println("Test 2: '" + alternativeSolution("a", "a") + "'"); // "a"
    }

    /**
     * Solution 1: Sliding Window with HashMap (Clear and General)
     * 
     * Time Complexity: O(|s| + |t|) where |s| is length of s and |t| is length of t
     * Space Complexity: O(|t|) for the map storing character frequencies
     * 
     * Algorithm:
     * - Create a map to store required character frequencies from t
     * - Use sliding window with two pointers (left and right)
     * - Expand window by moving right pointer and track characters
     * - When window contains all characters from t, try to contract from left
     * - Keep track of minimum window found
     * 
     * How it works with s="ADOBECODEBANC", t="ABC":
     * Required: {A:1, B:1, C:1}
     * 
     * 1. Expand right until all chars found:
     *    "ADOBEC" - contains A, B, C (formed=3)
     * 2. Contract left while still contains all:
     *    "ADOBEC" -> "DOBEC" (loses A, restart)
     * 3. Continue expanding and contracting...
     * 4. Find "BANC" as minimum window
     * 
     * Key insight: Use two maps - one for required, one for window
     * Count how many character frequencies are satisfied (formed)
     */
    public static Object solution(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Step 1: Create map of required characters
        Map<Character, Integer> required = new HashMap<>();
        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Sliding window variables
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int formed = 0; // Count of unique characters with desired frequency
        
        // Window frequency map
        Map<Character, Integer> window = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // Add character to window
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // If frequency matches required, increment formed
            if (required.containsKey(c) && window.get(c).equals(required.get(c))) {
                formed++;
            }
            
            // Step 3: Contract window from left while it contains all chars
            while (left <= right && formed == required.size()) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Remove character from left
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                
                // If required character frequency decreased below required
                if (required.containsKey(leftChar) && window.get(leftChar) < required.get(leftChar)) {
                    formed--;
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /**
     * Solution 2: Optimized Sliding Window with Array (Better Performance)
     * 
     * Time Complexity: O(|s| + |t|)
     * Space Complexity: O(1) since we use fixed-size array of 128 for ASCII characters
     * 
     * Algorithm:
     * - Use arrays instead of HashMaps for character frequencies
     * - Faster than HashMap for fixed character sets
     * - Same sliding window logic as Solution 1
     * - Keep counter of how many characters have required frequency
     * 
     * How it works:
     * - required[i] = frequency of character needed
     * - window[i] = frequency of character in current window
     * - matched = count of characters where window[i] == required[i]
     * - When matched == |t|, we have all required characters
     * 
     * Pros: Faster than HashMap
     * Cons: Uses more space for array (but still O(1) constant)
     */
    public static Object alternativeSolution(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Step 1: Create character frequency arrays
        int[] required = new int[128]; // ASCII characters
        int[] window = new int[128];
        
        for (char c : t.toCharArray()) {
            required[c]++;
        }
        
        // Step 2: Count how many characters need to be matched in required
        int charToMatch = 0;
        for (int i = 0; i < 128; i++) {
            if (required[i] > 0) {
                charToMatch++;
            }
        }
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int matched = 0; // Count of characters with frequency matching required
        
        // Step 3: Sliding window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // Add character to window
            window[c]++;
            
            // If this character's frequency now matches required, increment matched
            if (required[c] > 0 && window[c] == required[c]) {
                matched++;
            }
            
            // Step 4: Contract window from left
            while (left <= right && matched == charToMatch) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Remove character from left
                char leftChar = s.charAt(left);
                if (required[leftChar] > 0 && window[leftChar] == required[leftChar]) {
                    matched--;
                }
                window[leftChar]--;
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
