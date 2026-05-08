package org.example.problems.backtracking.medium;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: Palindrome Partitioning
 * Topic: Backtracking
 * Level: Medium
 *
 * Problem Description:
 * Given a string s, partition s such that every substring in the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println("=== PalindromePartitioning ===");
        String s = "aab";
        System.out.println("String: " + s);
        System.out.println("Result: " + solution(s));
        System.out.println("Alternative Result: " + alternativeSolution(s));
    }

    public static List<List<String>> solution(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> currentList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                String substring = s.substring(start, end);
                currentList.add(substring);
                backtrack(result, currentList, s, end);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    public static List<List<String>> alternativeSolution(String s) {
        return backtrackStream(s, 0);
    }

    private static List<List<String>> backtrackStream(String s, int start) {
        if (start == s.length()) {
            List<List<String>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        return IntStream.range(start + 1, s.length() + 1)
            .filter(end -> isPalindrome(s, start, end - 1))
            .mapToObj(end -> {
                String substring = s.substring(start, end);
                return backtrackStream(s, end).stream()
                    .map(list -> {
                        List<String> newList = new ArrayList<>();
                        newList.add(substring);
                        newList.addAll(list);
                        return newList;
                    })
                    .collect(Collectors.toList());
            })
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}
