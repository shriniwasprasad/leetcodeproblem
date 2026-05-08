package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct the binary tree.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int preorderIndex = 0;
    private static Map<Integer, Integer> inorderMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap.clear();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal);
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== ConstructBinaryTreeFromPreorderAndInorderTraversal ===");
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root val: " + root.val); // Expected: 3
        System.out.println("Left child val: " + root.left.val); // Expected: 9
        System.out.println("Right child val: " + root.right.val); // Expected: 20
    }

    public static Object solution(Object input) {
        return null;
    }

    public static Object alternativeSolution(Object input) {
        return null;
    }
}
