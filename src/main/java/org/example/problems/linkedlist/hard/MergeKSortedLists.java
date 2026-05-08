package org.example.problems.linkedlist.hard;

import org.example.problems.linkedlist.easy.ListNode;
import java.util.*;

/**
 * Problem: Merge K Sorted Lists (LeetCode 23)
 * Topic: Linked List, Heap/Priority Queue, Divide and Conquer
 * Level: Hard
 *
 * Problem Description:
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 * Video Explanation: https://www.youtube.com/watch?v=SlKgDtpJnxg
 * LeetCode Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        // Test case 1: Multiple sorted lists
        ListNode[] lists1 = {
            createList(new int[]{1, 4, 5}),
            createList(new int[]{1, 3, 4}),
            createList(new int[]{2, 6})
        };
        ListNode result1 = solution(lists1);
        System.out.print("Test 1 - Merged: ");
        printList(result1);  // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

        // Test case 2: Empty array
        ListNode[] lists2 = {};
        ListNode result2 = solution(lists2);
        System.out.print("Test 2 - Merged: ");
        printList(result2);  // Expected: (empty)

        // Test case 3: Single list
        ListNode[] lists3 = {createList(new int[]{1, 2, 3})};
        ListNode result3 = solution(lists3);
        System.out.print("Test 3 - Merged: ");
        printList(result3);  // Expected: 1 -> 2 -> 3

        // Alternative solution (Divide and Conquer) tests
        System.out.println("\nAlternative Solution Tests:");
        ListNode[] lists4 = {
            createList(new int[]{1, 4, 5}),
            createList(new int[]{1, 3, 4}),
            createList(new int[]{2, 6})
        };
        ListNode result4 = alternativeSolution(lists4);
        System.out.print("Test 1 - Merged: ");
        printList(result4);
    }

    /**
     * Priority Queue (Min Heap) approach to merge K sorted lists.
     * Add all list heads to min-heap, extract minimum and add its next node.
     * Time Complexity: O(N * log k) where N is total nodes and k is number of lists
     * Space Complexity: O(k) for the priority queue
     *
     * @param lists array of sorted linked lists
     * @return merged sorted linked list
     */
    public static ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap based on node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.val)
        );

        // Add all non-empty list heads to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create dummy head for result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract minimum and add its next node to heap
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    /**
     * Divide and Conquer approach to merge K sorted lists.
     * Recursively merge pairs of lists until one remains.
     * Time Complexity: O(N * log k) where N is total nodes and k is number of lists
     * Space Complexity: O(log k) for recursion stack
     *
     * @param lists array of sorted linked lists
     * @return merged sorted linked list
     */
    public static ListNode alternativeSolution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    /**
     * Helper method for divide and conquer approach.
     * @param lists array of linked lists
     * @param left left index
     * @param right right index
     * @return merged list from l to r
     */
    private static ListNode mergeHelper(ListNode[] lists, int left, int right) {
        // Base case: single list
        if (left == right) {
            return lists[left];
        }

        // Divide
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeHelper(lists, left, mid);
        ListNode rightList = mergeHelper(lists, mid + 1, right);

        // Conquer: merge the two halves
        return mergeTwoLists(leftList, rightList);
    }

    /**
     * Helper method to merge two sorted linked lists.
     * @param l1 first sorted list
     * @param l2 second sorted list
     * @return merged sorted list
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
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
