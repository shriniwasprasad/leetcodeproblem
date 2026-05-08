package string.medium;

import java.util.*;

/**
 * Problem: Longest Palindromic Substring
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * Given a string s, return the longest palindromic substring in s.
 * A string is palindromic if it reads the same forward and backward.
 *
 * Hint: Expand around each possible center (both single characters and gaps between characters) to find the longest palindrome.
 *
 * Example 1:
 * Input: s = "babad"
 * Expected Output: "bab" or "aba"
 *
 * Example 2:
 * Input: s = "cbbd"
 * Expected Output: "bb"
 *
 * Example 3:
 * Input: s = "a"
 * Expected Output: "a"
 *
 * Constraints:
 * - 1 <= s.length() <= 1000
 * - s consist of only digits and English letters
 *
 * Video Explanation: https://www.youtube.com/watch?v=92KOT17h8zw
 * LeetCode Problem Link: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println("=== LongestPalindromicSubstring ===");
        
        // Test cases
        System.out.println("Test 1: " + solution("babad")); // "bab" or "aba"
        System.out.println("Test 2: " + solution("cbbd")); // "bb"
        System.out.println("Test 3: " + solution("a")); // "a"
        System.out.println("Test 4: " + solution("ac")); // "a" or "c"
        System.out.println("Test 5: " + solution("racecar")); // "racecar"
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: " + alternativeSolution("babad")); // "bab" or "aba"
        System.out.println("Test 2: " + alternativeSolution("cbbd")); // "bb"
    }

    /**
     * Solution 1: Expand Around Centers (Most Efficient)
     * 
     * Time Complexity: O(n^2) where n is the length of the string
     * Space Complexity: O(1) excluding the output
     * 
     * Algorithm:
     * - A palindrome mirrors around its center
     * - For each possible center, expand outward while characters match
     * - There are 2n-1 possible centers:
     *   - n centers at each character (odd-length palindromes)
     *   - n-1 centers between characters (even-length palindromes)
     * - Keep track of the longest palindrome found
     * 
     * How it works with "babad":
     * 1. Check centers: b, ba, a, ab, b, ba, a, ab, d
     * 2. Center at index 0 ('b'): "b" is palindrome, len=1
     * 3. Center between 0,1: no palindrome
     * 4. Center at index 1 ('a'): expand -> "bab" is palindrome, len=3 (new max)
     * 5. Center between 1,2: no palindrome
     * 6. Center at index 2 ('b'): "aba" is palindrome, len=3 (tie)
     * 7. ... continue for remaining
     * Result: "bab" (or "aba" - both have length 3)
     */
    public static Object solution(Object input) {
        String s = (String) input;
        if (s == null || s.length() == 0) return "";
        
        int start = 0;
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (center is a character)
            int len1 = expandAroundCenter(s, i, i);
            
            // Check for even-length palindromes (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the longer palindrome
            int len = Math.max(len1, len2);
            
            // Update result if we found a longer palindrome
            if (len > maxLen) {
                maxLen = len;
                // Calculate the start index of the palindrome
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        // Expand while characters match and we're within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }

    /**
     * Solution 2: Dynamic Programming Approach
     * 
     * Time Complexity: O(n^2) where n is the length of the string
     * Space Complexity: O(n^2) for the DP table
     * 
     * Algorithm:
     * - Use a 2D DP table where dp[i][j] indicates if s[i..j] is a palindrome
     * - Build the table by checking substrings of increasing length
     * - A substring s[i..j] is palindrome if:
     *   - s[i] == s[j] AND (length <= 2 OR s[i+1..j-1] is palindrome)
     * 
     * How it works with "babad":
     * DP table (T=True, F=False):
     *        b  a  b  a  d
     *     b [T, F, T, F, F]
     *     a [_, T, F, T, F]
     *     b [_, _, T, F, F]
     *     a [_, _, _, T, F]
     *     d [_, _, _, _, T]
     * 
     * Result: "bab" has dp[0][2]=T (longest)
     */
    public static Object alternativeSolution(Object input) {
        String s = (String) input;
        if (s == null || s.length() == 0) return "";
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int start = 0;
        int maxLen = 1; // At least one character is always a palindrome
        
        // Single character palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check for palindromes of length 2+
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    // If length is 2, it's a palindrome
                    // Otherwise, check if inner substring is palindrome
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}
