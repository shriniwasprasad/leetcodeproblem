package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Validate Binary Search Tree
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * LeetCode Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        System.out.println("=== ValidateBinarySearchTree ===");
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Is Valid BST: " + isValidBST(root)); // Expected: true
    }

    public static Object solution(Object input) {
        return isValidBST((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return isValidBST((TreeNode) input);
    }
}
