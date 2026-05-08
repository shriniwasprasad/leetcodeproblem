package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Course Schedule II
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Return an ordering of courses to finish all courses given prerequisites.
 */
public class CourseScheduleIi {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("Course order = " + solution(new Object[]{numCourses, prerequisites}));
    }

    /**
     * Use Kahn's algorithm (BFS topological sort) to generate ordering.
     */
    public static Object solution(Object input) {
        Object[] arr = (Object[]) input;
        int numCourses = (int) arr[0];
        int[][] prereq = (int[][]) arr[1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] p : prereq) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (int nxt : graph.get(cur)) {
                if (--indegree[nxt] == 0) q.add(nxt);
            }
        }
        return order.size() == numCourses ? order : Collections.emptyList();
    }

    public static Object alternativeSolution(Object input) {
        // BFS topological sort is already optimal; delegate.
        return solution(input);
    }
}
