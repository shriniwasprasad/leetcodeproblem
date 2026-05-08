package org.example.problems.linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Copy List with Random Pointer (LeetCode 138)
 * Topic: Linked List, Hash Map
 * Level: Medium
 *
 * Problem Description:
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 *
 * Each node in the original list has:
 * - next: pointer to the next node
 * - random: pointer to any node in the list or null
 *
 * The copied list should have the same structure as the original list,
 * with random and next pointers pointing to new nodes in the copied list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Video Explanation: https://www.youtube.com/watch?v=vy7ZJ4TdyS8
 * LeetCode Problem Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 */

// Definition for a Node with random pointer
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        // Test case 1: Complex list with random pointers
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node copy1 = solution(node1);
        System.out.println("Test 1 - Copy created successfully: " + (copy1 != null));
        printListWithRandom(copy1);

        // Test case 2: Simple list
        Node node6 = new Node(1);
        Node node7 = new Node(2);
        node6.next = node7;
        node6.random = node7;
        node7.random = node6;

        Node copy2 = solution(node6);
        System.out.println("\nTest 2 - Copy created successfully: " + (copy2 != null));
        printListWithRandom(copy2);

        // Alternative solution test
        System.out.println("\n--- Alternative Solution Tests ---");
        Node node8 = new Node(7);
        Node node9 = new Node(13);
        Node node10 = new Node(11);

        node8.next = node9;
        node9.next = node10;
        node8.random = null;
        node9.random = node8;
        node10.random = node8;

        Node copy3 = alternativeSolution(node8);
        System.out.println("Test 3 - Copy created successfully: " + (copy3 != null));
        printListWithRandom(copy3);
    }

    /**
     * Hash Map approach to copy the list with random pointers.
     * First pass: create all new nodes and store mapping in hash map.
     * Second pass: connect next and random pointers using the map.
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the hash map
     *
     * @param head the head of the original list
     * @return the head of the copied list
     */
    public static Node solution(Node head) {
        if (head == null) {
            return null;
        }

        // Map to store original node -> copied node mapping
        Map<Node, Node> map = new HashMap<>();

        // First pass: create all new nodes
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Second pass: connect next and random pointers
        current = head;
        while (current != null) {
            Node copiedNode = map.get(current);
            copiedNode.next = map.get(current.next);
            copiedNode.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    /**
     * Space-optimized approach without using extra hash map.
     * Uses three passes:
     * 1. Interweave original and copied nodes (A -> A' -> B -> B' -> C -> C')
     * 2. Set random pointers for copied nodes
     * 3. Separate the two lists
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head the head of the original list
     * @return the head of the copied list
     */
    public static Node alternativeSolution(Node head) {
        if (head == null) {
            return null;
        }

        // First pass: create and interweave copied nodes
        Node current = head;
        while (current != null) {
            Node copiedNode = new Node(current.val);
            copiedNode.next = current.next;
            current.next = copiedNode;
            current = copiedNode.next;
        }

        // Second pass: assign random pointers to copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Third pass: separate the two lists
        Node original = head;
        Node copiedHead = head.next;
        Node copied = copiedHead;

        while (original != null) {
            original.next = original.next.next;
            if (copied.next != null) {
                copied.next = copied.next.next;
            }
            original = original.next;
            copied = copied.next;
        }

        return copiedHead;
    }

    /**
     * Helper method to print list with random pointers.
     * @param head the head of the list
     */
    private static void printListWithRandom(Node head) {
        Node current = head;
        int index = 0;
        while (current != null) {
            int randomIndex = (current.random != null) ? indexOf(head, current.random) : -1;
            System.out.printf("Node %d: val=%d, random->Node %d%n", index++, current.val, randomIndex);
            current = current.next;
        }
    }

    /**
     * Helper method to find index of a node in the list.
     * @param head the head of the list
     * @param node the node to find
     * @return the index of the node, or -1 if not found
     */
    private static int indexOf(Node head, Node node) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current == node) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
}
