package org.example.problems.linkedlist.hard;

import org.example.problems.linkedlist.easy.ListNode;

/**
 * Problem: Reverse Nodes in k-Group (LeetCode 25)
 * Topic: Linked List
 * Level: Hard
 *
 * Problem Description:
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * k is a positive integer and is less than or equal to the length of the list.
 * If the number of nodes is not a multiple of k, then the remaining nodes should stay as-is.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Example 3:
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 *
 * Video Explanation: https://www.youtube.com/watch?v=P9_K8M4nnf0
 * LeetCode Problem Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        // Test case 1: k = 2
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = solution(head1, 2);
        System.out.print("Test 1 (k=2) - Result: ");
        printList(result1);  // Expected: 2 -> 1 -> 4 -> 3 -> 5

        // Test case 2: k = 3
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result2 = solution(head2, 3);
        System.out.print("Test 2 (k=3) - Result: ");
        printList(result2);  // Expected: 3 -> 2 -> 1 -> 4 -> 5

        // Test case 3: k = 1 (no change)
        ListNode head3 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result3 = solution(head3, 1);
        System.out.print("Test 3 (k=1) - Result: ");
        printList(result3);  // Expected: 1 -> 2 -> 3 -> 4 -> 5

        // Test case 4: k equals length
        ListNode head4 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result4 = solution(head4, 5);
        System.out.print("Test 4 (k=5) - Result: ");
        printList(result4);  // Expected: 5 -> 4 -> 3 -> 2 -> 1

        // Alternative solution test
        System.out.println("\nAlternative Solution Tests:");
        ListNode head5 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result5 = alternativeSolution(head5, 2);
        System.out.print("Test 1 (k=2) - Result: ");
        printList(result5);
    }

    /**
     * Iterative approach to reverse nodes in k-group.
     * Group nodes by k, check if group has k nodes, reverse if yes.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @param k group size for reversal
     * @return the head of the modified list
     */
    public static ListNode solution(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // Create dummy node for easier head handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are k nodes remaining
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    return dummy.next;  // Not enough nodes left
                }
            }

            // Identify the group boundaries
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;

            // Disconnect the current group
            kthNode.next = null;

            // Reverse the current group
            ListNode reversedGroupHead = reverseList(groupStart);

            // Reconnect: prevGroupEnd -> reversedGroup -> nextGroup
            prevGroupEnd.next = reversedGroupHead;
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }
    }

    /**
     * Recursive approach to reverse nodes in k-group.
     * Recursively process each group of k nodes.
     * Time Complexity: O(n)
     * Space Complexity: O(n/k) for recursion stack
     *
     * @param head the head of the linked list
     * @param k group size for reversal
     * @return the head of the modified list
     */
    public static ListNode alternativeSolution(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        return reverseHelper(head, k);
    }

    /**
     * Recursive helper method.
     * @param head current head of the list
     * @param k group size
     * @return new head after reversal
     */
    private static ListNode reverseHelper(ListNode head, int k) {
        // Check if there are k nodes
        ListNode check = head;
        for (int i = 0; i < k; i++) {
            if (check == null) {
                return head;  // Not enough nodes
            }
            check = check.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Recursively reverse the remaining list and connect
        head.next = reverseHelper(current, k);

        return prev;
    }

    /**
     * Helper method to reverse a linked list segment.
     * @param head the head of the segment to reverse
     * @return the new head of the reversed segment
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
