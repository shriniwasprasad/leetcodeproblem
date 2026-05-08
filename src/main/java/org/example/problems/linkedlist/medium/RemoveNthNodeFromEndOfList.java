package org.example.problems.linkedlist.medium;

import org.example.problems.linkedlist.easy.ListNode;

/**
 * Problem: Remove Nth Node From End of List (LeetCode 19)
 * Topic: Linked List, Two Pointers
 * Level: Medium
 *
 * Problem Description:
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Video Explanation: https://www.youtube.com/watch?v=hZtAW3cp8vQ
 * LeetCode Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = solution(head1, 2);
        System.out.print("Test 1 - Result: ");
        printList(result1);  // Expected: 1 -> 2 -> 3 -> 5

        // Test case 2
        ListNode head2 = createList(new int[]{1});
        ListNode result2 = solution(head2, 1);
        System.out.print("Test 2 - Result: ");
        printList(result2);  // Expected: (empty)

        // Test case 3
        ListNode head3 = createList(new int[]{1, 2});
        ListNode result3 = solution(head3, 1);
        System.out.print("Test 3 - Result: ");
        printList(result3);  // Expected: 1

        // Test case 4
        ListNode head4 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result4 = solution(head4, 5);
        System.out.print("Test 4 - Result: ");
        printList(result4);  // Expected: 2 -> 3 -> 4 -> 5

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        ListNode head5 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result5 = alternativeSolution(head5, 2);
        System.out.print("Test 1 - Result: ");
        printList(result5);
    }

    /**
     * Two-pointer approach using dummy node.
     * Use fast and slow pointers with a gap of n.
     * When fast reaches end, slow is at the node before the one to remove.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @param n the position from the end to remove
     * @return the head of the modified list
     */
    public static ListNode solution(ListNode head, int n) {
        // Create dummy node to handle edge case of removing head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * Two-pass approach: first count nodes, then remove.
     * First pass counts total nodes, second pass finds and removes the node.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @param n the position from the end to remove
     * @return the head of the modified list
     */
    public static ListNode alternativeSolution(ListNode head, int n) {
        // First pass: count total nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Calculate position from start (0-indexed)
        int positionToRemove = count - n;

        // If removing head
        if (positionToRemove == 0) {
            return head.next;
        }

        // Second pass: find the node before the one to remove
        current = head;
        for (int i = 0; i < positionToRemove - 1; i++) {
            current = current.next;
        }

        // Remove the node
        current.next = current.next.next;

        return head;
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
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
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
