package org.example.problems.string.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Reverse Only the Vowels of a String
 * Topic: String / Two Pointers
 * Level: Easy
 *
 * Problem Description:
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', 'u', and they can appear in both lower and upper cases.
 * More than one vowel can appear consecutively.
 *
 * Hint: Use two pointers (left and right). Move them towards each other, and when both point to vowels, swap them.
 *
 * Example 1:
 * Input: s = "hello"
 * Expected Output: "holle"
 *
 * Example 2:
 * Input: s = "aA"
 * Expected Output: "Aa"
 *
 * Example 3:
 * Input: s = "race car"
 * Expected Output: "race car"
 *
 * Example 4:
 * Input: s = "programming"
 * Expected Output: "pragrammoing"
 *
 * Constraints:
 * - 1 <= s.length() <= 3 * 10^5
 * - s consists of printable ASCII characters
 *
 * Video Explanation: https://www.youtube.com/watch?v=bjKt6xj9VgM
 * LeetCode Problem Link: https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println("=== ReverseVowelsOfAString ===\n");
        
        // Test case 1: Simple vowels
        System.out.println("Test 1: \"hello\"");
        System.out.println("Result: " + solution("hello")); // "holle"
        System.out.println("Expected: holle\n");
        
        // Test case 2: Mixed case vowels
        System.out.println("Test 2: \"aA\"");
        System.out.println("Result: " + solution("aA")); // "Aa"
        System.out.println("Expected: Aa\n");
        
        // Test case 3: Multiple same vowels
        System.out.println("Test 3: \"race car\"");
        System.out.println("Result: " + solution("race car")); // "race car"
        System.out.println("Expected: race car\n");
        
        // Test case 4: Complex example
        System.out.println("Test 4: \"programming\"");
        System.out.println("Result: " + solution("programming")); // "pragrammoing"
        System.out.println("Expected: pragrammoing\n");
        
        // Test case 5: No vowels
        System.out.println("Test 5: \"bcdfg\"");
        System.out.println("Result: " + solution("bcdfg")); // "bcdfg"
        System.out.println("Expected: bcdfg\n");
        
        System.out.println("=== Alternative Solution (Stream API) ===\n");
        
        // Alternative solution tests
        System.out.println("Alt Test 1: \"hello\"");
        System.out.println("Result: " + alternativeSolution("hello")); // "holle"
        System.out.println("Expected: holle\n");
        
        System.out.println("Alt Test 2: \"programming\"");
        System.out.println("Result: " + alternativeSolution("programming")); // "pragrammoing"
        System.out.println("Expected: pragrammoing");
    }

    /**
     * Solution 1: Two-Pointer Approach
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the character array
     * 
     * Algorithm:
     * - Convert string to character array for in-place swapping
     * - Use two pointers: left (start) and right (end)
     * - Move left pointer right until a vowel is found
     * - Move right pointer left until a vowel is found
     * - Swap the two vowels
     * - Continue until pointers meet or cross
     * - Convert array back to string
     * 
     * Key Insight:
     * - We only deal with vowels, consonants stay in their positions
     * - This is more efficient than extracting vowels to a separate list
     * 
     * Example: "hello"
     * - Positions: h(0) e(1) l(2) l(3) o(4)
     * - Vowels at: 1('e'), 4('o')
     * - After swap: h(0) o(1) l(2) l(3) e(4) = "holle"
     */
    public static String solution(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Find next vowel from left
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            
            // Find next vowel from right
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            
            // Swap the vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }

    /**
     * Solution 2: Stream API Approach
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for intermediate collections
     * 
     * Algorithm:
     * - Extract all vowels from the string in order: stream → filter → collect
     * - Reverse the list of vowels
     * - Convert string to stream of characters
     * - For each character:
     *   - If vowel: replace with next vowel from reversed list
     *   - If consonant: keep as is
     * 
     * Advantages:
     * - Functional programming style
     * - More readable and expressive
     * - Easier to understand the intent
     * 
     * Trade-offs:
     * - Slightly more overhead due to intermediate list creation
     * - Less efficient than two-pointer for large strings
     * - Better for code readability and maintainability
     * 
     * Example: "hello"
     * - Extract vowels: ['e', 'o']
     * - Reverse: ['o', 'e']
     * - Map chars: 'h', 'o' (from reversed), 'l', 'l', 'e' (from reversed)
     * - Result: "holle"
     */
    public static String alternativeSolution(String s) {
        // Step 1: Extract all vowels and reverse them
        List<Character> vowels = s.chars()
                .mapToObj(c -> (char) c)
                .filter(ReverseVowelsOfAString::isVowel)
                .collect(Collectors.toList());
        
        Collections.reverse(vowels);
        
        // Step 2: Use an iterator to track position in reversed vowels
        Iterator<Character> vowelIterator = vowels.iterator();
        
        // Step 3: Map each character:
        // - If vowel: replace with next from reversed list
        // - If consonant: keep it
        return s.chars()
                .mapToObj(c -> (char) c)
                .map(c -> isVowel(c) ? vowelIterator.next() : c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * Helper method to check if a character is a vowel
     * Vowels: a, e, i, o, u (both lowercase and uppercase)
     * 
     * @param c the character to check
     * @return true if c is a vowel, false otherwise
     */
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
