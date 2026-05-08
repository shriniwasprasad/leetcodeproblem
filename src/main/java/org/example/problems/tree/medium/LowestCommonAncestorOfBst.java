package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Lowest Common Ancestor of BST
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-bst/
 */
public class LowestCommonAncestorOfBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== LowestCommonAncestorOfBst ===");
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left.left; // 0
        TreeNode q = root.left.right; // 4

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA val: " + (lca != null ? lca.val : "null")); // Expected: 2
    }

    public static Object solution(Object input) {
        return null;
    }

    public static Object alternativeSolution(Object input) {
        return null;
    }
}
