package org.example.problems.linkedlist.medium;

import org.example.problems.linkedlist.easy.ListNode;

/**
 * Problem: Add Two Numbers (LeetCode 2)
 * Topic: Linked List, Math
 * Level: Medium
 *
 * Problem Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each node contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Video Explanation: https://www.youtube.com/watch?v=MYtp__JpTns
 * LeetCode Problem Link: https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        // Test case 1
        ListNode l1 = createList(new int[]{2, 4, 3});  // 342
        ListNode l2 = createList(new int[]{5, 6, 4});  // 465
        ListNode result1 = solution(l1, l2);
        System.out.print("Test 1 - Result: ");
        printList(result1);  // Expected: 7 -> 0 -> 8 (807)

        // Test case 2
        ListNode l3 = createList(new int[]{0});
        ListNode l4 = createList(new int[]{0});
        ListNode result2 = solution(l3, l4);
        System.out.print("Test 2 - Result: ");
        printList(result2);  // Expected: 0

        // Test case 3
        ListNode l5 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l6 = createList(new int[]{9, 9, 9, 9});
        ListNode result3 = solution(l5, l6);
        System.out.print("Test 3 - Result: ");
        printList(result3);  // Expected: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        ListNode l7 = createList(new int[]{2, 4, 3});
        ListNode l8 = createList(new int[]{5, 6, 4});
        ListNode result4 = alternativeSolution(l7, l8);
        System.out.print("Test 1 - Result: ");
        printList(result4);
    }

    /**
     * Iterative approach to add two numbers represented as linked lists.
     * Process each digit from right to left, keeping track of carry.
     * Time Complexity: O(max(m, n)) where m and n are lengths of l1 and l2
     * Space Complexity: O(max(m, n)) for the result list
     *
     * @param l1 first linked list
     * @param l2 second linked list
     * @return linked list representing the sum
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy head for result list
        ListNode current = dummy;
        int carry = 0;

        // Process both lists while there are digits or carry remains
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from nodes (0 if node is null)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and new carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;  // Carry is quotient when divided by 10
            int digit = sum % 10;  // Current digit is remainder

            // Create new node with the digit
            current.next = new ListNode(digit);
            current = current.next;

            // Move to next nodes if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;  // Return result (skip dummy head)
    }

    /**
     * Alternative recursive approach to add two numbers.
     * Recursively process each position and handle carry.
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n)) for recursion stack
     *
     * @param l1 first linked list
     * @param l2 second linked list
     * @return linked list representing the sum
     */
    public static ListNode alternativeSolution(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }

    /**
     * Helper method for recursive solution.
     * @param l1 current node of first list
     * @param l2 current node of second list
     * @param carry carry from previous position
     * @return result linked list from this position onwards
     */
    private static ListNode addHelper(ListNode l1, ListNode l2, int carry) {
        // Base case: both lists exhausted and no carry
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        // Calculate sum of current positions
        int val1 = (l1 != null) ? l1.val : 0;
        int val2 = (l2 != null) ? l2.val : 0;
        int sum = val1 + val2 + carry;

        // Create current node
        ListNode node = new ListNode(sum % 10);

        // Recursively process next positions
        ListNode nextL1 = (l1 != null) ? l1.next : null;
        ListNode nextL2 = (l2 != null) ? l2.next : null;
        node.next = addHelper(nextL1, nextL2, sum / 10);

        return node;
    }

    /**
     * Helper method to create a linked list from an array.
     * @param values array of values
     * @return head of the created linked list
     */
    private static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Helper method to print a linked list.
     * @param head the head of the linked list
     */
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
