package org.example.problems.graph.medium;

import java.util.*;

/**
 * Problem: Pacific Atlantic Water Flow
 * Topic: Graph
 * Level: Medium
 *
 * LeetCode description: Find all coordinates where water can flow to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        System.out.println("Cells reaching both oceans: " + solution(heights));
    }

    /**
     * Perform DFS/BFS from the borders of each ocean and intersect reachable cells.
     */
    public static Object solution(Object input) {
        int[][] heights = (int[][]) input;
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        // DFS from Pacific (top and left)
        for (int i = 0; i < m; i++) dfs(heights, pac, i, 0);
        for (int j = 0; j < n; j++) dfs(heights, pac, 0, j);
        // DFS from Atlantic (bottom and right)
        for (int i = 0; i < m; i++) dfs(heights, atl, i, n - 1);
        for (int j = 0; j < n; j++) dfs(heights, atl, m - 1, j);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) res.add(new int[]{i, j});
            }
        }
        return res;
    }

    private static void dfs(int[][] h, boolean[][] visited, int r, int c) {
        int m = h.length, n = h[0].length;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{r, c});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cr = cur[0], cc = cur[1];
            if (visited[cr][cc]) continue;
            visited[cr][cc] = true;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int k = 0; k < 4; k++) {
                int nr = cr + dr[k];
                int nc = cc + dc[k];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (h[nr][nc] >= h[cr][cc]) {
                    stack.push(new int[]{nr, nc});
                }
            }
        }
    }

    public static Object alternativeSolution(Object input) {
        // Stream API does not help with the bidirectional DFS required here.
        return solution(input);
    }
}
