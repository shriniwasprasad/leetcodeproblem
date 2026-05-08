package org.example.problems.tree.easy;

import java.util.*;

/**
 * Problem: Symmetric Tree
 * Topic: Tree
 * Level: Easy
 *
 * Problem Description:
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e. symmetric around the center).
 *
 * LeetCode Problem Link: https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {
        System.out.println("=== SymmetricTree ===");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is Symmetric: " + isSymmetric(root)); // Expected: true
    }

    public static Object solution(Object input) {
        return isSymmetric((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return isSymmetric((TreeNode) input);
    }
}
