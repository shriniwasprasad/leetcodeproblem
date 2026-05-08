package org.example.problems.tree.medium;

import java.util.*;

/**
 * Problem: Implement Trie (Prefix Tree)
 * Topic: Tree (Trie)
 * Level: Medium
 *
 * Problem Description:
 * Implement a trie with insert, search, and startsWith methods.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/implement-trie-(prefix-tree)/
 */
public class ImplementTriePrefixTree {

    public static class Trie {
        private static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isEndOfWord = false;
        }

        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                TrieNode node = current.children.get(c);
                if (node == null) return false;
                current = node;
            }
            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                TrieNode node = current.children.get(c);
                if (node == null) return false;
                current = node;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ImplementTriePrefixTree ===");
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // false
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true

        trie.insert("app");
        System.out.println("Search 'app' after insert: " + trie.search("app")); // true
    }

    public static Object solution(Object input) {
        return new Trie();
    }

    public static Object alternativeSolution(Object input) {
        return new Trie();
    }
}
