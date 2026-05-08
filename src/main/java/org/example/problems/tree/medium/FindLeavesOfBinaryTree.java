package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Find Leaves of Binary Tree
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given a binary tree root, return the values of the leaves of the tree.
 * For each level of leaves, remove all the leaves and repeat the process.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static int dfs(TreeNode node, int height, List<List<Integer>> result) {
        if (node == null) return -1;

        int h = 1 + Math.max(dfs(node.left, height + 1, result), dfs(node.right, height + 1, result));

        // The height of the node determines which "layer" of leaves it belongs to
        if (result.size() <= h) {
            result.add(new ArrayList<>());
        }
        result.get(h).add(node.val);

        return h;
    }

    public static void main(String[] args) {
        System.out.println("=== FindLeavesOfBinaryTree ===");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Leaves: " + findLeaves(root)); // Expected: [[4, 5], [2], [1]] (Order might vary)
    }

    public static Object solution(Object input) {
        return findLeaves((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return findLeaves((TreeNode) input);
    }
}
