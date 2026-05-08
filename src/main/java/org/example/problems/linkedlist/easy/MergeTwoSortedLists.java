package org.example.problems.linkedlist.easy;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Merge Two Sorted Lists
 * Topic: Linked List
 * Level: Easy
 *
 * Problem Description:
 * Merge Two Sorted Lists - See LeetCode for full problem statement.
 *
 * Input: ListNode l1, ListNode l2
 * Output: ListNode
 *
 * Video Explanation: https://www.youtube.com/watch?v=Bwymxn-n6XA
 * LeetCode Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        System.out.println("=== MergeTwoSortedLists ===");
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
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
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static ListNode alternativeSolution(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = (l1 == null) ? l2 : (l2 == null) ? l1 :
                (l1.val <= l2.val) ? l1 : l2;
        if (dummy.next == l1) l1 = l1.next;
        else l2 = l2.next;
        ListNode current = dummy.next;
        while (l1 != null || l2 != null) {
            if (l1 == null) { current.next = l2; break; }
            if (l2 == null) { current.next = l1; break; }
            if (l1.val <= l2.val) { current.next = l1; l1 = l1.next; }
            else { current.next = l2; l2 = l2.next; }
            current = current.next;
        }
        return dummy.next;
    }
}
