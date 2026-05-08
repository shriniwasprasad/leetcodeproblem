package org.example.problems.linkedlist.medium;

import org.example.problems.linkedlist.easy.ListNode;

/**
 * Problem: Reorder List (LeetCode 143)
 * Topic: Linked List, Stack, Two Pointers
 * Level: Medium
 *
 * Problem Description:
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You must reorder the list in-place without modifying the values in the nodes.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Video Explanation: https://www.youtube.com/watch?v=lBdS4AV1EGw
 * LeetCode Problem Link: https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4});
        solution(head1);
        System.out.print("Test 1 - Result: ");
        printList(head1);  // Expected: 1 -> 4 -> 2 -> 3

        // Test case 2
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        solution(head2);
        System.out.print("Test 2 - Result: ");
        printList(head2);  // Expected: 1 -> 5 -> 2 -> 4 -> 3

        // Test case 3: Single node
        ListNode head3 = new ListNode(1);
        solution(head3);
        System.out.print("Test 3 - Result: ");
        printList(head3);  // Expected: 1

        // Alternative solution test
        System.out.println("\nAlternative Solution Tests:");
        ListNode head4 = createList(new int[]{1, 2, 3, 4});
        alternativeSolution(head4);
        System.out.print("Test 1 - Result: ");
        printList(head4);
    }

    /**
     * Three-step approach to reorder the list:
     * 1. Find the middle of the list
     * 2. Reverse the second half of the list
     * 3. Merge the two halves alternately
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list (modified in-place)
     */
    public static void solution(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;  // Break the list into two halves

        // Step 3: Merge the two halves alternately
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    /**
     * Stack-based approach to reorder the list.
     * Push all nodes to stack, then pop and insert alternately.
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the stack
     *
     * @param head the head of the linked list (modified in-place)
     */
    public static void alternativeSolution(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Store all nodes in an array for easier access
        java.util.List<ListNode> nodes = new java.util.ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        // Use two pointers and reorder
        int left = 0;
        int right = nodes.size() - 1;

        while (left < right) {
            nodes.get(left).next = nodes.get(right);
            left++;
            if (left >= right) {
                nodes.get(right).next = null;
                break;
            }
            nodes.get(right).next = nodes.get(left);
            right--;
        }
        nodes.get(left).next = null;
    }

    /**
     * Helper method to reverse a linked list.
     * @param head the head of the list to reverse
     * @return the new head of the reversed list
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
