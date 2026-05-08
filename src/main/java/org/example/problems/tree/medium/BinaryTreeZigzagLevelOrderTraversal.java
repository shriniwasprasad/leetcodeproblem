package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Binary Tree Zigzag Level Order Traversal
 * Topic: Tree
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e. from left to right, then right to left for the next level and so on).
 *
 * LeetCode Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== BinaryTreeZigzagLevelOrderTraversal ===");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Zigzag Order: " + zigzagLevelOrder(root)); // Expected: [[3], [20, 9], [4, 7, 15, 7]]
    }

    public static Object solution(Object input) {
        return zigzagLevelOrder((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return zigzagLevelOrder((TreeNode) input);
    }
}
