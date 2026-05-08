package org.example.problems.linkedlist.medium;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Problem: Flatten Binary Tree to Linked List (LeetCode 114)
 * Topic: Tree, Depth-First Search, Linked List
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * - The "linked list" should use the same TreeNode class where the right child pointer
 *   points to the next node in the list and the left child pointer is always null.
 * - The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 *
 * Video Explanation: https://www.youtube.com/watch?v=3IrFrQ2JSfg
 * LeetCode Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        // Test case 1: [1,2,5,3,4,null,6]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);

        solution(root1);
        System.out.print("Test 1 - Flattened: ");
        printTreeAsList(root1);  // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6

        // Test case 2: Empty tree
        TreeNode root2 = null;
        solution(root2);
        System.out.print("Test 2 - Flattened: ");
        printTreeAsList(root2);  // Expected: (empty)

        // Test case 3: Single node
        TreeNode root3 = new TreeNode(0);
        solution(root3);
        System.out.print("Test 3 - Flattened: ");
        printTreeAsList(root3);  // Expected: 0

        // Alternative solution test
        System.out.println("\nAlternative Solution Tests:");
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(5);
        root4.left.left = new TreeNode(3);
        root4.left.right = new TreeNode(4);
        root4.right.right = new TreeNode(6);

        alternativeSolution(root4);
        System.out.print("Test 1 - Flattened: ");
        printTreeAsList(root4);
    }

    /**
     * Iterative approach using Morris-like traversal.
     * For each node with a left child:
     * 1. Find the rightmost node in the left subtree
     * 2. Connect that node's right to the current node's right
     * 3. Move the left subtree to the right
     * 4. Set left to null
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param root the root of the binary tree (modified in-place)
     */
    public static void solution(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect rightmost's right to current's right
                rightmost.right = current.right;

                // Move left subtree to right
                current.right = current.left;
                current.left = null;
            }

            // Move to next node
            current = current.right;
        }
    }

    /**
     * Recursive approach using post-order traversal.
     * Process right subtree, then left subtree, then current node.
     * Maintain a 'prev' pointer to build the linked list in reverse.
     * Time Complexity: O(n)
     * Space Complexity: O(h) for recursion stack where h is tree height
     *
     * @param root the root of the binary tree (modified in-place)
     */
    public static void alternativeSolution(TreeNode root) {
        flattenHelper(root);
    }

    // Previous node in reverse pre-order
    private static TreeNode prev = null;

    /**
     * Recursive helper using reverse pre-order traversal.
     * Process: right -> left -> root
     * @param node current node
     */
    private static TreeNode flattenHelper(TreeNode node) {
        if (node == null) {
            return null;
        }

        // Save current node before modifying prev
        TreeNode current = node;

        // Process in reverse order: right, left, then current
        current.right = flattenHelper(node.right);
        current.left = flattenHelper(node.left);

        // Connect to previous node
        current.right = prev;
        current.left = null;
        prev = current;

        return current;
    }

    /**
     * Alternative recursive approach with clearer structure.
     * Uses a instance variable to track previous node.
     * @param root the root of the binary tree
     */
    public static void alternativeSolutionAlt(TreeNode root) {
        prev = null;
        flattenReversePreOrder(root);
    }

    private static void flattenReversePreOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Important: Save children before modifying node
        TreeNode right = node.right;
        TreeNode left = node.left;

        // Connect current node to previous
        node.left = null;
        node.right = prev;
        prev = node;

        // Process children (right first due to reverse order)
        flattenReversePreOrder(right);
        flattenReversePreOrder(left);
    }

    /**
     * Helper method to print tree as flattened list.
     * @param root the root of the tree
     */
    private static void printTreeAsList(TreeNode root) {
        TreeNode current = root;
        int count = 0;
        while (current != null && count < 20) {  // Limit output
            System.out.print(current.val);
            if (current.right != null) {
                System.out.print(" -> ");
            }
            current = current.right;
            count++;
        }
        System.out.println();
    }
}
