package org.example.problems.design.easy;

import java.util.*;

/**
 * Problem: Logger Rate Limiter (LeetCode 359)
 * Topic: Design, Hash Table
 * Level: Easy
 *
 * Problem Description:
 * Design a logger system that receives a stream of messages along with their timestamps.
 * A unique message should be printed only within every 10 seconds (i.e. a message printed
 * at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 *
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 *
 * Implement the Logger class:
 * - Logger() Initializes the logger object.
 * - bool shouldPrintMessage(int timestamp, String message) Returns true if the message should
 *   be printed in the given timestamp, otherwise returns false.
 *
 * Example:
 * Input:
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage",
 *  "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output:
 * [null, true, true, false, false, false, true]
 *
 * LeetCode Problem Link: https://leetcode.com/problems/logger-rate-limiter/
 */
public class LoggerRateLimiter {

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println("shouldPrintMessage(1, \"foo\"): " + logger.shouldPrintMessage(1, "foo"));   // true
        System.out.println("shouldPrintMessage(2, \"bar\"): " + logger.shouldPrintMessage(2, "bar"));   // true
        System.out.println("shouldPrintMessage(3, \"foo\"): " + logger.shouldPrintMessage(3, "foo"));   // false
        System.out.println("shouldPrintMessage(8, \"bar\"): " + logger.shouldPrintMessage(8, "bar"));   // false
        System.out.println("shouldPrintMessage(10, \"foo\"): " + logger.shouldPrintMessage(10, "foo")); // false
        System.out.println("shouldPrintMessage(11, \"foo\"): " + logger.shouldPrintMessage(11, "foo")); // true
    }

    /**
     * Logger class implementation using Hash Map.
     */
    static class Logger {
        // Map to store message -> next allowed timestamp
        private Map<String, Integer> messageTimestamps;

        public Logger() {
            messageTimestamps = new HashMap<>();
        }

        /**
         * Determines if a message should be printed at the given timestamp.
         * Time Complexity: O(1)
         * Space Complexity: O(n) where n is number of unique messages
         *
         * @param timestamp the current timestamp
         * @param message the message to potentially print
         * @return true if message should be printed, false otherwise
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            // If message hasn't been seen before
            if (!messageTimestamps.containsKey(message)) {
                messageTimestamps.put(message, timestamp + 10);
                return true;
            }

            // Get the next allowed timestamp for this message
            int nextAllowedTime = messageTimestamps.get(message);

            // If current timestamp is >= next allowed time
            if (timestamp >= nextAllowedTime) {
                // Update the next allowed time
                messageTimestamps.put(message, timestamp + 10);
                return true;
            }

            // Too soon to print
            return false;
        }
    }
}
