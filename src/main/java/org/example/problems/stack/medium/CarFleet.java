package org.example.problems.stack.medium;

import java.util.*;

/**
 * Problem: Car Fleet
 * Topic: Stack
 * Level: Medium
 *
 * Problem Description:
 * Cars are traveling towards the target position. Each car has a position and speed.
 * A car fleet is a group of cars traveling at the same position and speed.
 * Cars arriving at the target form a fleet. If a car catches up to a fleet, it joins that fleet.
 * Return the number of fleets that will arrive at the target position.
 *
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 *
 * Video Explanation: https://www.youtube.com/watch?v=TPSiTAFhszA
 * LeetCode Problem Link: https://leetcode.com/problems/car-fleet/
 */
public class CarFleet {

    public static void main(String[] args) {
        System.out.println("=== CarFleet ===");
        System.out.println(solution(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3})); // 3
        System.out.println(alternativeSolution(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3})); // 3
    }

    /**
     * Solution: Stack-based approach.
     * Sort cars by starting position descending, then calculate time to reach target.
     * Use stack to track fleets - a car joins a fleet if its time is <= fleet's time.
     * Time: O(n log n) for sorting, Space: O(n)
     */
    public static int solution(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(time);

        int fleets = 0;
        double current = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (time[i] > current) {
                fleets++;
                current = time[i];
            }
        }
        return fleets;
    }

    /**
     * Alternative Solution: Using stack with sorted pairs.
     * Sort cars by position in descending order, then process with stack.
     * Time: O(n log n), Space: O(n)
     */
    public static int alternativeSolution(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort((a, b) -> b.position - a.position);

        Deque<Double> stack = new ArrayDeque<>();

        for (Car car : cars) {
            double time = (double) (target - car.position) / car.speed;
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }

    /**
     * Alternative Solution using Stream API for processing.
     * Time: O(n log n), Space: O(n)
     */
    public static int alternativeStreamSolution(int target, int[] position, int[] speed) {
        List<Double> times = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            times.add((double) (target - position[i]) / speed[i]);
        }

        times.sort(Comparator.reverseOrder());

        int fleets = 0;
        double current = 0;
        for (Double t : times) {
            if (t > current) {
                fleets++;
                current = t;
            }
        }
        return fleets;
    }

    private static class Car {
        int position;
        int speed;
        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
