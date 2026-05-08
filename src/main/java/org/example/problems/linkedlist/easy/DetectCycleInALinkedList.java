package org.example.problems.linkedlist.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Detect Cycle in a Linked List (LeetCode 141)
 * Topic: Linked List, Two Pointers
 * Level: Easy
 *
 * Problem Description:
 * Given the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be
 * reached again by continuously following the next pointer.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list.
 *
 * Example 2:
 * Input: head = [1], pos = -1
 * Output: false
 *
 * Video Explanation: https://www.youtube.com/watch?v=k-gTqlOBT1g
 * LeetCode Problem Link: https://leetcode.com/problems/linked-list-cycle/
 */
public class DetectCycleInALinkedList {

    public static void main(String[] args) {
        // Test case 1: List with cycle
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // Create cycle
        System.out.println("Test 1 (with cycle): " + solution(node1));  // true

        // Test case 2: List without cycle
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Test 2 (no cycle): " + solution(head2));  // false

        // Test case 3: Empty list
        System.out.println("Test 3 (empty): " + solution(null));  // false

        // Alternative solution tests
        System.out.println("\nAlternative Solution Tests:");
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(-4);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node6;
        System.out.println("Test 1 (with cycle): " + alternativeSolution(node5));  // true

        ListNode head3 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Test 2 (no cycle): " + alternativeSolution(head3));  // false
    }

    /**
     * Hash Set approach to detect cycle.
     * Store visited nodes in a set and check if we encounter a node twice.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param head the head of the linked list
     * @return true if the list has a cycle, false otherwise
     */
    public static boolean solution(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            // If node already visited, cycle exists
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }

        return false;
    }

    /**
     * Floyd's Tortoise and Hare algorithm (Two Pointers).
     * Use slow and fast pointers - if they meet, there's a cycle.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the linked list
     * @return true if the list has a cycle, false otherwise
     */
    public static boolean alternativeSolution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, there's a cycle
            if (slow == fast) {
                return true;
            }
        }

        return false;
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
}
