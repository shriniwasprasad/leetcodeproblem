package string.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Valid Palindrome
 * Topic: String
 * Level: Easy
 *
 * Problem Description:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Hint: Use two pointers, one starting at the beginning and one at the end, moving towards the middle and skipping non-alphanumeric characters.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Expected Output: true
 *
 * Example 2:
 * Input: s = "race a car"
 * Expected Output: false
 *
 * Constraints:
 * - 1 <= s.length() <= 2 * 10^5
 * - s consists of printable ASCII characters
 *
 * Video Explanation: https://www.youtube.com/watch?v=MFPmKyThyHk
 * LeetCode Problem Link: https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println("=== ValidPalindrome ===");
        
        // Test cases
        System.out.println("Test 1: " + solution("A man, a plan, a canal: Panama")); // true
        System.out.println("Test 2: " + solution("race a car")); // false
        System.out.println("Test 3: " + solution(" ")); // true
        
        System.out.println("Alternative Solution:");
        System.out.println("Test 1: " + alternativeSolution("A man, a plan, a canal: Panama")); // true
        System.out.println("Test 2: " + alternativeSolution("race a car")); // false
    }

    /**
     * Solution 1: Two-Pointer Approach
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) no extra space needed
     * 
     * Algorithm:
     * - Use two pointers: left (start) and right (end)
     * - Move left pointer right, skipping non-alphanumeric characters
     * - Move right pointer left, skipping non-alphanumeric characters
     * - Compare characters at both pointers (case-insensitive)
     * - If mismatch found, return false
     * - If pointers meet or cross, string is a palindrome
     * 
     * This is the most efficient solution as it processes in O(1) space
     */
    public static Object solution(Object input) {
        String s = (String) input;
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }

    /**
     * Solution 2: Filter and Compare Approach
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the filtered string
     * 
     * Algorithm:
     * - Create a new string with only alphanumeric characters, all lowercase
     * - Use two pointers to check if filtered string is a palindrome
     * - Compare characters from both ends moving inward
     * 
     * Advantage: More readable but uses O(n) extra space
     */
    public static Object alternativeSolution(Object input) {
        String s = (String) input;
        
        // Filter: keep only alphanumeric characters and convert to lowercase
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

//        String ans = s1.chars()
//                .filter(Character::isLetterOrDigit)
//                .mapToObj(c -> String.valueOf((char) c).toLowerCase())
//                .collect(Collectors.joining());
        
        // Check if filtered string is palindrome
        String str = filtered.toString();
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
