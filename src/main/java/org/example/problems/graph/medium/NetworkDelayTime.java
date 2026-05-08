package org.example.problems.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem: Network Delay Time (Shortest Path Problem)
 * Topic: Advanced Graphs
 * Level: Medium
 *
 * Problem Description:
 * Given a network of n servers and directed edges with travel times,
 * find the minimum time needed for all servers to receive a message
 * from a given starting server.
 *
 * Input:
 * - times: int[][] where times[i] = [source, target, delay]
 * - n: number of servers (nodes)
 * - startNode: the server from which message is sent
 * - Output: Integer representing minimum time for all servers to receive message,
 *           or -1 if impossible
 *
 * Example:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, startNode = 2
 * Output: 2
 * Explanation: Start at 2, send to 1 (takes 1), then 2->3->4 (takes 2)
 *
 * Best Solution: Dijkstra's Algorithm
 * - Time Complexity: O((V + E) log V) = O((n + m) log n)
 * - Space Complexity: O(n + m) for adjacency list and queue
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        System.out.println("=== NetworkDelayTime ===\n");

        // Example 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4;
        int startNode1 = 2;
        System.out.println("Test 1 - Input: times=" + Arrays.deepToString(times1) +
                           ", n=" + n1 + ", startNode=" + startNode1);
        System.out.println("Expected: 2");
        System.out.println("Result: " + solution(times1, n1, startNode1));
        System.out.println();

        // Example 2
        int[][] times2 = {{1, 2, 1}, {3, 2, 5}, {3, 4, 2}};
        int n2 = 4;
        int startNode2 = 1;
        System.out.println("Test 2 - Input: times=" + Arrays.deepToString(times2) +
                           ", n=" + n2 + ", startNode=" + startNode2);
        System.out.println("Expected: 4");
        System.out.println("Result: " + solution(times2, n2, startNode2));
        System.out.println();

        // Example 3 - Impossible case
        int[][] times3 = {{1, 2, 1}};
        int n3 = 3;
        int startNode3 = 1;
        System.out.println("Test 3 - Input: times=" + Arrays.deepToString(times3) +
                           ", n=" + n3 + ", startNode=" + startNode3);
        System.out.println("Expected: -1");
        System.out.println("Result: " + solution(times3, n3, startNode3));
    }

    /**
     * Main solution using Dijkstra's Algorithm with Min-Priority Queue
     *
     * Implementation Steps:
     * 1. Build adjacency list representation of the graph
     * 2. Initialize distance array with infinity, set source to 0
     * 3. Use priority queue to always extract node with minimum distance
     * 4. Relax edges: if shorter path found, update distance and add to queue
     * 5. After queue empty, find maximum distance among all reachable nodes
     * 6. Return -1 if any node is unreachable
     *
     * @param times List of directed edges with weights
     * @param n Number of nodes (servers)
     * @param k Start node index
     * @return Minimum time for all nodes to receive message, or -1 if impossible
     */
    public static int solution(int[][] times, int n, int k) {
        // Handle edge case
        if (times == null || times.length == 0) {
            return n == 0 ? 0 : -1;
        }

        // Step 1: Build adjacency list
        // Convert to 0-indexed for easier array operations
        List<List<int[]>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph.get(u).add(new int[]{v, weight});
        }

        // Step 2: Initialize distances
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        // Min-heap: stores {distance, node}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        // Step 3-4: Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int dist = current[0];
            int node = current[1];

            // Skip if we found a shorter path already
            if (dist > distances[node]) {
                continue;
            }

            // Step 4: Relax all outgoing edges
            for (int[] neighbor : graph.get(node)) {
                int neighborNode = neighbor[0];
                int weight = neighbor[1];

                if (distances[node] + weight < distances[neighborNode]) {
                    distances[neighborNode] = distances[node] + weight;
                    minHeap.offer(new int[]{distances[neighborNode], neighborNode});
                }
            }
        }

        // Step 5: Find maximum distance among all nodes
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                // Node unreachable
                return -1;
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }

        return maxDistance;
    }

    /**
     * Alternative solution using simple BFS (only for unweighted graphs or same weights)
     * Note: This is NOT optimal for weighted graphs - included for educational purposes
     */
    @SuppressWarnings("unused")
    public static int alternativeSolution(int[][] times, int n, int k) {
        if (times == null || times.length == 0) {
            return n == 0 ? 0 : -1;
        }

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // Modified Dijkstra without priority queue (works for unweighted)
        // For weighted graphs, use solution() method
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[k] = 0;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int[] neighbor : graph.get(node)) {
                    if (distances[neighbor[0]] == -1) {
                        distances[neighbor[0]] = distances[node] + neighbor[1];
                        queue.offer(neighbor[0]);
                    }
                }
            }
            steps++;
        }

        // Find maximum distance
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == -1) return -1;
            maxDistance = Math.max(maxDistance, distances[i]);
        }

        return maxDistance;
    }

    /**
     * Optimized solution using adjacency matrix (good for dense graphs)
     */
    public static int optimizedSolution(int[][] times, int n, int k) {
        if (times == null || times.length == 0) {
            return n == 0 ? 0 : -1;
        }

        // Initialize with infinity
        int[][] dist = new int[n + 1][n + 1];
        int INF = Integer.MAX_VALUE / 2; // Avoid overflow
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Build graph
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            // Keep minimum weight if multiple edges exist
            dist[u][v] = Math.min(dist[u][v], w);
        }

        // Floyd-Warshall for all-pairs shortest paths
        // O(n³), suitable for small n (< 100)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    dist[i][j] = Math.min(dist[i][j],
                            dist[i][l] + dist[l][j]);
                }
            }
        }

        // Find max distance from source
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[k][i] >= INF) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, dist[k][i]);
        }

        return maxDistance;
    }

}
