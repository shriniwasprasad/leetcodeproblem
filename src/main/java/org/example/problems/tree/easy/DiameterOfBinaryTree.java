package org.example.problems.tree.easy;

/**
 * Problem: Diameter of Binary Tree
 * Topic: Trees
 * Level: Easy
 *
 * Problem Description:
 * Given the root of a binary tree, return the length of the diameter of the binary tree.
 * The diameter is the length of the longest path between any two nodes in a tree.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private static int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Diameter through this node is sum of left and right heights
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        System.out.println("=== DiameterOfBinaryTree ===");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Diameter: " + diameterOfBinaryTree(root)); // Expected: 4
    }

    public static Object solution(Object input) {
        return diameterOfBinaryTree((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return diameterOfBinaryTree((TreeNode) input);
    }
}
