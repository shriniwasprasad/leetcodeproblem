package org.example.problems.sorting.medium;

import java.util.*;

/**
 * Problem: Sort List
 * Topic: Sorting / Linked List / Merge Sort
 * Level: Medium
 *
 * Problem Description:
 * Sort a linked list in O(n log n) time using constant space.
 *
 * Input: [4, 2, 1, 3]
 * Output: [1, 2, 3, 4]
 *
 * Video Explanation: https://www.youtube.com/watch?v=7halZ77R55o
 * LeetCode Problem Link: https://leetcode.com/problems/sort-list/
 */
public class SortList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        System.out.println("=== SortList ===");
    }

    /**
     * Solution: Top-down merge sort.
     * Split list using slow/fast pointers, recursively sort, then merge.
     * Time: O(n log n), Space: O(log n) for recursion stack
     */
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = solution(head);
        ListNode right = solution(mid);
        return merge(left, right);
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        return dummy.next;
    }

    /**
     * Alternative Solution: Convert to array, sort, convert back.
     * Time: O(n log n), Space: O(n)
     */
    public static ListNode alternativeSolution(ListNode head) {
        if (head == null) return null;

        List<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        values.sort(Integer::compareTo);

        ListNode dummy = new ListNode(0);
        curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}
