package string.medium;

import java.util.*;

/**
 * Problem: Group Anagrams
 * Topic: String
 * Level: Medium
 *
 * Problem Description:
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Hint: Use a HashMap where the key is the sorted version of the word, and the value is a list of all words that sort to that key.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Expected Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Expected Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Expected Output: [["a"]]
 *
 * Constraints:
 * - 1 <= strs.length() <= 10^4
 * - 0 <= strs[i].length() <= 100
 * - strs[i] consists of lowercase English letters
 *
 * Video Explanation: https://www.youtube.com/watch?v=dEMcIpBOHpg
 * LeetCode Problem Link: https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println("=== GroupAnagrams ===");
        
        // Test case 1
        List<List<String>> result1 = (List<List<String>>) solution(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("Test 1: " + result1);
        
        // Test case 2
        List<List<String>> result2 = (List<List<String>>) solution(new String[]{""});
        System.out.println("Test 2: " + result2);
        
        System.out.println("\nAlternative Solution:");
        List<List<String>> result3 = (List<List<String>>) alternativeSolution(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("Test 1: " + result3);
    }

    /**
     * Solution 1: Sorted Keys Approach (Most Intuitive)
     * 
     * Time Complexity: O(n * k log k) where n is number of strings and k is max length
     * Space Complexity: O(n * k) for the map
     * 
     * Algorithm:
     * - Sort each word's characters
     * - Use sorted word as key in HashMap
     * - All anagrams will have the same sorted key
     * - Group words by their sorted key
     * 
     * How it works:
     * "eat" -> sort -> "aet" (key)
     * "tea" -> sort -> "aet" (key) - same key!
     * "ate" -> sort -> "aet" (key) - same key!
     * "tan" -> sort -> "ant" (key) - different key
     * "nat" -> sort -> "ant" (key) - same as tan
     * "bat" -> sort -> "abt" (key) - different key
     * 
     * Result: {aet: [eat, tea, ate], ant: [tan, nat], abt: [bat]}
     */
    public static Object solution(Object input) {
        String[] strs = (String[]) input;
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort characters in the word
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add word to its anagram group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        // Return all groups as a list
        return new ArrayList<>(map.values());
    }

    /**
     * Solution 2: Character Count Keys Approach (More Efficient)
     * 
     * Time Complexity: O(n * k) where n is number of strings and k is max length
     * Space Complexity: O(n * k) for the map
     * 
     * Algorithm:
     * - Count frequency of characters in each word
     * - Use character count as key (e.g., "a1e1t1" for "eat")
     * - All anagrams will have the same character count key
     * - Group words by their count key
     * 
     * Advantage: Better than sorting when character set is small
     * Faster since counting is O(k) vs sorting which is O(k log k)
     * 
     * How it works:
     * "eat" -> count -> "a1e1t1" (key)
     * "tea" -> count -> "a1e1t1" (key) - same key!
     * "ate" -> count -> "a1e1t1" (key) - same key!
     * "tan" -> count -> "a1n1t1" (key)
     * "nat" -> count -> "a1n1t1" (key) - same as tan
     */
    public static Object alternativeSolution(Object input) {
        String[] strs = (String[]) input;
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Count character frequencies
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Convert count array to string key
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    key.append((char) ('a' + i));
                    key.append(count[i]);
                }
            }
            
            // Add word to its anagram group
            String keyStr = key.toString();
            map.putIfAbsent(keyStr, new ArrayList<>());
            map.get(keyStr).add(str);
        }
        
        // Return all groups as a list
        return new ArrayList<>(map.values());
    }
}
