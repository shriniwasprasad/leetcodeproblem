package org.example.problems.tree.easy;

import java.util.*;

/**
 * Problem: Invert/Flip Binary Tree
 * Topic: Tree
 * Level: Easy
 *
 * Problem Description:
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertflipBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== InvertflipBinaryTree ===");
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = invertTree(root);
        System.out.println("Root val: " + inverted.val); // 4
        System.out.println("Left child val: " + inverted.left.val); // Expected: 7
        System.out.println("Right child val: " + inverted.right.val); // Expected: 2
    }

    public static Object solution(Object input) {
        return invertTree((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return invertTree((TreeNode) input);
    }
}
