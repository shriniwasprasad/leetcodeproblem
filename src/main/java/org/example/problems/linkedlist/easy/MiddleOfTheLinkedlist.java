package org.example.problems.linkedlist.easy;

/**
 * Problem: Middle of the Linked List (LeetCode 876)
 * Topic: Linked List, Two Pointers
 * Level: Easy
 *
 * Problem Description:
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 *
 * Video Explanation: https://www.youtube.com/watch?v=s7cHxJBuhjg
 * LeetCode Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedlist {

    public static void main(String[] args) {
        // Test case 1: Odd number of nodes
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode middle1 = solution(head1);
        System.out.print("Test 1 - Middle: ");
        printList(middle1);  // Expected: 3 -> 4 -> 5

        // Test case 2: Even number of nodes
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middle2 = solution(head2);
        System.out.print("Test 2 - Middle: ");
        printList(middle2);  // Expected: 4 -> 5 -> 6

        // Test case 3: Single node
        ListNode head3 = new ListNode(1);
        ListNode middle3 = solution(head3);
        System.out.print("Test 3 - Middle: ");
        printList(middle3);  // Expected: 1

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        ListNode head4 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode middle4 = alternativeSolution(head4);
        System.out.print("Test 1 - Middle: ");
        printList(middle4);

        ListNode head5 = createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middle5 = alternativeSolution(head5);
        System.out.print("Test 2 - Middle: ");
        printList(middle5);
    }

    /**
     * Two-pointer approach to find the middle node.
     * Use slow pointer (moves 1 step) and fast pointer (moves 2 steps).
     * When fast reaches the end, slow is at the middle.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @return the middle node of the linked list
     */
    public static ListNode solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // slow is now at the middle
    }

    /**
     * Alternative approach: Count nodes first, then traverse to middle.
     * First count total nodes, then traverse to count/2 position.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @return the middle node of the linked list
     */
    public static ListNode alternativeSolution(ListNode head) {
        // Count total number of nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Calculate middle index (for even count, return second middle)
        int middleIndex = count / 2;

        // Traverse to the middle node
        current = head;
        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }

        return current;
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
