package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Clone Graph
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Given a reference node of a connected undirected graph, return a deep copy of the graph.
 */
public class CloneGraph {

    /**
     * Graph node definition as used by LeetCode.
     */
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        // Simple test: a triangle graph 1--2--3--1
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);
        n3.neighbors.add(n2);
        Node clone = (Node) solution(n1);
        System.out.println("Clone root val = " + clone.val + ", neighbors = " + clone.neighbors.size());
    }

    public static Object solution(Object input) {
        Node node = (Node) input;
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nb : cur.neighbors) {
                if (!map.containsKey(nb)) {
                    map.put(nb, new Node(nb.val));
                    q.add(nb);
                }
                map.get(cur).neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }

    public static Object alternativeSolution(Object input) {
        // Stream API is not ideal for graph traversal with mutable structures.
        return solution(input);
    }
}
