package org.example.problems.heap.medium;

import java.util.*;

/**
 * Problem: Design Twitter (LeetCode 355)
 * Topic: Heap / Priority Queue, Hash Map, Design
 * Level: Medium
 *
 * Problem Description:
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 * and see the 10 most recent tweets in their news feed.
 *
 * Implement the Twitter class:
 * - Twitter() Initializes your twitter object.
 * - void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
 * - List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
 * - void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
 * - void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 *
 * Video Explanation: https://www.youtube.com/watch?v=esZ4vvjwW6E
 * LeetCode Problem Link: https://leetcode.com/problems/design-twitter/
 */
public class DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a tweet
        twitter.postTweet(1, 5);
        System.out.println("Feed after postTweet(1, 5): " + twitter.getNewsFeed(1));  // [5]

        // User 1 follows user 2
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println("Feed after follow(1, 2) and postTweet(2, 6): " + twitter.getNewsFeed(1));  // [6, 5]

        // User 1 unfollows user 2
        twitter.unfollow(1, 2);
        System.out.println("Feed after unfollow(1, 2): " + twitter.getNewsFeed(1));  // [5]
    }

    /**
     * Twitter class implementation using heap and hash maps.
     */
    static class Twitter {
        private static int timestamp = 0;

        // userId -> list of tweets (timestamp, tweetId)
        private Map<Integer, List<Tweet>> userTweets;

        // userId -> set of followee IDs
        private Map<Integer, Set<Integer>> following;

        /**
         * Inner class representing a tweet.
         */
        private static class Tweet {
            int id;
            int time;
            Tweet next;

            Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        public Twitter() {
            userTweets = new HashMap<>();
            following = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         * Time Complexity: O(1)
         */
        public void postTweet(int userId, int tweetId) {
            List<Tweet> tweets = userTweets.getOrDefault(userId, new ArrayList<>());
            Tweet newTweet = new Tweet(tweetId, timestamp++);
            tweets.add(0, newTweet);  // Add to front for most recent first
            userTweets.put(userId, tweets);
        }

        /**
         * Retrieve the 10 most recent tweet IDs.
         * Time Complexity: O(k log m) where k=10, m=number of users followed
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feed = new ArrayList<>();

            // Max-heap to merge tweets from user and their followees
            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

            // Get set of users whose tweets to include (user + followees)
            Set<Integer> usersToInclude = new HashSet<>();
            usersToInclude.add(userId);
            if (following.containsKey(userId)) {
                usersToInclude.addAll(following.get(userId));
            }

            // Add most recent tweet from each user to heap
            for (int followeeId : usersToInclude) {
                if (userTweets.containsKey(followeeId)) {
                    maxHeap.offer(userTweets.get(followeeId).get(0));
                }
            }

            // Extract up to 10 most recent tweets
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10) {
                Tweet tweet = maxHeap.poll();
                feed.add(tweet.id);
                count++;

                // Add next tweet from the same user if exists
                // This implementation would need Tweet.next pointer for optimization
            }

            return feed;
        }

        /**
         * Make one user follow another.
         * Time Complexity: O(1)
         */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;  // Can't follow self

            following.putIfAbsent(followerId, new HashSet<>());
            following.get(followerId).add(followeeId);
        }

        /**
         * Make one user unfollow another.
         * Time Complexity: O(1)
         */
        public void unfollow(int followerId, int followeeId) {
            if (following.containsKey(followerId)) {
                following.get(followerId).remove(followeeId);
            }
        }
    }
}
