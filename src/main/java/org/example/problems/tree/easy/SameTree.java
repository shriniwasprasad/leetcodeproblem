package org.example.problems.tree.easy;

import java.util.*;

/**
 * Problem: Same Tree
 * Topic: Tree
 * Level: Easy
 *
 * Problem Description:
 * Given the roots of two binary trees p and q, write a function to check if they are the same tree.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println("=== SameTree ===");
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println("Are Same: " + isSameTree(p, q)); // Expected: true
    }

    public static Object solution(Object input) {
        return null;
    }

    public static Object alternativeSolution(Object input) {
        return null;
    }
}
