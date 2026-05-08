package org.example.problems.string.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: Fizz Buzz
 * Topic: String
 * Level: Easy
 *
 * Problem Description:
 * Given an integer n, return a list of strings representing the FizzBuzz sequence from 1 to n.
 * - For numbers divisible by 3, output "Fizz"
 * - For numbers divisible by 5, output "Buzz"
 * - For numbers divisible by both 3 and 5, output "FizzBuzz"
 * - For all other numbers, output the number itself as a string
 *
 * Hint: Check divisibility by 15 (both 3 and 5) first, or build the string by appending "Fizz" and "Buzz".
 *
 * Example:
 * Input: n = 15
 * Expected Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * Constraints:
 * - 1 <= n <= 10^4
 *
 * Video Explanation: https://www.youtube.com/watch?v=E3eO7jTFElU
 * LeetCode Problem Link: https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("=== FizzBuzz ===");
        
        // Test with n = 15
        List<String> result = solution(15);
        System.out.println("Solution (n=15): " + result);
        
        List<String> result2 = alternativeSolution(15);
        System.out.println("Alternative Solution (n=15): " + result2);
    }

    /**
     * Solution 1: Direct if-else approach
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) excluding the output list
     * 
     * Explanation:
     * - Iterate from 1 to n
     * - For each number, check divisibility conditions in order:
     *   1. First check if divisible by both 3 and 5 (must check first)
     *   2. Then check if divisible by 3
     *   3. Then check if divisible by 5
     *   4. Otherwise, add the number as string
     * - The order of checks is important! Check 15 (both) before 3 or 5 alone
     */
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                // Divisible by both 3 and 5
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // Divisible by 3 only
                result.add("Fizz");
            } else if (i % 5 == 0) {
                // Divisible by 5 only
                result.add("Buzz");
            } else {
                // Not divisible by 3 or 5
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }

    /**
     * Solution 2: String concatenation approach
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) excluding the output list
     * 
     * Explanation:
     * - This approach builds the string dynamically
     * - Start with an empty string for each number
     * - If divisible by 3, append "Fizz"
     * - If divisible by 5, append "Buzz"
     * - If string is empty (not divisible by 3 or 5), append the number
     * - This approach is more extensible for variations
     * 
     * Advantage: Easier to add more rules (e.g., "Jazz" for 7) without nested if-else
     */
    public static List<String> alternativeSolution(int n) {
        
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> {
                    String current = "";
                    
                    // Build the string based on divisibility rules
                    if (i % 3 == 0) {
                        current += "Fizz";
                    }
                    if (i % 5 == 0) {
                        current += "Buzz";
                    }
                    
                    // If no rules matched, add the number
                    if (current.isEmpty()) {
                        current = String.valueOf(i);
                    }
                    
                    return current;
                })
                .collect(Collectors.toList());
    }
}
