package org.example.problems.tree.hard;

import java.util.*;

/**
 * Problem: Binary Tree Maximum Path Sum
 * Topic: Tree
 * Level: Hard
 *
 * Problem Description:
 * A path between two nodes is a sequence of nodes such that each pair of adjacent nodes has an edge connecting them.
 * The path sum is the sum of the node's values in the path.
 * Return the maximum path sum of any non-empty path.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int maxPath = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        gainFromNode(root);
        return maxPath;
    }

    private static int gainFromNode(TreeNode node) {
        if (node == null) return 0;

        // Max contribution from left and right subtrees; ignore negative contributions
        int leftGain = Math.max(gainFromNode(node.left), 0);
        int rightGain = Math.max(gainFromNode(node.right), 0);

        // The price of a path passing through this node
        int currentPathSum = node.val + leftGain + rightGain;
        maxPath = Math.max(maxPath, currentPathSum);

        // Return the max contribution this node can provide to its parent
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        System.out.println("=== BinaryTreeMaximumPathSum ===");
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Path Sum: " + maxPathSum(root)); // Expected: 42
    }

    public static Object solution(Object input) {
        return maxPathSum((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return maxPathSum((TreeNode) input);
    }
}
