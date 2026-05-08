package string.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Valid Parentheses
 * Topic: String
 * Level: Easy
 *
 * Problem Description:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of closing bracket
 * 2. Open brackets must be closed in the correct order
 * 3. Every close bracket has a corresponding open bracket of the same type
 *
 * Hint: A stack is ideal for this problem because the last opening bracket encountered must be the first one closed.
 *
 * Example 1:
 * Input: s = "()"
 * Expected Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Expected Output: true
 *
 * Example 3:
 * Input: s = "([)]"
 * Expected Output: false
 *
 * Example 4:
 * Input: s = "([{}])"
 * Expected Output: true
 *
 * Constraints:
 * - 1 <= s.length() <= 10^4
 * - s consists of parentheses only: '()[]{}'
 *
 * Video Explanation: https://www.youtube.com/watch?v=D4l9TK0tWcI
 * LeetCode Problem Link: https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("=== ValidParentheses ===");
        
        // Test cases
        System.out.println("Test 1: " + solution("()")); // true
        System.out.println("Test 2: " + solution("()[]{}")); // true
        System.out.println("Test 3: " + solution("([)]")); // false
        System.out.println("Test 4: " + solution("([{}])")); // true
        System.out.println("Test 5: " + solution("{")); // false
        
        System.out.println("\nAlternative Solution:");
        System.out.println("Test 1: " + alternativeSolution("()")); // true
        System.out.println("Test 2: " + alternativeSolution("()[]{}")); // true
    }

    /**
     * Solution 1: Stack with HashMap (Clean & Elegant)
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the stack in worst case
     * 
     * Algorithm:
     * - Use a stack to store opening brackets
     * - Create a mapping of closing brackets to their corresponding opening brackets
     * - Iterate through each character:
     *   - If it's a closing bracket, check if stack is empty or top doesn't match
     *   - If it's an opening bracket, push to stack
     * - At the end, stack must be empty (all brackets matched)
     * 
     * Key Insight: When we see a closing bracket, the last opening bracket must match it
     * This is what makes the stack approach perfect for this problem
     */
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Map each closing bracket to its corresponding opening bracket
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // Current character is a closing bracket
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // Current character is an opening bracket
                stack.push(c);
            }
        }
        
        // All brackets should be matched, so stack must be empty
        return stack.isEmpty();
    }

    /**
     * Solution 2: Deque with Explicit Checks
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the deque in worst case
     * 
     * Algorithm:
     * - Use a Deque (ArrayDeque is faster than Stack)
     * - Explicitly check for opening brackets and push to deque
     * - For closing brackets, verify matching with top of deque
     * - Stack must be empty at the end
     * 
     * Advantage: Deque is more performant than Stack, explicit logic easier to understand
     */
    public static boolean alternativeSolution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket: push to stack
                stack.push(c);
            } else {
                // Closing bracket: check if matches top of stack
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                
                // Verify the closing bracket matches the opening bracket
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // All brackets should be matched, so stack must be empty
        return stack.isEmpty();
    }
}
