package org.example.problems.graph.medium;

/**
 * Problem: Cheapest Flights Within K Stops (Bellman-Ford Algorithm)
 * Topic: Advanced Graphs
 * Level: Medium
 *
 * Problem Description:
 * Find the cheapest flight from source to destination with at most k stops.
 * Returns -1 if no valid flight exists.
 *
 * Input:
 * - flights: int[][] where flights[i] = [from, to, price]
 * - src: source airport
 * - dst: destination airport
 * - k: maximum number of stops allowed
 * - Output: Integer representing minimum price or -1 if impossible
 *
 * Example:
 * Input: flights = [[0,1,100],[1,3,100],[2,1,80],[3,2,100],[2,3,90]], src=0, dst=2, k=1
 * Output: 370 (0 -> 1 -> 2 with stops=2)
 *
 * Best Solution: Modified Bellman-Ford Algorithm
 * - Time Complexity: O(K * E) where K is max stops, E is number of flights
 * - Space Complexity: O(n) for distance array
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        System.out.println("=== Cheapest Flights Within K Stops ===\n");

        // Example 1
        int[][] flights1 = {{0, 1, 100}, {1, 3, 100}, {2, 1, 80}, {3, 2, 100}, {2, 3, 90}};
        int src1 = 0;
        int dst1 = 2;
        int k1 = 1;
        System.out.println("Test 1 - Input: flights=" + formatFlights(flights1) +
                           ", src=" + src1 + ", dst=" + dst1 + ", k=" + k1);
        System.out.println("Expected: 370");
        System.out.println("Result: " + solution(flights1, src1, dst1, k1));
        System.out.println();

        // Example 2
        int[][] flights2 = {{0, 1, 100}, {1, 3, 100}, {2, 1, 80}, {3, 2, 100}, {2, 3, 90}};
        int src2 = 0;
        int dst2 = 3;
        int k2 = 2;
        System.out.println("Test 2 - Input: flights=" + formatFlights(flights2) +
                           ", src=" + src2 + ", dst=" + dst2 + ", k=" + k2);
        System.out.println("Expected: 500");
        System.out.println("Result: " + solution(flights2, src2, dst2, k2));
        System.out.println();

        // Example 3 - Impossible case
        int[][] flights3 = {{0, 1, 100}};
        int src3 = 3;
        int dst3 = 2;
        int k3 = 1;
        System.out.println("Test 3 - Input: flights=" + formatFlights(flights3) +
                           ", src=" + src3 + ", dst=" + dst3 + ", k=" + k3);
        System.out.println("Expected: -1");
        System.out.println("Result: " + solution(flights3, src3, dst3, k3));
        System.out.println();

        // Example 4 - Same source and destination
        int[][] flights4 = {{0, 1, 100}};
        int src4 = 0;
        int dst4 = 0;
        int k4 = 1;
        System.out.println("Test 4 - Input: flights=" + formatFlights(flights4) +
                           ", src=" + src4 + ", dst=" + dst4 + ", k=" + k4);
        System.out.println("Expected: 0");
        System.out.println("Result: " + solution(flights4, src4, dst4, k4));
    }

    /**
     * Main solution using Bellman-Ford Algorithm with K-stop limit
     *
     * Implementation Steps:
     * 1. Initialize distance array with infinity, source to 0
     * 2. Relax all edges K+1 times (K stops = K+1 edges)
     * 3. After K+1 iterations, distance[dst] holds the answer
     * 4. Return -1 if distance still infinity
     *
     * @param flights List of directed flights with prices
     * @param src Source airport
     * @param dst Destination airport
     * @param k Maximum number of stops allowed
     * @return Minimum price or -1 if no valid path
     */
    @SuppressWarnings("unused")
    public static int solution(int[][] flights, int src, int dst, int k) {
        // Handle edge cases
        if (flights == null || flights.length == 0) {
            return src == dst ? 0 : -1;
        }

        // Get maximum airport index (assuming 0-indexed, non-negative)
        int maxAirport = 0;
        for (int[] flight : flights) {
            maxAirport = Math.max(maxAirport, Math.max(flight[0], flight[1]));
        }

        // Handle case where source == destination
        if (src == dst) {
            return 0;
        }

        // Step 1: Initialize distances
        // Use maxAirport + 1 to handle any airport index
        int n = maxAirport + 1;
        int[] minPrice = new int[n];
        int INF = Integer.MAX_VALUE / 2; // Avoid overflow during relaxation
        java.util.Arrays.fill(minPrice, INF);
        minPrice[src] = 0;

        // Step 2: Relax edges K+1 times
        for (int i = 0; i <= k; i++) {
            boolean updated = false;
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // Only process reachable airports
                if (minPrice[from] != INF) {
                    int newPrice = minPrice[from] + price;
                    // Relax edge if new path is cheaper and within bounds
                    if (newPrice < minPrice[to] && newPrice < INF) {
                        minPrice[to] = newPrice;
                        updated = true;
                    }
                }
            }

            // Optimization: If no changes in iteration, we can stop early
            // But we need to complete all K iterations to find K-stop path
            // Actually, we can continue with same distances if no updates
        }

        // Step 3: Check if destination is reachable
        return minPrice[dst] >= INF ? -1 : minPrice[dst];
    }

    /**
     * Alternative solution using SPFA (Shortest Path Faster Algorithm)
     * SPFA is an optimized Bellman-Ford using queue
     * Good for sparse graphs with few negative edges
     */
    public static int alternativeSolution(int[][] flights, int src, int dst, int k) {
        if (flights == null || flights.length == 0) {
            return src == dst ? 0 : -1;
        }

        // Calculate max airport index
        int maxAirport = 0;
        for (int[] flight : flights) {
            maxAirport = Math.max(maxAirport, Math.max(flight[0], flight[1]));
        }

        int n = maxAirport + 1;

        // SPFA initialization
        int[] minPrice = new int[n];
        java.util.Arrays.fill(minPrice, Integer.MAX_VALUE / 2);
        boolean[] inQueue = new boolean[n];
        minPrice[src] = 0;

        // Simple queue using head/tail pointers
        int[] queue = new int[n + 1];
        int head = 0, tail = 0;

        // Add source to queue
        queue[tail++] = src;

        // Step 1-3: SPFA iterations
        int steps = 0;
        while (head < tail) {
            int u = queue[head++];
            if (head == n + 1) head = 0; // Wrap around

            steps++;
            if (steps > k + 1) {
                // We've exceeded K stops
                break;
            }

            // Process all outgoing edges from u
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // Only process edges from currently visited node
                if (u == from) {
                    if (minPrice[from] + price < minPrice[to]) {
                        minPrice[to] = minPrice[from] + price;

                        // Add to queue if not already in queue
                        if (!inQueue[to]) {
                            queue[tail++] = to;
                            if (tail == n + 1) tail = 0;
                            inQueue[to] = true;
                        }
                    }
                }
            }
        }

        // Check if destination is reachable
        return minPrice[dst] >= Integer.MAX_VALUE / 2 ? -1 : minPrice[dst];
    }

    /**
     * Another alternative using BFS with level tracking
     * Only useful if all edge weights are positive
     */
    public static int bfsSolution(int[][] flights, int src, int dst, int k) {
        if (flights == null || flights.length == 0) {
            return src == dst ? 0 : -1;
        }

        // Find max airport number
        int maxAirport = 0;
        for (int[] flight : flights) {
            maxAirport = Math.max(maxAirport, Math.max(flight[0], flight[1]));
        }

        // Build adjacency list with prices
        @SuppressWarnings("unchecked")
        java.util.List<int[]>[] adj = new java.util.ArrayList[maxAirport + 2];

        // Initialize adjacency lists
        for (int i = 0; i <= maxAirport + 1; i++) {
            adj[i] = new java.util.ArrayList<>();
        }

        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        // BFS with distance tracking
        int[] minPrice = new int[maxAirport + 2];
        java.util.Arrays.fill(minPrice, Integer.MAX_VALUE / 2);
        minPrice[src] = 0;

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(src);

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();

                for (int[] edge : adj[u]) {
                    int v = edge[0];
                    int price = edge[1];

                    if (minPrice[u] + price < minPrice[v]) {
                        minPrice[v] = minPrice[u] + price;
                        queue.offer(v);
                    }
                }
            }
            stops++;
        }

        return minPrice[dst] >= Integer.MAX_VALUE / 2 ? -1 : minPrice[dst];
    }

    /**
     * Helper method to format flights array for display
     */
    private static String formatFlights(int[][] flights) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < flights.length; i++) {
            sb.append(flights[i]);
            if (i < flights.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
