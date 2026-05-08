package string.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Valid Anagram
 * Topic: String
 * Level: Easy
 *
 * Problem Description:
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Hint: Since only lowercase English letters are used, a frequency array of size 26 can be used to count characters.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Expected Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Expected Output: false
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters
 *
 * Video Explanation: https://www.youtube.com/watch?v=qyQni3rz-ko
 * LeetCode Problem Link: https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println("=== ValidAnagram ===");
        
        // Test cases
        System.out.println("Test 1: " + solution("anagram", "nagaram")); // true
        System.out.println("Test 2: " + solution("rat", "car")); // false
        System.out.println("Test 3: " + solution("a", "a")); // true
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: " + alternativeSolution("anagram", "nagaram")); // true
        System.out.println("Test 2: " + alternativeSolution("rat", "car")); // false
    }

    /**
     * Solution 1: Character Count Array (Most Efficient)
     * 
     * Time Complexity: O(n) where n is the length of the strings
     * Space Complexity: O(1) - fixed size array of 26 characters (lowercase English letters)
     * 
     * Algorithm:
     * - If lengths are different, they cannot be anagrams
     * - Create an array to count frequencies of each letter (26 lowercase letters)
     * - Increment count for each character in string s
     * - Decrement count for each character in string t
     * - If any count is non-zero, strings are not anagrams
     * - If all counts are zero, strings are anagrams
     * 
     * Advantage: Most efficient with O(1) space (fixed array size)
     */
    public static boolean solution(String s, String t) {
        // Early exit if lengths differ
        if (s.length() != t.length()) return false;
        
        // Count character frequencies
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // Increment for character in s
            chars[s.charAt(i) - 'a']++;
            // Decrement for character in t
            chars[t.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for (int count : chars) {
            if (count != 0) return false;
        }
        
        return true;
    }

    /**
     * Solution 2: HashMap with Streams (More Readable)
     * 
     * Time Complexity: O(n) where n is the length of the strings
     * Space Complexity: O(k) where k is the number of unique characters (at most 26)
     * 
     * Algorithm:
     * - If lengths are different, they cannot be anagrams
     * - Count character frequencies in both strings using HashMap
     * - Compare both frequency maps for equality
     * - If maps are equal, strings are anagrams
     * 
     * Advantage: More readable and maintainable, handles Unicode better
     */
    public static boolean alternativeSolution(String s, String t) {
        // Early exit if lengths differ
        if (s.length() != t.length()) return false;
        
        // Count all characters in both strings
        Map<Character, Long> sCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        Map<Character, Long> tCount = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        // Compare the frequency maps
        return sCount.equals(tCount);
    }
}
