package org.example.problems.tree.easy;

/**
 * Problem: Balanced Binary Tree
 * Topic: Trees
 * Level: Easy
 *
 * Problem Description:
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the left and right subtrees
 * of every node differ in height by no more than 1.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        // If difference in heights is > 1, it's unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        System.out.println("=== BalancedBinaryTree ===");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println("Is Balanced: " + isBalanced(root)); // Expected: false
    }

    public static Object solution(Object input) {
        return isBalanced((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return isBalanced((TreeNode) input);
    }
}
