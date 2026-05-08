package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Binary Tree Level Order Traversal
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e. from left to right, level by level)
 *
 * LeetCode Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== BinaryTreeLevelOrderTraversal ===");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order: " + levelOrder(root)); // Expected: [[3], [9, 20], [15, 7]]
    }

    public static Object solution(Object input) {
        return levelOrder((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return levelOrder((TreeNode) input);
    }
}
