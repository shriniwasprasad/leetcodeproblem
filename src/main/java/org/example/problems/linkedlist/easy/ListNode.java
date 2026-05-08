package org.example.problems.linkedlist.easy;

/**
 * Definition for singly-linked list node.
 * This is a utility class used by various linked list problems.
 */
public class ListNode {
    public int val;
    public ListNode next;

    /**
     * Default constructor.
     */
    public ListNode() {}

    /**
     * Constructor with value.
     * @param val the value to store in the node
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * Constructor with value and next node.
     * @param val the value to store in the node
     * @param next the next node in the list
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
