package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Kth Smallest Element in a BST
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary search tree, return the kth smallest value in the BST.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int count = 0;
    private static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }

    public static void main(String[] args) {
        System.out.println("=== KthSmallestElementInABst ===");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        System.out.println("3rd smallest: " + kthSmallest(root, 3)); // Expected: 3
    }

    public static Object solution(Object input) {
        return null;
    }

    public static Object alternativeSolution(Object input) {
        return null;
    }
}
