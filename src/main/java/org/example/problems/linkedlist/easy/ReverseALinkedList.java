package org.example.problems.linkedlist.easy;

/**
 * Problem: Reverse a Linked List (LeetCode 206)
 * Topic: Linked List
 * Level: Easy
 *
 * Problem Description:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Video Explanation: https://www.youtube.com/watch?v=FHhItaCZ2pE
 * LeetCode Problem Link: https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseALinkedList {

    public static void main(String[] args) {
        // Test iterative solution
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1 = solution(head1);
        System.out.print("Iterative - Reversed: ");
        printList(reversed1);

        // Test recursive solution (alternative)
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed2 = alternativeSolution(head2);
        System.out.print("Recursive - Reversed: ");
        printList(reversed2);
    }

    /**
     * Iterative approach to reverse a linked list.
     * Uses three pointers: prev, current, and next.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @return the head of the reversed linked list
     */
    public static ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        // Traverse the list and reverse each node's pointer
        while (current != null) {
            ListNode next = current.next;  // Store next node
            current.next = prev;           // Reverse the link
            prev = current;                // Move prev forward
            current = next;                // Move current forward
        }

        return prev;  // prev is now the new head
    }

    /**
     * Recursive approach to reverse a linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(n) - due to recursion stack
     *
     * @param head the head of the linked list
     * @return the head of the reversed linked list
     */
    public static ListNode alternativeSolution(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = alternativeSolution(head.next);

        // Reverse the current node's link
        head.next.next = head;
        head.next = null;

        return newHead;
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
