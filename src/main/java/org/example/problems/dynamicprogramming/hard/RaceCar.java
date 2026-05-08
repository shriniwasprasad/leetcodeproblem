package org.example.problems.dynamicprogramming.hard;

import java.util.*;

/**
 * Problem: Race Car (LeetCode 818)
 * Topic: Dynamic Programming, BFS
 * Level: Hard
 *
 * Problem Description:
 * Your car starts at position 0 and speed +1 on an infinite number line.
 * Your car can go into negative positions. Your car drives automatically according to
 * a sequence of instructions 'A' (accelerate) and 'R' (reverse):
 *
 * - When you get an instruction 'A', your car does the following:
 *   position += speed
 *   speed *= 2
 *
 * - When you get an instruction 'R', your car does the following:
 *   If your speed is positive then speed = -1
 *   otherwise speed = 1
 *   (Your position stays the same.)
 *
 * Given a target position, return the length of the shortest sequence of instructions to get there.
 *
 * Example 1:
 * Input: target = 3
 * Output: 2
 * Explanation: The shortest instruction sequence is "AA".
 * Position 0 -> Speed 1 -> Position 1 -> Speed 2 -> Position 3
 *
 * Example 2:
 * Input: target = 6
 * Output: 5
 * Explanation: The shortest instruction sequence is "AAARA".
 * Position 0 -> 1 -> 3 -> 7 -> 7 (reverse) -> 8 (accelerate)
 *
 * Video Explanation: https://www.youtube.com/watch?v=TAXt_TkSNfw
 * LeetCode Problem Link: https://leetcode.com/problems/race-car/
 */
public class RaceCar {

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1 (DP): " + solution(3)); // Expected: 2

        // Test case 2
        System.out.println("Test 2 (DP): " + solution(6)); // Expected: 5

        // Test case 3
        System.out.println("Test 3 (DP): " + solution(5)); // Expected: 7

        // Test case 4
        System.out.println("Test 4 (DP): " + solution(10)); // Expected: 7

        // Alternative solution tests
        System.out.println("\nAlternative Solution (BFS) Tests:");
        System.out.println("Test 1: " + alternativeSolution(3)); // Expected: 2
        System.out.println("Test 2: " + alternativeSolution(6)); // Expected: 5
        System.out.println("Test 3: " + alternativeSolution(10)); // Expected: 7
    }

    /**
     * Dynamic Programming approach.
     * For target n:
     * 1. If n = 2^k - 1, we can reach it in k steps (all A's)
     * 2. Otherwise, we have two options:
     *    - Go past target and reverse: A...AR... (k A's, then R, then solve for 2^k - 1 - n)
     *    - Stop short and reverse: A...RAR...A... (k-1 A's, R, go back m steps, R, then solve for remainder)
     *
     * Time Complexity: O(target^2)
     * Space Complexity: O(target)
     *
     * @param target the target position
     * @return minimum number of instructions
     */
    public static int solution(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            int n = Integer.toBinaryString(i).length(); // Number of bits

            // Check if i is exactly 2^k - 1 (like 1, 3, 7, 15, ...)
            if ((1 << n) - 1 == i) {
                dp[i] = n;
            } else {
                // Option 1: Go past target with n A's, then reverse and solve for remainder
                // Example: for target 5, n=3, go to 7 (111), reverse, solve for 7-5=2
                dp[i] = dp[(1 << n) - 1 - i] + n + 1;

                // Option 2: Stop short with n-1 A's, reverse, go back m steps, reverse, continue
                // Try all possible m values (number of steps to go back)
                for (int m = 0; m < n - 1; m++) {
                    int positionAfterGoingBack = i - ((1 << (n - 1)) - (1 << m));
                    if (positionAfterGoingBack >= 0 && positionAfterGoingBack < i) {
                        dp[i] = Math.min(dp[i], dp[n - 1] + 1 + dp[m] + 1 + dp[positionAfterGoingBack]);
                    }
                }
            }
        }

        return dp[target];
    }

    /**
     * BFS approach - explore all possible (position, speed) states.
     * Each level of BFS represents one instruction (A or R).
     * Time Complexity: O(target^2)
     * Space Complexity: O(target^2)
     *
     * @param target the target position
     * @return minimum number of instructions
     */
    public static int alternativeSolution(int target) {
        // BFS: state = (position, speed)
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 1});
        visited.add("0,1");

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] state = queue.poll();
                int pos = state[0];
                int speed = state[1];

                // Found target
                if (pos == target) {
                    return steps;
                }

                // Skip if we've gone too far
                if (Math.abs(pos) > 2 * target) {
                    continue;
                }

                // Option 1: Accelerate
                int newPos = pos + speed;
                int newSpeed = speed * 2;
                String newStateKey = newPos + "," + newSpeed;

                if (!visited.contains(newStateKey) && Math.abs(newPos) <= 2 * target) {
                    visited.add(newStateKey);
                    queue.offer(new int[]{newPos, newSpeed});
                }

                // Option 2: Reverse
                int newSpeedRev = (speed > 0) ? -1 : 1;
                String newStateKeyRev = pos + "," + newSpeedRev;

                if (!visited.contains(newStateKeyRev)) {
                    visited.add(newStateKeyRev);
                    queue.offer(new int[]{pos, newSpeedRev});
                }
            }

            steps++;
        }

        return -1; // Should never reach here for valid input
    }
}
