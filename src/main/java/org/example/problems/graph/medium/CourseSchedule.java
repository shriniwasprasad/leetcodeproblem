package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Course Schedule
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Determine if you can finish all courses given prerequisites.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}}; // course 1 depends on 0
        System.out.println("Can finish courses = " + solution(new Object[]{numCourses, prerequisites}));
    }

    /**
     * Topological sort using Kahn's algorithm (BFS).
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
        int visited = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited++;
            for (int nxt : graph.get(cur)) {
                if (--indegree[nxt] == 0) q.add(nxt);
            }
        }
        return visited == numCourses;
    }

    public static Object alternativeSolution(Object input) {
        // The BFS topological sort is already optimal; delegate.
        return solution(input);
    }
}
