package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Binary Tree Right Side View
 * Topic: Trees
 * Level: Medium
 *
 * Problem Description:
 * Given the root of a binary tree, imagine yourself standing on the right side of it.
 * Return the values of the nodes you can see ordered from top to bottom.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // If this is the last node of the current level, it's the rightmost node
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== BinaryTreeRightSideView ===");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Right Side View: " + rightSideView(root)); // Expected: [1, 3, 7]
    }

    public static Object solution(Object input) {
        return rightSideView((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return rightSideView((TreeNode) input);
    }
}
