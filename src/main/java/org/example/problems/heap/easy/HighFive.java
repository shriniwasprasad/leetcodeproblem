package org.example.problems.heap.easy;

import java.util.*;

/**
 * Problem: High Five
 * Topic: Heap
 * Level: Easy
 *
 * Problem Description:
 * Given a list of scores of students, get the top 5 scores for each student and calculate average.
 *
 * Input: 2D array of [studentId, score], find average of top 5 scores per student
 * Output: Map of studentId to average of their top 5 scores
 *
 * Video Explanation: https://www.youtube.com/watch?v=z4c5QzarJxI
 * LeetCode Problem Link: https://leetcode.com/problems/high-five/
 */
public class HighFive {

    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,99},{2,98},{2,97},{2,96},{1,60},{1,58},{2,100}};
        System.out.println("Input: items = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[2,96],[1,60],[1,58],[2,100]]");
        System.out.println("Output: " + solution(items));
    }

    // Min-heap approach: O(N log K) time, O(N) space
    // Key insight: Keep only top 5 scores for each student using min-heap
    public static Map<Integer, Double> solution(int[][] items) {
        Map<Integer, Queue<Integer>> studentScores = new HashMap<>();

        // Collect all scores for each student
        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];
            studentScores.computeIfAbsent(studentId, k -> new PriorityQueue<>()).offer(score);
        }

        Map<Integer, Double> result = new HashMap<>();

        // Calculate average of top 5 scores for each student
        for (Map.Entry<Integer, Queue<Integer>> entry : studentScores.entrySet()) {
            Queue<Integer> scores = entry.getValue();
            double sum = 0;
            int count = 0;

            // Only need top 5, but heap already ordered smallest first
            while (count < 5 && !scores.isEmpty()) {
                sum += scores.poll();
                count++;
            }

            result.put(entry.getKey(), sum / count);
        }
        return result;
    }

    // Alternative: Sort scores in descending order (O(N log N))
    public static Map<Integer, Double> alternativeSolution(int[][] items) {
        Map<Integer, List<Integer>> studentScores = new HashMap<>();

        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];
            studentScores.computeIfAbsent(studentId, k -> new ArrayList<>()).add(score);
        }

        Map<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> scores = entry.getValue();
            scores.sort(Collections.reverseOrder());
            double sum = 0;
            for (int i = 0; i < Math.min(5, scores.size()); i++) {
                sum += scores.get(i);
            }
            result.put(entry.getKey(), sum / Math.min(5, scores.size()));
        }
        return result;
    }
}