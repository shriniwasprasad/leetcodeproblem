package org.example.problems.tree.medium;

/**
 * Problem: Count Good Nodes In Binary Tree
 * Topic: Trees
 * Level: Medium
 *
 * Problem Description:
 * A node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class CountGoodNodesInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static int countGoodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== CountGoodNodesInBinaryTree ===");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        System.out.println("Good Nodes Count: " + countGoodNodes(root)); // Expected: 4
    }

    public static Object solution(Object input) {
        return countGoodNodes((TreeNode) input);
    }

    public static Object alternativeSolution(Object input) {
        return countGoodNodes((TreeNode) input);
    }
}
