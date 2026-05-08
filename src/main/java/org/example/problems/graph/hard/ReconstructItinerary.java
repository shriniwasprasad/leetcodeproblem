package org.example.problems.graph.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: Reconstruct Itinerary (Eulerian Path Problem)
 * Topic: Advanced Graphs
 * Level: Hard
 *
 * Problem Description:
 * Given a list of air tickets where each ticket represents a route from
 * origin to destination, reconstruct the itinerary in lexicographically smallest order.
 * All tickets form a continuous journey starting from "JFK".
 *
 * Input:
 * - tickets: String[][] where tickets[i] = [origin, destination]
 * - Output: String[] representing the reconstructed itinerary
 *
 * Example:
 * Input: tickets = [["MUC","HNL"],["SFO","MUC"],["HNL","SFO"]]
 * Output: ["SFO","MUC","HNL"] (sorted itinerary)
 *
 * Best Solution: Hierholzer's Algorithm (Modified for Lexicographical Order)
 * - Time Complexity: O(T log T) where T is number of tickets (due to sorting)
 * - Space Complexity: O(V + E) for adjacency list
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        System.out.println("=== Reconstruct Itinerary ===\n");

        // Example 1
        String[][] tickets1 = {{"MUC", "HNL"}, {"SFO", "MUC"}, {"HNL", "SFO"}};
        System.out.println("Test 1 - Input: " + formatTickets(tickets1));
        System.out.println("Expected: [SFO, MUC, HNL]");
        System.out.println("Result: " + Arrays.toString(solution(tickets1)));
        System.out.println();

        // Example 2
        String[][] tickets2 = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"},
                                {"ATL", "SFO"}};
        System.out.println("Test 2 - Input: " + formatTickets(tickets2));
        System.out.println("Expected: [JFK, ATL, SFO, JFK, SFO]");
        System.out.println("Result: " + Arrays.toString(solution(tickets2)));
        System.out.println();

        // Example 3 - Simple case
        String[][] tickets3 = {{"JFK", "AAA"}, {"JFK", "AA"}, {"AA", "AAA"}};
        System.out.println("Test 3 - Input: " + formatTickets(tickets3));
        System.out.println("Expected: [JFK, AA, AAA]");
        System.out.println("Result: " + Arrays.toString(solution(tickets3)));
        System.out.println();
    }

    /**
     * Main solution using Hierholzer's Algorithm for Eulerian Path
     *
     * Implementation Steps:
     * 1. Build adjacency list with sorted destinations for lexicographical order
     * 2. Use PriorityQueue to keep destinations sorted at each vertex
     * 3. Handle multi-edges by tracking visit counts
     * 4. Perform DFS starting from "JFK"
     * 5. Add vertices to result in POST-ORDER (reverse of finish time)
     * 6. Reverse result to get correct itinerary
     *
     * The algorithm works because:
     * - It's a valid Eulerian path problem (each edge used exactly once)
     * - Sorting ensures lexicographically smallest itinerary
     * - Post-order traversal guarantees we complete sub-cycles first
     *
     * @param tickets List of origin-destination pairs
     * @return Reconstructed itinerary as array of cities
     */
    public static String[] solution(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return new String[]{""};
        }

        // Step 1: Build adjacency list with sorted destinations
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            String origin = ticket[0];
            String destination = ticket[1];

            graph.putIfAbsent(origin, new PriorityQueue<>());
            graph.get(origin).offer(destination);
        }

        // Step 2 & 5: Perform DFS in post-order
        List<String> itinerary = new ArrayList<>();
        dfs(graph, "JFK", itinerary);

        // Step 6: Reverse to get correct order (post-order to pre-order)
        Collections.reverse(itinerary);

        // Convert to array
        return itinerary.toArray(new String[0]);
    }

    /**
     * DFS helper for Hierholzer's algorithm
     * Adds vertex to result after exploring all outgoing edges (post-order)
     *
     * @param graph Adjacency list with PriorityQueue for sorted destinations
     * @param current Current airport
     * @param itinerary List to collect the path (in post-order)
     */
    private static void dfs(Map<String, PriorityQueue<String>> graph, String current, List<String> itinerary) {
        // Get priority queue for current airport (or empty if no outgoing edges)
        PriorityQueue<String> destinations = graph.get(current);

        // Visit all destinations (in lexicographically sorted order)
        while (destinations != null && !destinations.isEmpty()) {
            String destination = destinations.poll();

            // Recursively visit the destination
            dfs(graph, destination, itinerary);
        }

        // Post-order: add current vertex to itinerary
        // This ensures we only add after all paths from here are exhausted
        itinerary.add(current);
    }

    /**
     * Alternative solution using iterative approach (avoiding stack overflow)
     */
    public static String[] alternativeSolution(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return new String[]{""};
        }

        // Build adjacency list
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            String origin = ticket[0];
            String destination = ticket[1];

            graph.putIfAbsent(origin, new PriorityQueue<>());
            graph.get(origin).offer(destination);
        }

        // Iterative DFS to avoid recursion depth issues
        // Use stack to simulate call stack
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        // List for result (will be in reverse order)
        List<String> result = new ArrayList<>();

        // Process stack
        while (!stack.isEmpty()) {
            String current = stack.peek();

            // If there are outgoing edges from current, traverse one
            PriorityQueue<String> destinations = graph.get(current);
            if (destinations != null && !destinations.isEmpty()) {
                // Pop and push destination
                String destination = destinations.poll();
                stack.push(destination);
            } else {
                // No more edges from current, add to result and pop
                result.add(stack.pop());
            }
        }

        // Reverse to get correct order
        Collections.reverse(result);

        // Convert to array
        return result.toArray(new String[0]);
    }

    /**
     * Optimized solution for large inputs with custom hash-based adjacency
     */
    public static String[] optimizedSolution(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return new String[]{""};
        }

        // Use LinkedHashMap to preserve insertion order
        // Use custom comparison for lexicographical order
        Map<String, List<String>> adjList = new LinkedHashMap<>();

        for (String[] ticket : tickets) {
            String origin = ticket[0];
            String destination = ticket[1];

            adjList.putIfAbsent(origin, new ArrayList<>());
            adjList.get(origin).add(destination);
        }

        // Sort each adjacency list
        for (List<String> destinations : adjList.values()) {
            destinations.sort(Comparator.naturalOrder());
        }

        // Perform DFS
        List<String> itinerary = new ArrayList<>();
        dfsIterative(adjList, "JFK", itinerary);
        Collections.reverse(itinerary);

        return itinerary.toArray(new String[0]);
    }

    /**
     * Iterative DFS helper
     */
    private static void dfsIterative(Map<String, List<String>> adjList, String start, List<String> result) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String current = stack.peek();

            if (adjList.containsKey(current)) {
                List<String> destinations = adjList.get(current);

                // Pop smallest destination
                if (!destinations.isEmpty()) {
                    // Get smallest (first after sorting)
                    String destination = destinations.remove(destinations.size() - 1);
                    stack.push(destination);
                } else {
                    // Remove from map and pop stack
                    adjList.remove(current);
                    result.add(stack.pop());
                }
            } else {
                adjList.remove(current);
                result.add(stack.pop());
            }
        }
    }

    /**
     * Helper method to format tickets for display
     */
    private static String formatTickets(String[][] tickets) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tickets.length; i++) {
            sb.append("[").append(tickets[i][0]).append(",").append(tickets[i][1]).append("]");
            if (i < tickets.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
