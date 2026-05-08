package org.example.problems.string.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Encode and Decode Strings (LeetCode Premium)
 * Topic: String / Design
 * Level: Medium
 *
 * Problem Description:
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
 * and is decoded back to the original list of strings.
 *
 * The encoded string should be minimal (optimal encoding) and should not contain delimiters.
 *
 * Problem: How do you encode strings such that:
 * 1. You can encode any list of strings
 * 2. You can decode it back uniquely to get the original list
 * 3. Strings can contain any characters (including delimiters like commas, spaces, etc.)
 * 4. Strings can be empty
 *
 * Hint: Use a length-prefix approach. Encode the length of the string, followed by a delimiter, then the string itself.
 *
 * Example 1:
 * Input: ["Hello", "World"]
 * Expected Output (Encoded): "5#Hello5#World"
 * Expected Output (Decoded): ["Hello", "World"]
 *
 * Example 2:
 * Input: ["", "a", ""]
 * Expected Output (Encoded): "0#1#a0#"
 * Expected Output (Decoded): ["", "a", ""]
 *
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i].contains any possible character(s) in ASCII
 *
 * Video Explanation: https://www.youtube.com/watch?v=P5LQbpI4p_I
 * LeetCode Problem Link: https://leetcode.com/problems/encode-and-decode-strings/
 */
public class EncodeAndDecodeStrings {

    /**
     * Solution 1: Length-Prefix Encoding (Most Robust)
     *
     * Time Complexity: O(n) where n is total characters in all strings
     * Space Complexity: O(n) for the encoded string
     */
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public static List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int hashIndex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, hashIndex));
            String word = str.substring(hashIndex + 1, hashIndex + 1 + length);
            decoded.add(word);
            i = hashIndex + 1 + length;
        }
        return decoded;
    }

    /**
     * Solution 2: Chunked Length-Prefix Encoding with Fixed Width
     */
    public static String encodeAlternative(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(String.format("%04d", str.length())).append(str);
        }
        return encoded.toString();
    }

    public static List<String> decodeAlternative(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int length = Integer.parseInt(str.substring(i, i + 4));
            String word = str.substring(i + 4, i + 4 + length);
            decoded.add(word);
            i = i + 4 + length;
        }
        return decoded;
    }

    /**
     * Caesar Cipher Encryption Logic
     */
    public static String encryptString(String text, int shift) {
        return text.chars().map(c -> {
            if (Character.isUpperCase(c)) return 'A' + (c - 'A' + shift) % 26;
            else if (Character.isLowerCase(c)) return 'a' + (c - 'a' + shift) % 26;
            else return c;
        }).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }

    public static String decryptString(String text, int shift) {
        return encryptString(text, 26 - shift);
    }

    public static String encodeWithShift(List<String> strs, int shift) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            String encrypted = encryptString(str, shift);
            encoded.append(encrypted.length()).append("#").append(encrypted);
        }
        return encoded.toString();
    }

    public static List<String> decodeWithShift(String str, int shift) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int hashIndex = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, hashIndex));
            String encrypted = str.substring(hashIndex + 1, hashIndex + 1 + length);
            decoded.add(decryptString(encrypted, shift));
            i = hashIndex + 1 + length;
        }
        return decoded;
    }

    public static void main(String[] args) {
        System.out.println("=== EncodeAndDecodeStrings ===");

        List<String> strs1 = Arrays.asList("Hello", "World");
        System.out.println("Test 1 Encoded: " + encode(strs1));
        System.out.println("Test 1 Decoded: " + decode(encode(strs1)));

        List<String> strs2 = Arrays.asList("", "a", "");
        System.out.println("Test 2 Encoded: " + encode(strs2));
        System.out.println("Test 2 Decoded: " + decode(encode(strs2)));

        System.out.println("\n=== Caesar Cipher Tests ===");
        System.out.println("Encrypted 'Hello World' (shift 3): " + encryptString("Hello World", 3));
        System.out.println("Decrypted: " + decryptString(encryptString("Hello World", 3), 3));
    }
}
