package string.easy;

import java.util.*;

/**
 * Problem: Palindrome Linked List
 * Topic: String/LinkedList
 * Level: Easy
 *
 * Problem Description:
 * Given the head of a singly linked list, return true if it is a palindrome, or false otherwise.
 * A palindrome linked list reads the same forward and backward.
 *
 * The order of the nodes matters - you need to check if the values read the same way
 * when traversing from head to tail as when traversing from tail to head.
 *
 * Hint: You can convert the list to an array for easy comparison, or find the middle, reverse the second half, and compare it with the first half for O(1) space.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Expected Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Expected Output: false
 *
 * Example 3:
 * Input: head = [1,1,1,1]
 * Expected Output: true
 *
 * Example 4:
 * Input: head = [1,2,3,2,1]
 * Expected Output: true
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 10^5]
 * - 0 <= Node.val <= 9
 *
 * Video Explanation: https://www.youtube.com/watch?v=uGGAJxeXa4U
 * LeetCode Problem Link: https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    
    /**
     * Definition for singly-linked list node
     */
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== PalindromeLinkedList ===");
        
        // Test case 1: [1,2,2,1] - palindrome
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println("Test 1 (1->2->2->1): " + solution(head1)); // true
        
        // Test case 2: [1,2] - not palindrome
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Test 2 (1->2): " + solution(head2)); // false
        
        // Test case 3: [1] - palindrome (single element)
        ListNode head3 = new ListNode(1);
        System.out.println("Test 3 (1): " + solution(head3)); // true
        
        // Test case 4: [1,2,3,2,1] - palindrome (odd length)
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(2);
        head4.next.next.next.next = new ListNode(1);
        System.out.println("Test 4 (1->2->3->2->1): " + solution(head4)); // true
        
        System.out.println("\nAlternative Solution:");
        
        // Recreate test case 1 for alternative solution
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(2);
        head5.next.next.next = new ListNode(1);
        System.out.println("Test 1 (1->2->2->1): " + alternativeSolution(head5)); // true
        
        // Recreate test case 2 for alternative solution
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        System.out.println("Test 2 (1->2): " + alternativeSolution(head6)); // false
    }

    /**
     * Solution 1: Convert to Array and Compare (Simple and Intuitive)
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(n) for the array storage
     * 
     * Algorithm:
     * - Traverse the linked list and store all values in an array
     * - Use two pointers (left and right) to compare values from both ends
     * - If all values match when moving towards center, it's a palindrome
     * - If any mismatch is found, it's not a palindrome
     * 
     * How it works with [1,2,2,1]:
     * 1. Convert to array: [1,2,2,1]
     * 2. Compare: array[0]=1 with array[3]=1 ✓
     * 3. Compare: array[1]=2 with array[2]=2 ✓
     * 4. All match, return true
     * 
     * Pros: Easy to understand and implement
     * Cons: Uses O(n) extra space
     */
    public static Object solution(Object input) {
        ListNode head = (ListNode) input;
        
        if (head == null || head.next == null) {
            return true; // Empty or single node is palindrome
        }
        
        // Step 1: Convert linked list to array
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        // Step 2: Use two pointers to check if array is palindrome
        int left = 0;
        int right = values.size() - 1;
        
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }
        
        return true; // All values match, it's a palindrome
    }

    /**
     * Solution 2: Fast/Slow Pointer with Reversal (Space-Optimized)
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1) excluding recursion stack
     * 
     * Algorithm:
     * - Use fast pointer (moves 2 steps) and slow pointer (moves 1 step) to find middle
     * - Reverse the second half of the linked list
     * - Compare first half with reversed second half
     * - Restore the list to original state (optional)
     * 
     * How it works with [1,2,2,1]:
     * 1. Find middle using fast/slow pointers
     *    Slow reaches 2, Fast reaches end
     *    Middle is found
     * 2. Reverse second half: [2,1] becomes [1,2]
     * 3. Compare first [1,2] with reversed [1,2]
     * 4. All match, return true
     * 
     * Pros: Only uses O(1) extra space
     * Cons: Modifies the list (can be restored)
     */
    public static Object alternativeSolution(Object input) {
        ListNode head = (ListNode) input;
        
        if (head == null || head.next == null) {
            return true;
        }
        
        // Step 1: Find the middle of the linked list using fast/slow pointers
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move 2 steps
            slow = slow.next;        // Move 1 step
        }
        
        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow);
        
        // Step 3: Compare first half with reversed second half
        ListNode firstHalf = head;
        ListNode secondHalfCopy = secondHalf;
        boolean isPalindrome = true;
        
        while (secondHalfCopy != null) {
            if (firstHalf.val != secondHalfCopy.val) {
                isPalindrome = false;
                break; // Mismatch found
            }
            firstHalf = firstHalf.next;
            secondHalfCopy = secondHalfCopy.next;
        }
        
        // Step 4: Optional - Restore the list to original state
        reverse(secondHalf);
        
        return isPalindrome;
    }
    
    /**
     * Helper method: Reverse a linked list
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * How it works:
     * Input:  1 -> 2 -> 3 -> null
     * Output: 3 -> 2 -> 1 -> null
     * 
     * Process:
     * 1. prev=null, curr=1: 1->null
     * 2. prev=1, curr=2: 2->1->null
     * 3. prev=2, curr=3: 3->2->1->null
     */
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}
