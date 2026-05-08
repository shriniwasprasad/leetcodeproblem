package org.example.problems.linkedlist.easy;

/**
 * Problem: Reverse Linked List
 * Topic: Linked List
 * Level: Easy
 *
 * Problem Description:
 * Reverse Linked List - See LeetCode for full problem statement.
 *
 * Input: ListNode head
 * Output: ListNode
 *
 * Video Explanation: https://www.youtube.com/watch?v=FHhItaCZ2pE
 * LeetCode Problem Link: https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println("=== ReverseLinkedList ===");
    }

    public static ListNode solution(ListNode head) {
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

    public static ListNode alternativeSolution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = alternativeSolution(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
