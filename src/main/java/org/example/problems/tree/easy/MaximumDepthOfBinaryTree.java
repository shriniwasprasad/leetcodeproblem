package org.example.problems.tree.easy;

import java.util.*;

/**
 * Problem: Maximum Depth of Binary Tree
 * Topic: Tree
 * Level: Easy
 *
 * Problem Description:
 * Given the root of a binary tree, return its maximum depth.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println("=== MaximumDepthOfBinaryTree ===");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Depth: " + maxDepth(root)); // Expected: 3
    }

    public static Object solution(Object input) {
        return maxDepth((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return maxDepth((TreeNode) input);
    }
}
