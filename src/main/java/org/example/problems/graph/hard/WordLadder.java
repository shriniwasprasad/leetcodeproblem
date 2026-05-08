package org.example.problems.graph.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Problem: Word Ladder
 * Topic: Graphs
 * Level: Hard
 *
 * Problem Description:
 * Word Ladder - See LeetCode for full problem statement.
 *
 * Input: See problem description
 * Output: See problem description
 *
 * Video Explanation: https://www.youtube.com/watch?v=isLTjdCw52s
 * LeetCode Problem Link: https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    public static void main(String[] args) {
        System.out.println("=== WordLadder ===");
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = (int) solution(new Object[]{beginWord, endWord, wordList});
        System.out.println("Shortest transformation sequence length: " + result);
    }

    public static Object solution(Object input) {
        Object[] arr = (Object[]) input;
        String beginWord = (String) arr[0];
        String endWord = (String) arr[1];
        List<String> wordList = (List<String>) arr[2];

        // If the end word is not in the word list, return 0
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();

        // Initialize the queue and distance map
        queue.add(beginWord);
        distance.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();

            if (currentWord.equals(endWord)) {
                return distance.get(currentWord);
            }

            for (int i = 0; i < currentWord.length(); i++) {
                char[] chars = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String nextWord = new String(chars);

                    if (wordSet.contains(nextWord) && !distance.containsKey(nextWord)) {
                        queue.add(nextWord);
                        distance.put(nextWord, distance.get(currentWord) + 1);
                    }
                }
            }
        }

        return 0; // If the end word is not reachable
    }

    public static Object alternativeSolution(Object input) {
        // The BFS solution is already optimal; delegate.
        return solution(input);
    }
}
