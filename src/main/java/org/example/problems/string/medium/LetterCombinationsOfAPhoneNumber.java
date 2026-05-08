package string.medium;

import java.util.*;

/**
 * Problem: Letter Combinations of a Phone Number
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters is given as below (just like on the telephone buttons):
 * 2 -> "abc", 3 -> "def", 4 -> "ghi", 5 -> "jkl", 6 -> "mno", 7 -> "pqrs", 8 -> "tuv", 9 -> "wxyz"
 *
 * Hint: Use backtracking to explore all combinations. For each digit, iterate through its mapped letters and recurse for the next digit.
 *
 * Example 1:
 * Input: digits = "23"
 * Expected Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Expected Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Expected Output: ["a","b","c"]
 *
 * Constraints:
 * - 0 <= digits.length() <= 4
 * - digits[i] is a digit in the range ['2', '9']
 *
 * Video Explanation: https://www.youtube.com/watch?v=dmYiOfy8a-k
 * LeetCode Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println("=== LetterCombinationsOfAPhoneNumber ===");
        
        // Test cases
        System.out.println("Test 1: " + solution("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println("Test 2: " + solution("")); // []
        System.out.println("Test 3: " + solution("2")); // ["a","b","c"]
        System.out.println("Test 4: " + solution("234")); // 27 combinations
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: " + alternativeSolution("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }

    /**
     * Solution 1: Backtracking (Most Intuitive)
     * 
     * Time Complexity: O(4^n) where n is length of digits (at most 4 digits, each maps to 4 letters)
     * Space Complexity: O(4^n) for the result list
     * 
     * Algorithm:
     * - Use a mapping of digit to letters
     * - Use backtracking to generate all combinations
     * - For each digit, try all possible letters it can map to
     * - Recursively process the remaining digits
     * - When all digits are processed, add the combination to result
     * 
     * How it works with "23":
     * 1. Start with empty string ""
     * 2. Process digit '2' (maps to "abc"):
     *    - Try 'a': recurse with "a" and remaining "3"
     *      - Process digit '3' (maps to "def"):
     *        - Try 'd': "ad" (complete)
     *        - Try 'e': "ae" (complete)
     *        - Try 'f': "af" (complete)
     *    - Try 'b': recurse with "b" and remaining "3" -> "bd", "be", "bf"
     *    - Try 'c': recurse with "c" and remaining "3" -> "cd", "ce", "cf"
     * Result: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    public static Object solution(Object input) {
        String digits = (String) input;
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Mapping of digit to letters
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        
        // Start backtracking
        backtrack(digits, 0, "", result, phoneMap);
        return result;
    }
    
    private static void backtrack(String digits, int index, String current, 
                                   List<String> result, Map<Character, String> phoneMap) {
        // Base case: all digits processed
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        // Get the letters corresponding to current digit
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        
        // Try each letter
        for (char letter : letters.toCharArray()) {
            backtrack(digits, index + 1, current + letter, result, phoneMap);
        }
    }

    /**
     * Solution 2: Iterative BFS Approach
     * 
     * Time Complexity: O(4^n) where n is length of digits
     * Space Complexity: O(4^n) for the result queue
     * 
     * Algorithm:
     * - Start with a queue containing empty string
     * - For each digit, expand all current combinations by appending its mapped letters
     * - Process all digits to generate all combinations
     * 
     * Advantage: No recursion stack, easier to understand for some people
     */
    public static Object alternativeSolution(Object input) {
        String digits = (String) input;
        
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        // Mapping of digit to letters
        String[] phoneMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        
        for (char digit : digits.toCharArray()) {
            int size = queue.size();
            String letters = phoneMap[digit - '0'];
            
            // Process all current combinations
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // Add each letter to the current combination
                for (char letter : letters.toCharArray()) {
                    queue.offer(current + letter);
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}
