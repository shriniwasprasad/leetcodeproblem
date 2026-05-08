package string.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Longest Common Prefix
 * Topic: String
 * Level: Easy
 *
 * Problem Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Hint: You can either compare strings one by one (horizontal scanning) or compare the first character of all strings, then the second, and so on (vertical scanning).
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Expected Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Expected Output: ""
 *
 * Example 3:
 * Input: strs = ["flower"]
 * Expected Output: "flower"
 *
 * Constraints:
 * - 1 <= strs.length() <= 200
 * - 0 <= strs[i].length() <= 200
 * - strs[i] consists of only lowercase English letters
 *
 * Video Explanation: https://www.youtube.com/watch?v=PWoIZxcamsQ
 * LeetCode Problem Link: https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("=== LongestCommonPrefix ===");
        
        // Test cases
        System.out.println("Test 1: '" + solution(new String[]{"flower","flow","flight"}) + "'"); // "fl"
        System.out.println("Test 2: '" + solution(new String[]{"dog","racecar","car"}) + "'"); // ""
        System.out.println("Test 3: '" + solution(new String[]{"flower"}) + "'"); // "flower"
        System.out.println("Test 4: '" + solution(new String[]{"a","a","a"}) + "'"); // "a"
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: '" + alternativeSolution(new String[]{"flower","flow","flight"}) + "'"); // "fl"
        System.out.println("Test 2: '" + alternativeSolution(new String[]{"dog","racecar","car"}) + "'"); // ""
    }

    /**
     * Solution 1: Horizontal Scanning (Most Intuitive)
     * 
     * Time Complexity: O(n * m) where n is number of strings and m is length of shortest string
     * Space Complexity: O(1) excluding the output
     * 
     * Algorithm:
     * - Start with the first string as the prefix
     * - For each subsequent string, trim the prefix until it's a prefix of the current string
     * - Continue until we've found the common prefix for all strings
     * 
     * How it works:
     * 1. prefix = "flower"
     * 2. Check if "flow" starts with "flower" - NO, remove last char -> "flowe"
     * 3. Continue until "flow".startsWith("fl") = true
     * 4. prefix = "fl"
     * 5. Check if "flight" starts with "fl" - YES
     * 6. Result: "fl"
     */
    public static String solution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Start with the first string as the initial prefix
        String prefix = strs[0];
        
        // Compare with each subsequent string
        for (int i = 1; i < strs.length; i++) {
            // Keep removing characters from prefix until it matches
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, there's no common prefix
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }

    /**
     * Solution 2: Vertical Scanning with Streams (More Functional)
     * 
     * Time Complexity: O(n * m) where n is number of strings and m is length of shortest string
     * Space Complexity: O(m) for the StringBuilder
     * 
     * Algorithm:
     * - Use a reduce operation on the array of strings
     * - For each pair of strings, find their common prefix
     * - The result is the common prefix amongst all strings
     * 
     * How it works:
     * 1. Compare "flower" and "flow" -> "fl"
     * 2. Compare "fl" and "flight" -> "fl"
     * 3. Result: "fl"
     * 
     * Advantage: More functional programming style, easier to extend
     */
    public static String alternativeSolution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        return Arrays.stream(strs)
                .reduce((a, b) -> {
                    StringBuilder sb = new StringBuilder();
                    int len = Math.min(a.length(), b.length());
                    
                    // Compare characters at each position
                    for (int i = 0; i < len; i++) {
                        if (a.charAt(i) == b.charAt(i)) {
                            sb.append(a.charAt(i));
                        } else {
                            break; // Stop at first difference
                        }
                    }
                    return sb.toString();
                })
                .orElse("");
    }
}
