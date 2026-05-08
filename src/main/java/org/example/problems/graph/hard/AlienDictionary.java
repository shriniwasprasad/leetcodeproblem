package org.example.problems.graph.hard;

import java.util.*;

/**
 * Problem: Alien Dictionary (LeetCode Premium)
 * Topic: Graph
 * Level: Hard
 *
 * LeetCode description: Given a sorted list of alien words, derive the order of characters.
 */
public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println("Alien order = " + solution(words));
    }

    /**
     * Topological sort (Kahn's algorithm) on the character precedence graph.
     */
    public static Object solution(Object input) {
        String[] words = (String[]) input;
        // Build graph
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;
            while (j < len && w1.charAt(j) == w2.charAt(j)) j++;
            if (j < len) {
                char a = w1.charAt(j);
                char b = w2.charAt(j);
                if (!adj.get(a).contains(b)) {
                    adj.get(a).add(b);
                    indegree.put(b, indegree.get(b) + 1);
                }
            } else if (w1.length() > w2.length()) {
                // Invalid ordering like ["abc","ab"]
                return "";
            }
        }
        // Kahn's BFS
        StringBuilder order = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();
        for (Map.Entry<Character,Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) dq.add(e.getKey());
        }
        while (!dq.isEmpty()) {
            char cur = dq.poll();
            order.append(cur);
            for (char nb : adj.getOrDefault(cur, Collections.emptySet())) {
                indegree.put(nb, indegree.get(nb) - 1);
                if (indegree.get(nb) == 0) dq.add(nb);
            }
        }
        return order.length() == indegree.size() ? order.toString() : "";
    }

    public static Object alternativeSolution(Object input) {
        // The graph approach is already optimal; delegate.
        return solution(input);
    }
}
