# LeetCode Problems in Java

A comprehensive collection of LeetCode problems solved in Java, organized by category and difficulty level.

## Project Overview

This project contains **189 LeetCode problems** implemented in Java, covering:
- Array & Hashing
- String Manipulation
- Linked List
- Tree & Binary Search Tree
- Graph & Depth-First Search
- Dynamic Programming
- Heap & Priority Queue
- Stack
- Matrix
- Backtracking
- Sorting
- Interval
- Binary Search
- Bit Manipulation
- Greedy Algorithms
- Design Problems

Each problem includes:
- Problem description
- Input/Output examples
- Solution with time/space complexity analysis
- Video explanation (where available)
- LeetCode problem link

## Problem Count Summary

| # | Section | Problems |
|---|---------|----------|
| 1 | Array & Hashing | 20 |
| 2 | String | 21 |
| 3 | Linked List | 13 |
| 4 | Stack | 9 |
| 5 | Sorting | 5 |
| 6 | Tree | 24 |
| 7 | Binary Search | 4 |
| 8 | Backtracking | 7 |
| 9 | Bit Manipulation | 3 |
| 10 | Binary Bit Manipulation | 4 |
| 11 | Design | 4 |
| 12 | Dynamic Programming | 19 |
| 13 | Graph | 22 |
| 14 | Hashing | 3 |
| 15 | Heap | 9 |
| 16 | Interval | 7 |
| 17 | Matrix | 10 |
| 18 | Greedy | 5 |
| | **Total** | **189** |

## Setup Instructions (Windows)

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Optional: IntelliJ IDEA or VS Code

### Installing Java
1. Download JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [Adoptium](https://adoptium.net/)
2. Install and add to PATH
3. Verify installation:
   ```powershell
   java -version
   ```

### Compiling and Running

#### Option 1: Run Individual Problem
```powershell
# Navigate to project root
cd D:\inter\leetcode\leetcodeproblem

# Compile
javac src/main/java/org/example/problems/array/easy/TwoSum.java

# Run
java -cp src/main/java org.example.problems.array.easy.TwoSum
```

#### Option 2: Run from IDE
1. Open project folder in IntelliJ IDEA or VS Code
2. Navigate to the problem file you want to run
3. Click the run button or press `Shift+F10`

#### Option 3: Using Maven (if configured)
```powershell
mvn compile
mvn exec:java -Dexec.mainClass="org.example.problems.array.easy.TwoSum"
```

### Running Individual Problems
Each problem file contains a `main()` method with test cases. To run any problem:

```powershell
# Example: Run Two Sum problem
java -cp src/main/java org.example.problems.array.easy.TwoSum

# Example: Run Maximum Subarray problem
java -cp src/main/java org.example.problems.array.medium.MaximumSubarray
```

---

## Problems by Category - Table of Contents

### 1. Array & Hashing

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Best Time to Buy and Sell Stock](src/main/java/org/example/problems/array/easy/BestTimeToBuyAndSellStock.java) | You are given an array of stock prices. Maximize profit by choosing a single day to buy and a different day in the future to sell. | prices = {7, 1, 5, 3, 6, 4} | 5 (buy at 1, sell at 6) | O(n) | [LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) \| [Video](https://www.youtube.com/watch?v=CCQBvgPages) |
| 2 | Easy | [Contains Duplicate](src/main/java/org/example/problems/array/easy/ContainsDuplicate.java) | Given an integer array, return true if any value appears at least twice, false if every element is distinct. | nums = {1, 2, 3, 1} | true | O(n) | [LeetCode](https://leetcode.com/problems/contains-duplicate/) \| [Video](https://www.youtube.com/watch?v=c_q_Pc2yg_0) |
| 3 | Easy | [Contains Duplicate II](src/main/java/org/example/problems/array/easy/ContainsDuplicateIi.java) | Given an integer array and integer k, return true if there are two distinct indices i and j where nums[i] == nums[j] and abs(i - j) <= k. | nums = {1, 2, 3, 1}, k = 3 | true | O(n) | [LeetCode](https://leetcode.com/problems/contains-duplicate-ii/) \| [Video](https://www.youtube.com/watch?v=Te_MCY4uG-M) |
| 4 | Easy | [Two Sum](src/main/java/org/example/problems/array/easy/TwoSum.java) | Given an array of integers and a target, return indices of two numbers that add up to target. Exactly one solution exists. | nums = {2, 7, 11, 15}, target = 9 | {0, 1} | O(n) | [LeetCode](https://leetcode.com/problems/two-sum/) \| [Video](https://www.youtube.com/watch?v=BQ2IJ-fouJ4) |
| 5 | Easy | [Verifying an Alien Dictionary](src/main/java/org/example/problems/array/easy/VerifyingAnAlienDictionary.java) | Given an array of strings and a custom order, return true if strings are sorted lexicographically according to that order. | words = ["hello","leetcode"], order = "abcdefghijklmnopqrstuvwxyz" | true | O(n) | [LeetCode](https://leetcode.com/problems/verifying-an-alien-dictionary/) \| [Video](https://www.youtube.com/watch?v=8NoyVvm1v88) |
| 6 | Medium | [Container With Most Water](src/main/java/org/example/problems/array/medium/ContainerWithMostWater.java) | Given n non-negative integers representing vertical lines, find two lines that with x-axis form a container holding the most water. | height = {1, 8, 6, 2, 5, 4, 8, 3, 7} | 49 | O(n) | [LeetCode](https://leetcode.com/problems/container-with-most-water/) \| [Video](https://www.youtube.com/watch?v=wi8fqhNoV-Y) |
| 7 | Medium | [Find First and Last Position of Element in Sorted Array](src/main/java/org/example/problems/array/medium/FindFirstAndLastPositionOfElementInSortedArray.java) | Given a sorted array and target value, find the starting and ending position of target. | nums = {5, 7, 7, 8, 8, 10}, target = 8 | {3, 4} | O(log n) | [LeetCode](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) \| [Video](https://www.youtube.com/watch?v=aPD6g96fRO4) |
| 8 | Medium | [Find Minimum in Rotated Sorted Array](src/main/java/org/example/problems/array/medium/FindMinimumInRotatedSortedArray.java) | Given a rotated sorted array with unique elements, return the minimum element. | nums = {3, 4, 5, 1, 2} | 1 | O(log n) | [LeetCode](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) \| [Video](https://www.youtube.com/watch?v=Dr69TSfv9JI) |
| 9 | Medium | [Maximum Product Subarray](src/main/java/org/example/problems/array/medium/MaximumProductSubarray.java) | Given an integer array, find the subarray with the largest product and return the product. | nums = {2, 3, -2, 4} | 6 | O(n) | [LeetCode](https://leetcode.com/problems/maximum-product-subarray/) \| [Video](https://www.youtube.com/watch?v=OuRQ_TCCjsU) |
| 10 | Medium | [Maximum Subarray](src/main/java/org/example/problems/array/medium/MaximumSubarray.java) | Given an integer array, find the subarray with the largest sum and return its sum. | nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4} | 6 | O(n) | [LeetCode](https://leetcode.com/problems/maximum-subarray/) \| [Video](https://www.youtube.com/watch?v=nr2djEYM7_A) |
| 11 | Medium | [3 Sum](src/main/java/org/example/problems/array/medium/N3Sum.java) | Given an integer array, return all triplets [nums[i], nums[j], nums[k]] such that i != j != k and nums[i] + nums[j] + nums[k] == 0. | nums = {-1, 0, 1, 2, -1, -4} | [[-1, -1, 2], [-1, 0, 1]] | O(n²) | [LeetCode](https://leetcode.com/problems/3-sum/) \| [Video](https://www.youtube.com/watch?v=wtloSzFYvho) |
| 12 | Medium | [Next Permutation](src/main/java/org/example/problems/array/medium/NextPermutation.java) | Given an array of integers, find the next permutation of the array in place. | nums = {1, 2, 3} | [1, 3, 2] | O(n) | [LeetCode](https://leetcode.com/problems/next-permutation/) \| [Video](https://www.youtube.com/watch?v=oc3OOtGmH6U) |
| 13 | Medium | [Product of Array Except Self](src/main/java/org/example/problems/array/medium/ProductOfArrayExceptSelf.java) | Given an integer array, return an array where answer[i] equals product of all elements except nums[i]. | nums = {1, 2, 3, 4} | {24, 12, 8, 6} | O(n) | [LeetCode](https://leetcode.com/problems/product-of-array-except-self/) \| [Video](https://www.youtube.com/watch?v=UxmLwxH-lhM) |
| 14 | Medium | [Remove Duplicates from Sorted Array](src/main/java/org/example/problems/array/medium/RemoveDuplicatesFromSortedArray.java) | Given a sorted array, remove duplicates in-place so each unique element appears only once. | nums = {1, 1, 2} | 2 | O(n) | [LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) \| [Video](https://www.youtube.com/watch?v=0F49FLuzScU) |
| 15 | Medium | [Search in Rotated Sorted Array](src/main/java/org/example/problems/array/medium/SearchInRotatedSortedArray.java) | Given a rotated sorted array and target, return the index of target if present, or -1 if not. | nums = {4, 5, 6, 7, 0, 1, 2}, target = 0 | 4 | O(log n) | [LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array/) \| [Video](https://www.youtube.com/watch?v=sE_4DzVc71w) |
| 16 | Medium | [Top K Frequent Elements](src/main/java/org/example/problems/array/medium/TopKFrequentElements.java) | Given an integer array and integer k, return the k most frequent elements. | nums = {1, 1, 1, 2, 2, 3}, k = 2 | {1, 2} | O(n) | [LeetCode](https://leetcode.com/problems/top-k-frequent-elements/) \| [Video](https://www.youtube.com/watch?v=QubWUx59QCk) |
| 17 | Medium | [Two Sum II - Input Array Is Sorted](src/main/java/org/example/problems/array/medium/TwoSumIiInputArrayIsSorted.java) | Given a 1-indexed sorted array, find two numbers that add up to a target (return 1-indexed indices). | nums = {2, 7, 11, 15}, target = 9 | [1, 2] | O(n) | [LeetCode](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) \| [Video](https://www.youtube.com/watch?v=c9ywRRJcP1Y) |
| 18 | Medium | [Valid Sudoku](src/main/java/org/example/problems/array/medium/ValidSudoku.java) | Determine if a 9x9 Sudoku board is valid. Validate rows, columns, and 3x3 sub-boxes. | 9x9 board | true/false | O(1) | [LeetCode](https://leetcode.com/problems/valid-sudoku/) \| [Video](https://www.youtube.com/watch?v=q2fl7lUkc8o) |
| 19 | Hard | [Median of Two Sorted Arrays](src/main/java/org/example/problems/array/hard/MedianOfTwoSortedArrays.java) | Given two sorted arrays of size m and n, return the median of the two sorted arrays. | nums1 = {1, 3}, nums2 = {2} | 2.0 | O(log(min(m,n))) | [LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays/) \| [Video](https://www.youtube.com/watch?v=LRM4qiHLYCE) |
| 20 | Hard | [Trapping Rain Water](src/main/java/org/example/problems/array/hard/TrappingRainWater.java) | Given n non-negative integers representing elevation map, compute how much water can be trapped after raining. | height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1} | 6 | O(n) | [LeetCode](https://leetcode.com/problems/trapping-rain-water/) \| [Video](https://www.youtube.com/watch?v=AFl_VxaO_F0) |

---

### 2. String

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [FizzBuzz](src/main/java/org/example/problems/string/easy/FizzBuzz.java) | Given integer n, return FizzBuzz sequence. Divisible by 3→"Fizz", by 5→"Buzz", by both→"FizzBuzz", else number as string. | n = 15 | ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"] | O(n) | [LeetCode](https://leetcode.com/problems/fizz-buzz/) \| [Video](https://www.youtube.com/watch?v=E3eO7jTFElU) |
| 2 | Easy | [Is Subsequence](src/main/java/org/example/problems/string/easy/IsSubsequence.java) | Given strings s and t, return true if s is a subsequence of t (characters in same order after deleting some). | s = "abc", t = "ahbgdc" | true | O(n) | [LeetCode](https://leetcode.com/problems/is-subsequence/) \| [Video](https://www.youtube.com/watch?v=I1yvLEkI6oo) |
| 3 | Easy | [Longest Common Prefix](src/main/java/org/example/problems/string/easy/LongestCommonPrefix.java) | Find the longest common prefix string amongst an array of strings. Return "" if no common prefix. | strs = ["flower","flow","flight"] | "fl" | O(n*m) | [LeetCode](https://leetcode.com/problems/longest-common-prefix/) \| [Video](https://www.youtube.com/watch?v=PWoIZxcamsQ) |
| 4 | Easy | [Palindrome Linked List](src/main/java/org/example/problems/string/easy/PalindromeLinkedList.java) | Given head of singly linked list, return true if it reads the same forward and backward. | head = [1,2,2,1] | true | O(n) | [LeetCode](https://leetcode.com/problems/palindrome-linked-list/) \| [Video](https://www.youtube.com/watch?v=uGGAJxeXa4U) |
| 5 | Easy | [Remove Palindromic Subsequences](src/main/java/org/example/problems/string/easy/RemovePalindromicSubsequences.java) | Given string of only 'a' and 'b', return minimum steps to make it empty by removing palindromic subsequences. | s = "ababa" | 1 | O(n) | [LeetCode](https://leetcode.com/problems/remove-palindromic-subsequences/) \| [Video](https://www.youtube.com/watch?v=nP7FfNO0bj8c) |
| 6 | Easy | [Reverse Vowels of a String](src/main/java/org/example/problems/string/easy/ReverseVowelsOfAString.java) | Reverse only the vowels ('a','e','i','o','u') in a string, consonants stay in position. | s = "hello" | "holle" | O(n) | [LeetCode](https://leetcode.com/problems/reverse-vowels-of-a-string/) \| [Video](https://www.youtube.com/watch?v=bjKt6xj9VgM) |
| 7 | Easy | [Valid Anagram](src/main/java/org/example/problems/string/easy/ValidAnagram.java) | Given two strings s and t, return true if t is an anagram of s (same letters, different order). | s = "anagram", t = "nagaram" | true | O(n) | [LeetCode](https://leetcode.com/problems/valid-anagram/) \| [Video](https://www.youtube.com/watch?v=qyQni3rz-ko) |
| 8 | Easy | [Valid Palindrome](src/main/java/org/example/problems/string/easy/ValidPalindrome.java) | A phrase is palindrome if after converting to lowercase and removing non-alphanumeric, it reads same forward and backward. | s = "A man, a plan, a canal: Panama" | true | O(n) | [LeetCode](https://leetcode.com/problems/valid-palindrome/) \| [Video](https://www.youtube.com/watch?v=MFPmKyThyHk) |
| 9 | Easy | [Valid Parentheses](src/main/java/org/example/problems/string/easy/ValidParentheses.java) | Given string with '(', ')', '{', '}', '[', ']', determine if valid: same type brackets, correctly nested and closed. | s = "([{}])" | true | O(n) | [LeetCode](https://leetcode.com/problems/valid-parentheses/) \| [Video](https://www.youtube.com/watch?v=D4l9TK0tWcI) |
| 10 | Medium | [Encode and Decode Strings](src/main/java/org/example/problems/string/medium/EncodeAndDecodeStrings.java) | Design algorithms to encode a list of strings to a string and decode it back. Handle any ASCII characters including delimiters. | ["Hello", "World"] | ["Hello", "World"] | O(n) | [LeetCode](https://leetcode.com/problems/encode-and-decode-strings/) \| [Video](https://www.youtube.com/watch?v=P5LQbpI4p_I) |
| 11 | Medium | [Group Anagrams](src/main/java/org/example/problems/string/medium/GroupAnagrams.java) | Given an array of strings, group the anagrams together. Return answer in any order. | strs = ["eat","tea","tan","ate","nat","bat"] | [["bat"],["nat","tan"],["ate","eat","tea"]] | O(n*k log k) | [LeetCode](https://leetcode.com/problems/group-anagrams/) \| [Video](https://www.youtube.com/watch?v=dEMcIpBOHpg) |
| 12 | Medium | [Letter Combinations of a Phone Number](src/main/java/org/example/problems/string/medium/LetterCombinationsOfAPhoneNumber.java) | Given digits 2-9, return all possible letter combinations like on telephone buttons. | digits = "23" | ["ad","ae","af","bd","be","bf","cd","ce","cf"] | O(4^n) | [LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) \| [Video](https://www.youtube.com/watch?v=dmYiOfy8a-k) |
| 13 | Medium | [Longest Palindromic Substring](src/main/java/org/example/problems/string/medium/LongestPalindromicSubstring.java) | Given a string, find the longest substring that is a palindrome. | s = "babad" | "bab" or "aba" | O(n²) | [LeetCode](https://leetcode.com/problems/longest-palindromic-substring/) \| [Video](https://www.youtube.com/watch?v=92KOT17h8zw) |
| 14 | Medium | [Longest Repeating Character Replacement](src/main/java/org/example/problems/string/medium/LongestRepeatingCharacterReplacement.java) | Given string s and integer k, change any character at most k times. Return length of longest substring with same letter. | s = "ABAB", k = 2 | 4 | O(n) | [LeetCode](https://leetcode.com/problems/longest-repeating-character-replacement/) \| [Video](https://www.youtube.com/watch?v=FYyWsqFjkZk) |
| 15 | Medium | [Longest Substring Without Repeating Characters](src/main/java/org/example/problems/string/medium/LongestSubstringWithoutRepeatingCharacters.java) | Find length of longest substring without repeating characters. | s = "abcabcbb" | 3 | O(n) | [LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/) \| [Video](https://www.youtube.com/watch?v=RMQ-gRQAY0o) |
| 16 | Medium | [Palindromic Substrings](src/main/java/org/example/problems/string/medium/PalindromicSubstrings.java) | Given a string, return the total number of palindromic substrings. | s = "aaa" | 6 | O(n²) | [LeetCode](https://leetcode.com/problems/palindromic-substrings/) \| [Video](https://www.youtube.com/watch?v=WfkVe8egZbU) |
| 17 | Medium | [Permutation In String](src/main/java/org/example/problems/string/medium/PermutationInString.java) | Given two strings s1 and s2, return true if s2 contains a permutation of s1 (same character frequencies in a substring). | s1 = "ab", s2 = "eidbaooo" | true | O(n) | [LeetCode](https://leetcode.com/problems/permutation-in-string/) \| [Video](https://www.youtube.com/watch?v=mIorIJvhl8E) |
| 18 | Medium | [Reverse Words in a String](src/main/java/org/example/problems/string/medium/ReverseWordsInAString.java) | Reverse the order of words in a string (separated by spaces, one or more). Return words in reverse order concatenated by single space. | s = "the sky is blue" | "blue is sky the" | O(n) | [LeetCode](https://leetcode.com/problems/reverse-words-in-a-string/) \| [Video](https://www.youtube.com/watch?v=WfkVe8egZbU) |
| 19 | Hard | [Minimum Window Substring](src/main/java/org/example/problems/string/hard/MinimumWindowSubstring.java) | Given strings s and t, return minimum window in s that contains all characters in t. If no window exists, return "". | s = "ADOBECODEBANC", t = "ABC" | "BANC" | O(n) | [LeetCode](https://leetcode.com/problems/minimum-window-substring/) \| [Video](https://www.youtube.com/watch?v=tMx5JZSBWIE) |
| 20 | Hard | [Sliding Window Maximum](src/main/java/org/example/problems/string/hard/SlidingWindowMaximum.java) | Given array nums and window size k, return the maximum value in each window as it slides from left to right. | nums = {1,3,-1,-3,5,3,6,7}, k = 3 | [3,3,5,5,6,7] | O(n) | [LeetCode](https://leetcode.com/problems/sliding-window-maximum/) \| [Video](https://www.youtube.com/watch?v=GIYk1wit12k) |
| 21 | Hard | [Text Justification](src/main/java/org/example/problems/string/hard/TextJustification.java) | Given words and maxWidth, format text so each line has exactly maxWidth characters with even space distribution. | words = ["This","is","an","example","of","text","justification."], maxWidth = 16 | "This    is    an" | O(n*m) | [LeetCode](https://leetcode.com/problems/text-justification/) \| [Video](https://www.youtube.com/watch?v=Pf_1Ox9ud_w) |

---

### 3. Linked List

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Detect Cycle in a Linked List](src/main/java/org/example/problems/linkedlist/easy/DetectCycleInALinkedList.java) | Given head of linked list, determine if it has a cycle (node reachable by following next pointer continuously). | head = [3,2,0,-4], pos = 1 | true | O(n) | [LeetCode](https://leetcode.com/problems/linked-list-cycle/) \| [Video](https://www.youtube.com/watch?v=k-gTqlOBT1g) |
| 2 | Easy | [LinkedList Cycle](src/main/java/org/example/problems/linkedlist/easy/LinkedListCycle.java) | Given head of linked list, determine if it has a cycle using Floyd's algorithm or hash set. | head = [3,2,0,-4], pos = 1 | true | O(n) | [LeetCode](https://leetcode.com/problems/linked-list-cycle/) \| [Video](https://www.youtube.com/watch?v=k-gTqlOBT1g) |
| 3 | Easy | [Merge Two Sorted Lists](src/main/java/org/example/problems/linkedlist/easy/MergeTwoSortedLists.java) | Merge two sorted linked lists in sorted order and return the merged list. | l1 = [1,2,4], l2 = [1,3,4] | [1,1,2,3,4,4] | O(m+n) | [LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/) \| [Video](https://www.youtube.com/watch?v=Bwymxn-n6XA) |
| 4 | Easy | [Middle of the Linked List](src/main/java/org/example/problems/linkedlist/easy/MiddleOfTheLinkedlist.java) | Given head of singly linked list, return the middle node. If two middle nodes, return second middle. | head = [1,2,3,4,5] | [3,4,5] | O(n) | [LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/) \| [Video](https://www.youtube.com/watch?v=s7cHxJBuhjg) |
| 5 | Easy | [Reverse A Linked List](src/main/java/org/example/problems/linkedlist/easy/ReverseALinkedList.java) | Given head of singly linked list, reverse the list and return the reversed list. | head = [1,2,3,4,5] | [5,4,3,2,1] | O(n) | [LeetCode](https://leetcode.com/problems/reverse-linked-list/) \| [Video](https://www.youtube.com/watch?v=FHhItaCZ2pE) |
| 6 | Easy | [Reverse Linked List](src/main/java/org/example/problems/linkedlist/easy/ReverseLinkedList.java) | Reverse a singly linked list iteratively or recursively. | head = [1,2,3] | [3,2,1] | O(n) | [LeetCode](https://leetcode.com/problems/reverse-linked-list/) \| [Video](https://www.youtube.com/watch?v=FHhItaCZ2pE) |
| 7 | Medium | [Add Two Numbers](src/main/java/org/example/problems/linkedlist/medium/AddTwoNumbers.java) | Two non-empty linked lists represent non-negative integers in reverse order. Add them and return as linked list. | l1 = [2,4,3], l2 = [5,6,4] | [7,0,8] | O(max(m,n)) | [LeetCode](https://leetcode.com/problems/add-two-numbers/) \| [Video](https://www.youtube.com/watch?v=MYtp__JpTns) |
| 8 | Medium | [Copy List with Random Pointer](src/main/java/org/example/problems/linkedlist/medium/CopyListWithRandomPointer.java) | Deep copy a linked list where each node has a random pointer to any node or null. | head = [[7,null],[13,0],[11,4],[10,2],[1,0]] | [[7,null],[13,0],[11,4],[10,2],[1,0]] | O(n) | [LeetCode](https://leetcode.com/problems/copy-list-with-random-pointer/) \| [Video](https://www.youtube.com/watch?v=vy7ZJ4TdyS8) |
| 9 | Medium | [LRU Cache](src/main/java/org/example/problems/linkedlist/medium/LruCache.java) | Design a data structure that follows Least Recently Used (LRU) cache behavior. | See LeetCode | See LeetCode | O(1) | [LeetCode](https://leetcode.com/problems/lru-cache/) \| [Video](https://www.youtube.com/watch?v=VPq5dlxaeP8) |
| 10 | Medium | [Remove Nth Node From End of List](src/main/java/org/example/problems/linkedlist/medium/RemoveNthNodeFromEndOfList.java) | Remove the nth node from the end of a linked list and return its head. | head = [1,2,3,4,5], n = 2 | [1,2,3,5] | O(n) | [LeetCode](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) \| [Video](https://www.youtube.com/watch?v=hZtAW3cp8vQ) |
| 11 | Medium | [Reorder List](src/main/java/org/example/problems/linkedlist/medium/ReorderList.java) | Reorder list from L0→L1→...→Ln to L0→Ln→L1→Ln-1→... in-place without modifying node values. | head = [1,2,3,4] | [1,4,2,3] | O(n) | [LeetCode](https://leetcode.com/problems/reorder-list/) \| [Video](https://www.youtube.com/watch?v=lBdS4AV1EGw) |
| 12 | Hard | [Merge K Sorted Lists](src/main/java/org/example/problems/linkedlist/hard/MergeKSortedLists.java) | Merge k sorted linked lists into one sorted linked list and return it. | lists = [[1,4,5],[1,3,4],[2,6]] | [1,1,2,3,4,4,5,6] | O(N log k) | [LeetCode](https://leetcode.com/problems/merge-k-sorted-lists/) \| [Video](https://www.youtube.com/watch?v=SlKgDtpJnxg) |
| 13 | Hard | [Reverse Nodes in K-Group](src/main/java/org/example/problems/linkedlist/hard/ReverseNodesInKGroup.java) | Reverse nodes of a linked list k at a time. If not enough nodes, leave them as-is. | head = [1,2,3,4,5], k = 2 | [2,1,4,3,5] | O(n) | [LeetCode](https://leetcode.com/problems/reverse-nodes-in-k-group/) \| [Video](https://www.youtube.com/watch?v=P9_K8M4nnf0) |

---

### 4. Stack

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Medium | [Car Fleet](src/main/java/org/example/problems/stack/medium/CarFleet.java) | Cars traveling towards target. A car fleet forms when cars arrive or catch up. Return number of fleets. | target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3] | 3 | O(n log n) | [LeetCode](https://leetcode.com/problems/car-fleet/) \| [Video](https://www.youtube.com/watch?v=TPSiTAFhszA) |
| 2 | Medium | [Daily Temperatures](src/main/java/org/example/problems/stack/medium/DailyTemperatures.java) | Given daily temperatures, return array where answer[i] is days to wait for warmer temperature. | temperatures = [73, 74, 75, 71, 69, 72, 76, 73] | [1, 1, 4, 2, 1, 1, 0, 0] | O(n) | [LeetCode](https://leetcode.com/problems/daily-temperatures/) \| [Video](https://www.youtube.com/watch?v=jmuo4BBfl3I) |
| 3 | Medium | [Evaluate Reverse Polish Notation](src/main/java/org/example/problems/stack/medium/EvaluateReversePolishNotation.java) | Evaluate arithmetic expression in Reverse Polish Notation (+, -, *, /). | tokens = ["2","1","+","3","*"] | 9 | O(n) | [LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/) \| [Video](https://www.youtube.com/watch?v=vDRZN5i4b8U) |
| 4 | Medium | [Generate Parentheses](src/main/java/org/example/problems/stack/medium/GenerateParentheses.java) | Given n pairs of parentheses, generate all combinations of well-formed parentheses. | n = 3 | ["((()))","(()())","(())()","()(())","()()()"] | O(2^n) | [LeetCode](https://leetcode.com/problems/generate-parentheses/) \| [Video](https://www.youtube.com/watch?v=VzMyeCMLdPI) |
| 5 | Medium | [Min Stack](src/main/java/org/example/problems/stack/medium/MinStack.java) | Design a stack with push, pop, top, and getMin in O(1) time. | See problem description | See problem description | O(1) | [LeetCode](https://leetcode.com/problems/min-stack/) \| [Video](https://www.youtube.com/watch?v=To2iap-ac3g) |
| 6 | Medium | [Maximum Remove to Make Valid Parentheses](src/main/java/org/example/problems/stack/medium/MinimumRemoveToMakeValidParentheses.java) | Remove minimum parentheses to make string valid. Return result in any order. | s = "lee(t(c)o)de)" | "lee(t(c)o)de" | O(n) | [LeetCode](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) \| [Video](https://www.youtube.com/watch?v=h9skhJ_UZQo) |
| 7 | Hard | [Largest Rectangle in Histogram](src/main/java/org/example/problems/stack/hard/LargestRectangleInHistogram.java) | Given histogram heights, find largest rectangle area in the histogram. | heights = [2,1,5,6,2,3] | 10 | O(n) | [LeetCode](https://leetcode.com/problems/largest-rectangle-in-histogram/) \| [Video](https://www.youtube.com/watch?v=IasMlShanvc) |
| 8 | Hard | [Longest Valid Parentheses](src/main/java/org/example/problems/stack/hard/LongestValidParentheses.java) | Find length of longest valid (well-formed) parentheses substring. | s = ")()())" | 4 | O(n) | [LeetCode](https://leetcode.com/problems/longest-valid-parentheses/) \| [Video](https://www.youtube.com/watch?v=GrSL3c8G6k8) |
| 9 | Hard | [Max Stack](src/main/java/org/example/problems/stack/hard/MaxStack.java) | Design a stack that supports push, pop, top, retrieving maximum element in O(1). | See problem description | See problem description | O(1) | N/A |

---




### 5. Sorting

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Merge Sorted Array](src/main/java/org/example/problems/sorting/easy/MergeSortedArray.java) | Given two sorted arrays, merge nums2 into nums1 in-place. | nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 | [1,2,2,3,5,6] | O(m+n) | [LeetCode](https://leetcode.com/problems/merge-sorted-array/) \| [Video](https://www.youtube.com/watch?v=05mXJB5SLA8) |
| 2 | Easy | [Majority Element](src/main/java/org/example/problems/sorting/easy/MajorityElement.java) | Find element appearing more than floor(n/2) times in array. | nums = [3,2,3] | 3 | O(n) | [LeetCode](https://leetcode.com/problems/majority-element/) \| [Video](https://www.youtube.com/watch?v=UoTI6zBIBMo) |
| 3 | Medium | [Largest Number](src/main/java/org/example/problems/sorting/medium/LargestNumber.java) | Arrange numbers to form the largest possible number. | nums = [10, 2] | 210 | O(n log n) | [LeetCode](https://leetcode.com/problems/largest-number/) \| [Video](https://www.youtube.com/watch?v=q6tyGuVVbfE) |
| 4 | Medium | [Sort List](src/main/java/org/example/problems/sorting/medium/SortList.java) | Sort a linked list in O(n log n) time using constant space. | head = [4,2,1,3] | [1,2,3,4] | O(n log n) | [LeetCode](https://leetcode.com/problems/sort-list/) \| [Video](https://www.youtube.com/watch?v=7halZ77R55o) |
| 5 | Medium | [Sort Colors](src/main/java/org/example/problems/sorting/medium/SortColors.java) | Sort array of red/white/blue (0/1/2) in-place using Dutch National Flag. | nums = [2,0,2,1,1,0] | [0,0,1,1,2,2] | O(n) | [LeetCode](https://leetcode.com/problems/sort-colors/) \| [Video](https://www.youtube.com/watch?v=HO-qzdL_x8U) |

---

### 6. Tree

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Maximum Depth of Binary Tree](src/main/java/org/example/problems/tree/easy/MaximumDepthOfBinaryTree.java) | Given the root of a binary tree, return its maximum depth. | root = [3,9,20,null,null,15,7] | 3 | O(n) | [LeetCode](https://leetcode.com/problems/maximum-depth-of-binary-tree/) \| NA |
| 2 | Easy | [Same Tree](src/main/java/org/example/problems/tree/easy/SameTree.java) | Given two binary trees, return true if they are structurally identical. | p = [1,2,3], q = [1,2,3] | true | O(n) | [LeetCode](https://leetcode.com/problems/same-tree/) \| NA |
| 3 | Easy | [Invert Binary Tree](src/main/java/org/example/problems/tree/easy/InvertBinaryTree.java) | Invert a binary tree (swap left and right children of all nodes). | root = [4,2,7,1,3,6,9] | [4,7,2,9,6,3,1] | O(n) | [LeetCode](https://leetcode.com/problems/invert-binary-tree/) \| NA |
| 4 | Easy | [Symmetric Tree](src/main/java/org/example/problems/tree/easy/SymmetricTree.java) | Check if a binary tree is a mirror of itself. | root = [1,2,2,3,4,4,3] | true | O(n) | [LeetCode](https://leetcode.com/problems/symmetric-tree/) \| NA |
| 5 | Easy | [Balanced Binary Tree](src/main/java/org/example/problems/tree/easy/BalancedBinaryTree.java) | Check if a binary tree is height-balanced. | root = [3,9,20,null,null,15,7] | true | O(n) | [LeetCode](https://leetcode.com/problems/balanced-binary-tree/) \| NA |
| 6 | Easy | [Diameter of Binary Tree](src/main/java/org/example/problems/tree/easy/DiameterOfBinaryTree.java) | Find the diameter (longest path between any two nodes). | root = [1,2,3,4,5] | 3 | O(n) | [LeetCode](https://leetcode.com/problems/diameter-of-binary-tree/) \| NA |
| 7 | Easy | [Subtree of Another Tree](src/main/java/org/example/problems/tree/easy/SubtreeOfAnotherTree.java) | Check if one tree is a subtree of another. | root = [3,4,5,1,2], subRoot = [4,1,2] | true | O(n) | [LeetCode](https://leetcode.com/problems/subtree-of-another-tree/) \| NA |
| 8 | Easy | [Invert/Binary Tree](src/main/java/org/example/problems/tree/easy/InvertflipBinaryTree.java) | Invert flip a binary tree vertically. | root = [4,2,7,1,3,6,9] | [4,7,2,9,6,3,1] | O(n) | [LeetCode](https://leetcode.com/problems/invert-binary-tree/) \| NA |
| 9 | Medium | [Binary Tree Level Order Traversal](src/main/java/org/example/problems/tree/medium/BinaryTreeLevelOrderTraversal.java) | Level order traversal of binary tree (level by level). | root = [3,9,20,null,null,15,7] | [[3],[9,20],[15,7]] | O(n) | [LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal/) \| NA |
| 10 | Medium | [Binary Tree Right Side View](src/main/java/org/example/problems/tree/medium/BinaryTreeRightSideView.java) | Return rightmost nodes of each level. | root = [1,2,3,null,5,null,4] | [1,3,4] | O(n) | [LeetCode](https://leetcode.com/problems/binary-tree-right-side-view/) \| NA |
| 11 | Medium | [Validate Binary Search Tree](src/main/java/org/example/problems/tree/medium/ValidateBinarySearchTree.java) | Check if a binary tree is a valid BST. | root = [2,1,3] | true | O(n) | [LeetCode](https://leetcode.com/problems/validate-binary-search-tree/) \| NA |
| 12 | Medium | [Kth Smallest Element in BST](src/main/java/org/example/problems/tree/medium/KthSmallestElementInABst.java) | Find kth smallest element in BST. | root = [3,1,4,null,2], k = 1 | 1 | O(n) | [LeetCode](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) \| NA |
| 13 | Medium | [Lowest Common Ancestor of BST](src/main/java/org/example/problems/tree/medium/LowestCommonAncestorOfABinarySearchTree.java) | Find LCA in a BST. | root = [6,2,8,0,4,7,9], p = 2, q = 8 | 6 | O(n) | [LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) \| NA |
| 14 | Medium | [Binary Tree Zigzag Level Order Traversal](src/main/java/org/example/problems/tree/medium/BinaryTreeZigzagLevelOrderTraversal.java) | Zigzag level order traversal. | root = [3,9,20,null,null,15,7] | [[3],[20,9],[15,7]] | O(n) | [LeetCode](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) \| NA |
| 15 | Medium | [Construct Binary Tree from Preorder and Inorder Traversal](src/main/java/org/example/problems/tree/medium/ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | Build tree from preorder and inorder. | preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] | [3,9,20,null,null,15,7] | O(n) | [LeetCode](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) \| NA |
| 16 | Medium | [Count Good Nodes in Binary Tree](src/main/java/org/example/problems/tree/medium/CountGoodNodesInBinaryTree.java) | Count nodes with value >= path max. | root = [1,null,2,3,4,5,null] | 4 | O(n) | [LeetCode](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) \| NA |
| 17 | Medium | [Lowest Common Ancestor of Binary Tree](src/main/java/org/example/problems/tree/medium/LowestCommonAncestorOfBst.java) | Find LCA in binary tree. | root = [3,5,1,6,2,0,8], p = 5, q = 1 | 3 | O(n) | [LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-bst/) \| NA |
| 18 | Medium | [Find Leaves of Binary Tree](src/main/java/org/example/problems/tree/medium/FindLeavesOfBinaryTree.java) | Remove all leaves and return them level by level. | root = [1,2,3,4,5] | [[4,5,3],[2],[1]] | O(n) | [LeetCode](https://leetcode.com/problems/find-leaves-of-binary-tree/) \| NA |
| 19 | Medium | [Implement Trie (Prefix Tree)](src/main/java/org/example/problems/tree/medium/ImplementTriePrefixTree.java) | Implement a Trie with insert, search, startsWith. | See problem description | See problem description | O(m) | [LeetCode](https://leetcode.com/problems/implement-trie-(prefix-tree)/) \| NA |
| 20 | Medium | [Add and Search Word](src/main/java/org/example/problems/tree/medium/AddAndSearchWord.java) | Design a data structure for word search. | See problem description | See problem description | O(n) | [LeetCode](https://leetcode.com/problems/add-and-search-word/) \| NA |
| 21 | Medium | [Design Add and Search Words Data Structure](src/main/java/org/example/problems/tree/medium/DesignAddAndSearchWordsDataStructure.java) | Design word dictionary with wildcard search. | See problem description | See problem description | O(n) | [LeetCode](https://leetcode.com/problems/design-add-and-search-words-data-structure/) \| NA |
| 22 | Hard | [Binary Tree Maximum Path Sum](src/main/java/org/example/problems/tree/hard/BinaryTreeMaximumPathSum.java) | Find maximum path sum in a binary tree. | root = [-10,9,20,null,null,15,7] | 42 | O(n) | [LeetCode](https://leetcode.com/problems/binary-tree-maximum-path-sum/) \| NA |
| 23 | Hard | [Serialize and Deserialize Binary Tree](src/main/java/org/example/problems/tree/hard/SerializeAndDeserializeBinaryTree.java) | Encode and decode a binary tree. | root = [1,2,3,null,null,4,5] | [1,2,3,null,null,4,5] | O(n) | [LeetCode](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) \| NA |
| 24 | Hard | [Word Search II](src/main/java/org/example/problems/tree/hard/WordSearchIi.java) | Find all words in board from dictionary. | board = [["o","a","a","n"],["e","t","a","e"]], words = ["eat","oath"] | ["eat","oath"] | O(n * m * 4^l) | [LeetCode](https://leetcode.com/problems/word-search-ii/) \| NA |

---

### 7. Binary Search

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Binary Search](src/main/java/org/example/problems/binarysearch/easy/BinarySearch.java) | Given sorted array and target, return index if found, else -1. O(log n) required. | nums = [-1,0,3,5,9,12], target = 9 | 4 | O(log n) | [LeetCode](https://leetcode.com/problems/binary-search/) \| [Video](https://www.youtube.com/watch?v=t3yPHFyKxr4) |
| 2 | Medium | [Koko Eating Bananas](src/main/java/org/example/problems/binarysearch/medium/KokoEatingBananas.java) | Find minimum eating speed k so Koko can eat all bananas within h hours. | piles = [3,6,7,11], h = 8 | 4 | O(n log maxPile) | [LeetCode](https://leetcode.com/problems/koko-eating-bananas/) \| [Video](https://www.youtube.com/watch?v=3m3QZeiH3KI) |
| 3 | Medium | [Search a 2D Matrix](src/main/java/org/example/problems/binarysearch/medium/SearchA2dMatrix.java) | Search for target in m x n matrix with sorted rows and columns. | matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 | true | O(log(m*n)) | [LeetCode](https://leetcode.com/problems/search-a-2d-matrix/) \| [Video](https://www.youtube.com/watch?v=dP4cb8zbohY) |
---

### 8. Backtracking

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Medium | [Subsets](src/main/java/org/example/problems/backtracking/medium/Subsets.java) | Generate all possible subsets of a set. | nums = [1,2,3] | [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] | O(n * 2^n) | [LeetCode](https://leetcode.com/problems/subsets/) \| NA |
| 2 | Medium | [Subsets II](src/main/java/org/example/problems/backtracking/medium/SubsetsIi.java) | Generate all possible subsets with duplicates. | nums = [1,2,2] | [[],[1],[2],[1,2],[2,2],[1,2,2]] | O(n * 2^n) | [LeetCode](https://leetcode.com/problems/subsets-ii/) \| NA |
| 3 | Medium | [Permutations](src/main/java/org/example/problems/backtracking/medium/Permutations.java) | Generate all permutations of an array. | nums = [1,2,3] | [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] | O(n!) | [LeetCode](https://leetcode.com/problems/permutations/) \| NA |
| 4 | Medium | [Combination Sum II](src/main/java/org/example/problems/backtracking/medium/CombinationSumIi.java) | Find all combinations that sum to target. | candidates = [2,3,6,7], target = 7 | [[2,2,3],[7]] | O(n * 2^n) | [LeetCode](https://leetcode.com/problems/combination-sum-ii/) \| NA |
| 5 | Medium | [Palindrome Partitioning](src/main/java/org/example/problems/backtracking/medium/PalindromePartitioning.java) | Partition string into palindromic substrings. | s = "aab" | [["a","a","b"],["aa","b"]] | O(n * 2^n) | [LeetCode](https://leetcode.com/problems/palindrome-partitioning/) \| NA |
| 6 | Medium | [Word Search](src/main/java/org/example/problems/backtracking/medium/WordSearch.java) | Find if word exists in grid. | board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED" | true | O(n * 4^l) | [LeetCode](https://leetcode.com/problems/word-search/) \| NA |
| 7 | Hard | [N-Queens](src/main/java/org/example/problems/backtracking/hard/NQueens.java) | Solve N-Queens problem. | n = 4 | [[" .Q..","...Q","Q...","..Q."],["..Q.",".Q..","...Q","Q..."]] | O(n!) | [LeetCode](https://leetcode.com/problems/n-queens/) \| NA |

---

### 9. Bit Manipulation

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Single Number](src/main/java/org/example/problems/bitmanipulation/easy/SingleNumber.java) | Find element that appears once while others appear twice. | nums = [2,2,1] | 1 | O(n) | [LeetCode](https://leetcode.com/problems/single-number/) \| [Video](https://www.youtube.com/watch?v=2LaOz13Y5qw) |
| 2 | Easy | [Number of 1 Bits](src/main/java/org/example/problems/bitmanipulation/easy/NumberOf1Bits.java) | Count the number of 1-bits in an integer. | n = 11 | 3 | O(1) | [LeetCode](https://leetcode.com/problems/number-of-1-bits/) \| [Video](https://www.youtube.com/watch?v=xx9vN3n0_SA) |
| 3 | Medium | [Reverse Integer](src/main/java/org/example/problems/bitmanipulation/medium/ReverseInteger.java) | Reverse digits of an integer. | x = 123 | 321 | O(log x) | [LeetCode](https://leetcode.com/problems/reverse-integer/) \| [Video](https://www.youtube.com/watch?v=fZwClQfC3qU) |

---

### 10. Binary Bit Manipulation

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Counting Bits](src/main/java/org/example/problems/binarybitmanipulation/easy/CountingBits.java) | Return array of number of 1-bits for each number. | n = 5 | [0,1,1,2,1,2] | O(n) | [LeetCode](https://leetcode.com/problems/counting-bits/) \| [Video](https://www.youtube.com/watch?v=f9vCuICgRpU) |
| 2 | Easy | [Reverse Bits](src/main/java/org/example/problems/binarybitmanipulation/easy/ReverseBits.java) | Reverse bits of a 32-bit integer. | n = 0b00000010100101000001111000111100 | 0b00111100111010100101000000101000 | O(1) | [LeetCode](https://leetcode.com/problems/reverse-bits/) \| [Video](https://www.youtube.com/watch?v=-7bpRBMPXh8) |
| 3 | Easy | [Missing Number](src/main/java/org/example/problems/binarybitmanipulation/easy/MissingNumber.java) | Find missing number from 0 to n. | nums = [3,0,1] | 2 | O(n) | [LeetCode](https://leetcode.com/problems/missing-number/) \| [Video](https://www.youtube.com/watch?v=-pLW7935dlc) |
| 4 | Medium | [Sum of Two Integers](src/main/java/org/example/problems/binarybitmanipulation/medium/SumOfTwoIntegers.java) | Calculate sum without using + or -. | a = 1, b = 2 | 3 | O(1) | [LeetCode](https://leetcode.com/problems/sum-of-two-integers/) \| [Video](https://www.youtube.com/watch?v=oQqe3N2aSd4) |

---

### 11. Design

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Logger Rate Limiter](src/main/java/org/example/problems/design/easy/LoggerRateLimiter.java) | Design a logger system that prevents duplicate messages within a time period. | See problem description | See problem description | O(1) | [LeetCode](https://leetcode.com/problems/logger-rate-limiter/) \| NA |
| 2 | Easy | [Moving Average from Data Stream](src/main/java/org/example/problems/design/easy/MovingAverageFromDataStream.java) | Calculate moving average of stream of integers. | See problem description | See problem description | O(1) | [LeetCode](https://leetcode.com/problems/moving-average-from-data-stream/) \| NA |
| 3 | Medium | [Insert Delete GetRandom O(1)](src/main/java/org/example/problems/design/medium/InsertDeleteGetrandomO1.java) | Design data structure with insert, delete, getRandom in O(1). | See problem description | See problem description | O(1) | [LeetCode](https://leetcode.com/problems/insert-delete-getrandom-o1/) \| NA |
| 4 | Medium | [Design Tic Tac Toe](src/main/java/org/example/problems/design/medium/DesignTictactoe.java) | Design Tic-Tac-Toe game. | See problem description | See problem description | O(1) | [LeetCode](https://leetcode.com/problems/design-tic-tac-toe/) \| NA |

---

### 12. Dynamic Programming

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Climbing Stairs](src/main/java/org/example/problems/dynamicprogramming/easy/ClimbingStairs.java) | Count ways to climb n stairs (1 or 2 steps at a time). | n = 3 | 3 | O(n) | [LeetCode](https://leetcode.com/problems/climbing-stairs/) \| [Video](https://www.youtube.com/watch?v=5mWBnYrdO70) |
| 2 | Easy | [Min Cost Climbing Stairs](src/main/java/org/example/problems/dynamicprogramming/easy/MinCostClimbingStairs.java) | Find min cost to reach top. | cost = [1,100,1,1,1,100,1,1,100,1] | 6 | O(n) | [LeetCode](https://leetcode.com/problems/min-cost-climbing-stairs/) \| [Video](https://www.youtube.com/watch?v=A3LYMRqAQeU) |
| 3 | Easy | [Pascal's Triangle](src/main/java/org/example/problems/dynamicprogramming/easy/PascalsTriangle.java) | Generate Pascal's triangle. | numRows = 5 | [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] | O(n^2) | [LeetCode](https://leetcode.com/problems/pascals-triangle/) \| [Video](https://www.youtube.com/watch?v=f0EEHwaY3HY) |
| 4 | Medium | [Unique Paths](src/main/java/org/example/problems/dynamicprogramming/medium/UniquePaths.java) | Count unique paths from top-left to bottom-right. | m = 3, n = 7 | 28 | O(m*n) | [LeetCode](https://leetcode.com/problems/unique-paths/) \| [Video](https://www.youtube.com/watch?v=klWLMgdMWCY) |
| 5 | Medium | [Longest Common Subsequence](src/main/java/org/example/problems/dynamicprogramming/medium/LongestCommonSubsequence.java) | Find LCS length of two strings. | text1 = "abcde", text2 = "ace" | 3 | O(m*n) | [LeetCode](https://leetcode.com/problems/longest-common-subsequence/) \| [Video](https://www.youtube.com/watch?v=lPnPdSIliII) |
| 6 | Medium | [Word Break](src/main/java/org/example/problems/dynamicprogramming/medium/WordBreakProblem.java) | Check if string can be segmented into dictionary words. | s = "leetcode", dict = ["leet","code"] | true | O(n^2) | [LeetCode](https://leetcode.com/problems/word-break/) \| [Video](https://www.youtube.com/watch?v=XD9tXO9HW40) |
| 7 | Medium | [Jump Game](src/main/java/org/example/problems/dynamicprogramming/medium/JumpGame.java) | Check if can reach last index. | nums = [2,3,1,1,4] | true | O(n) | [LeetCode](https://leetcode.com/problems/jump-game/) \| [Video](https://www.youtube.com/watch?v=PVNLmjJaHW0) |
| 8 | Medium | [Jump Game II](src/main/java/org/example/problems/dynamicprogramming/medium/JumpGameIi.java) | Find minimum jumps to reach last index. | nums = [2,3,1,1,4] | 2 | O(n) | [LeetCode](https://leetcode.com/problems/jump-game-ii/) \| [Video](https://www.youtube.com/watch?v=d_1GRnMg_zs) |
| 9 | Medium | [Combination Sum IV](src/main/java/org/example/problems/dynamicprogramming/medium/CombinationSum.java) | Count number of combinations that sum to target. | nums = [1,2,3], target = 4 | 7 | O(n*target) | [LeetCode](https://leetcode.com/problems/combination-sum/) \| [Video](https://www.youtube.com/watch?v=dJBbuDK4ZRk) |
| 10 | Medium | [House Robber](src/main/java/org/example/problems/dynamicprogramming/medium/BestTimeToBuyAndSellStockWithCooldown.java) | Max money to rob without robbing adjacent houses. | nums = [1,2,3,1] | 4 | O(n) | [LeetCode](https://leetcode.com/problems/house-robber/) \| [Video](https://www.youtube.com/watch?v=PH5jUN1cNHo) |
| 11 | Medium | [Partition Equal Subset Sum](src/main/java/org/example/problems/dynamicprogramming/medium/PartitionEqualSubsetSum.java) | Check if array can be partitioned into two subsets with equal sum. | nums = [1,5,11,5] | true | O(n*sum) | [LeetCode](https://leetcode.com/problems/partition-equal-subset-sum/) \| [Video](https://www.youtube.com/watch?v=X50Rknzenus) |
| 12 | Medium | [Coin Change II](src/main/java/org/example/problems/dynamicprogramming/medium/CoinChangeIi.java) | Find number of ways to make amount with coins. | coins = [1,2,5], amount = 5 | 4 | O(n*amount) | [LeetCode](https://leetcode.com/problems/coin-change-ii/) \| [Video](https://www.youtube.com/watch?v=khIBdTrRggk) |
| 13 | Medium | [Edit Distance](src/main/java/org/example/problems/dynamicprogramming/medium/EditDistance.java) | Find min edits to convert word1 to word2. | word1 = "horse", word2 = "ros" | 3 | O(m*n) | [LeetCode](https://leetcode.com/problems/edit-distance/) \| [Video](https://www.youtube.com/watch?v=fnWskW9xaw4) |
| 14 | Medium | [Target Sum](src/main/java/org/example/problems/dynamicprogramming/medium/TargetSum.java) | Find number of ways to reach target using +/- signs. | nums = [1,1,1,1,1], target = 3 | 5 | O(n*sum) | [LeetCode](https://leetcode.com/problems/target-sum/) \| [Video](https://www.youtube.com/watch?v=9QqOX57nMAY) |
| 15 | Medium | [Interleaving String](src/main/java/org/example/problems/dynamicprogramming/medium/InterleavingString.java) | Check if s3 is interleaving of s1 and s2. | s1 = "aab", s2 = "axy", s3 = "aaxaby" | true | O(m*n) | [LeetCode](https://leetcode.com/problems/interleaving-string/) \| [Video](https://www.youtube.com/watch?v=KXIK863L9tk) |
| 16 | Hard | [Regular Expression Matching](src/main/java/org/example/problems/dynamicprogramming/hard/RegularExpressionMatching.java) | Implement regex matching with '.' and '*'. | s = "aa", p = "a*" | true | O(m*n) | [LeetCode](https://leetcode.com/problems/regular-expression-matching/) \| [Video](https://www.youtube.com/watch?v=VFQddcCP46c) |
| 17 | Hard | [Distinct Subsequences](src/main/java/org/example/problems/dynamicprogramming/hard/DistinctSubsequences.java) | Count distinct subsequences of s equal to t. | s = "rabbbit", t = "rabbit" | 3 | O(m*n) | [LeetCode](https://leetcode.com/problems/distinct-subsequences/) \| [Video](https://www.youtube.com/watch?v=A5IBp1ldlik) |
| 18 | Hard | [Burst Balloons](src/main/java/org/example/problems/dynamicprogramming/hard/BurstBalloons.java) | Max coins by bursting balloons. | nums = [3,1,5,8] | 167 | O(n^3) | [LeetCode](https://leetcode.com/problems/burst-balloons/) \| [Video](https://www.youtube.com/watch?v=TfvN6rqDOT0) |
| 19 | Hard | [Race Car](src/main/java/org/example/problems/dynamicprogramming/hard/RaceCar.java) | Min time to reach target using accelerate/reverse. | target = 6 | 2 | O(n log n) | [LeetCode](https://leetcode.com/problems/race-car/) \| [Video](https://www.youtube.com/watch?v=TAXt_TkSNfw) |

---

### 13. Graph

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Medium | [Number of Islands](src/main/java/org/example/problems/graph/medium/NumberOfIslands.java) | Count number of islands in a grid. | grid = [["1","1","1"],["0","1","0"],["1","1","1"]] | 1 | O(m*n) | [LeetCode](https://leetcode.com/problems/number-of-islands/) \| [Video](https://www.youtube.com/watch?v=H-2Nh2RXX6g) |
| 2 | Medium | [Max Area of Island](src/main/java/org/example/problems/graph/medium/MaxAreaOfIsland.java) | Find max area of an island. | grid = [[0,0,1,0,0],[0,1,1,0,0],[0,0,0,0,0]] | 5 | O(m*n) | [LeetCode](https://leetcode.com/problems/max-area-of-island/) \| [Video](https://www.youtube.com/watch?v=Dy-M-Suk8nk) |
| 3 | Medium | [Rotting Oranges](src/main/java/org/example/problems/graph/medium/RottingOranges.java) | Find min time for all oranges to rot. | grid = [[2,1,1],[1,1,0],[0,1,1]] | 4 | O(m*n) | [LeetCode](https://leetcode.com/problems/rotting-oranges/) \| [Video](https://www.youtube.com/watch?v=1BlwbFfgk-E) |
| 4 | Medium | [Walls and Gates](src/main/java/org/example/problems/graph/medium/WallsAndGates.java) | Fill empty rooms with distance to nearest gate. | rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]] | [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]] | O(m*n) | [LeetCode](https://leetcode.com/problems/walls-and-gates/) \| [Video](https://www.youtube.com/watch?v=wYv60DTtsto) |
| 5 | Medium | [Surrounded Regions](src/main/java/org/example/problems/graph/medium/SurroundedRegions.java) | Capture surrounded regions. | board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]] | [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]] | O(m*n) | [LeetCode](https://leetcode.com/problems/surrounded-regions/) \| [Video](https://www.youtube.com/watch?v=yaBaE4fo6wA) |
| 6 | Medium | [Redundant Connection](src/main/java/org/example/problems/graph/medium/RedundantConnection.java) | Find edge that creates a cycle. | edges = [[1,2],[2,3],[3,4],[1,4],[1,5]] | [1,4] | O(n) | [LeetCode](https://leetcode.com/problems/redundant-connection/) \| [Video](https://www.youtube.com/watch?v=ctMC5TPuVnM) |
| 7 | Hard | [Word Ladder](src/main/java/org/example/problems/graph/hard/WordLadder.java) | Find min transformation steps. | beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"] | 5 | O(n * m) | [LeetCode](https://leetcode.com/problems/word-ladder/) \| [Video](https://www.youtube.com/watch?v=isLTjdCw52s) |
| 8 | Medium | [Clone Graph](src/main/java/org/example/problems/graph/medium/CloneGraph.java) | Clone an undirected graph. | See problem description | See problem description | O(V+E) | [LeetCode](https://leetcode.com/problems/clone-graph/) \| NA |
| 9 | Medium | [Course Schedule](src/main/java/org/example/problems/graph/medium/CourseSchedule.java) | Check if all courses can be completed. | numCourses = 2, prerequisites = [[1,0]] | true | O(V+E) | [LeetCode](https://leetcode.com/problems/course-schedule/) \| NA |
| 10 | Medium | [Course Schedule II](src/main/java/org/example/problems/graph/medium/CourseScheduleIi.java) | Find order to complete courses. | numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] | [0,2,1,3] | O(V+E) | [LeetCode](https://leetcode.com/problems/course-schedule-ii/) \| NA |
| 11 | Medium | [Longest Consecutive Sequence](src/main/java/org/example/problems/graph/medium/LongestConsecutiveSequence.java) | Find longest consecutive sequence. | nums = [100,4,200,1,3,2] | 4 | O(n) | [LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/) \| NA |
| 12 | Medium | [Pacific Atlantic Water Flow](src/main/java/org/example/problems/graph/medium/PacificAtlanticWaterFlow.java) | Find cells that can flow to both oceans. | matrix = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,3,1,2,4]] | [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]] | O(m*n) | [LeetCode](https://leetcode.com/problems/pacific-atlantic-water-flow/) \| NA |
| 13 | Medium | [Number of Provinces](src/main/java/org/example/problems/graph/medium/NumberOfProvinces.java) | Find number of connected components. | isConnected = [[1,1,0],[1,1,0],[0,0,1]] | 2 | O(n^2) | [LeetCode](https://leetcode.com/problems/number-of-provinces/) \| NA |
| 14 | Medium | [Number of Connected Components in Undirected Graph](src/main/java/org/example/problems/graph/medium/NumberOfConnectedComponentsInAnUndirectedGraph.java) | Count connected components. | n = 5, edges = [[0,1],[1,2],[2,0],[3,4]] | 2 | O(V+E) | [LeetCode](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) \| NA |
| 15 | Medium | [Graph Valid Tree](src/main/java/org/example/problems/graph/medium/GraphValidTree.java) | Check if graph is a valid tree. | n = 5, edges = [[0,1],[0,2],[0,3],[1,4]] | true | O(V+E) | [LeetCode](https://leetcode.com/problems/valid-graph-tree/) \| NA |
| 16 | Medium | [Find the Celebrity](src/main/java/org/example/problems/graph/medium/FindTheCelebrity.java) | Find the celebrity who knows no one but everyone knows. | n = 3 | 0 | O(n) | [LeetCode](https://leetcode.com/problems/find-the-celebrity/) \| NA |
| 17 | Medium | [Network Delay Time](src/main/java/org/example/problems/graph/medium/NetworkDelayTime.java) | Find time for signal to reach all nodes. | times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2 | 2 | O(E log V) | [LeetCode](https://leetcode.com/problems/network-delay-time/) \| NA |
| 18 | Medium | [Cheapest Flights Within K Stops](src/main/java/org/example/problems/graph/medium/CheapestFlightsWithinKStops.java) | Find cheapest flight with at most k stops. | flights = [[0,1,100],[1,2,100],[2,0,100]], src = 0, dst = 2, k = 1 | 200 | O(E * K) | [LeetCode](https://leetcode.com/problems/cheapest-flights-within-k-stops/) \| NA |
| 19 | Medium | [Min Cost to Connect All Points](src/main/java/org/example/problems/graph/medium/MinCostToConnectAllPoints.java) | Find min cost to connect all points. | points = [[0,0],[2,2],[3,10],[5,2],[7,0]] | 20 | O(V^2) | [LeetCode](https://leetcode.com/problems/minimum-cost-to-connect-all-points/) \| NA |
| 20 | Hard | [Alien Dictionary](src/main/java/org/example/problems/graph/hard/AlienDictionary.java) | Find alien language order. | dictionary = ["wrt","wrf","er","ett","rftt"] | "wertf" | O(V+E) | [LeetCode](https://leetcode.com/problems/alien-dictionary/) \| NA |
| 21 | Hard | [Reconstruct Itinerary](src/main/java/org/example/problems/graph/hard/ReconstructItinerary.java) | Reconstruct itinerary. | tickets = [["JFK","SFO"],["JFK","ATL"],["ATL","JFK"]] | ["JFK","ATL","JFK","SFO"] | O(E log E) | [LeetCode](https://leetcode.com/problems/reconstruct-itinerary/) \| NA |
| 22 | Hard | [Swim in Rising Water](src/main/java/org/example/problems/graph/hard/SwimInRisingWater.java) | Find min time to swim across. | grid = [[3,2],[0,1]] | 3 | O(n^2 log n) | [LeetCode](https://leetcode.com/problems/swim-in-rising-water/) \| NA |

---

### 14. Hashing

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Valid Sudoku](src/main/java/org/example/problems/array/medium/ValidSudoku.java) | Determine if a 9x9 Sudoku board is valid. | board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]] | false | O(1) | [LeetCode](https://leetcode.com/problems/valid-sudoku/) \| NA |
| 2 | Easy | [Roman to Integer](src/main/java/org/example/problems/hashing/easy/RomanToInteger.java) | Convert Roman numeral to integer. | s = "III" | 3 | O(n) | [LeetCode](https://leetcode.com/problems/roman-to-integer/) \| [Video](https://www.youtube.com/watch?v=qmkr61ySQwQ) |
| 3 | Hard | [First Missing Positive](src/main/java/org/example/problems/hashing/hard/FirstMissingPositive.java) | Find the smallest missing positive integer. | nums = [3,4,-1,1] | 2 | O(n) | [LeetCode](https://leetcode.com/problems/first-missing-positive/) \| [Video](https://www.youtube.com/watch?v=N8DefKVUIKw) |

---

### 15. Heap

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Medium | [Top K Frequent Elements](src/main/java/org/example/problems/array/medium/TopKFrequentElements.java) | Return k most frequent elements. | nums = [1,1,1,2,2,3], k = 2 | [1,2] | O(n log k) | [LeetCode](https://leetcode.com/problems/top-k-frequent-elements/) \| NA |
| 2 | Easy | [Kth Largest Element in a Stream](src/main/java/org/example/problems/heap/easy/KthLargestElementInAStream.java) | Design a stream to find kth largest element. | nums = [4,5,8,2], k = 4 | 4 | O(n log k) | [LeetCode](https://leetcode.com/problems/kth-largest-element-in-a-stream/) \| NA |
| 3 | Easy | [Last Stone Weight](src/main/java/org/example/problems/heap/easy/LastStoneWeight.java) | Simulate smashing stones. | stones = [2,7,4,1,8,1] | 1 | O(n log n) | [LeetCode](https://leetcode.com/problems/last-stone-weight/) \| [Video](https://www.youtube.com/watch?v=xq4RoS0vVfM) |
| 4 | Easy | [High Five](src/main/java/org/example/problems/heap/easy/HighFive.java) | Get top 5 scores for each student. | See problem description | See problem description | O(n log k) | [LeetCode](https://leetcode.com/problems/high-five/) \| [Video](https://www.youtube.com/watch?v=z4c5QjarJxI) |
| 5 | Medium | [Kth Largest Element in an Array](src/main/java/org/example/problems/heap/medium/KthLargestElementInAnArray.java) | Find kth largest element in array. | nums = [3,2,1,5,6,4], k = 2 | 5 | O(n log k) | [LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/) \| [Video](https://www.youtube.com/watch?v=kmUL7Q8wTQc) |
| 6 | Medium | [K Closest Points to Origin](src/main/java/org/example/problems/heap/medium/KClosestPointsToOrigin.java) | Find k closest points to origin. | points = [[1,3],[-2,2]], k = 1 | [[-2,2]] | O(n log k) | [LeetCode](https://leetcode.com/problems/k-closest-points-to-origin/) \| [Video](https://www.youtube.com/watch?v=RLyF_-4Izg0) |
| 7 | Medium | [Design Twitter](src/main/java/org/example/problems/heap/medium/DesignTwitter.java) | Design a Twitter feed. | See problem description | See problem description | O(log k) | [LeetCode](https://leetcode.com/problems/design-twitter/) \| [Video](https://www.youtube.com/watch?v=esZ4vvjwW6E) |
| 8 | Medium | [Task Scheduler](src/main/java/org/example/problems/heap/medium/TaskScheduler.java) | Find min time to finish tasks. | tasks = ["A","A","A","B","B","B"], n = 2 | 8 | O(n) | [LeetCode](https://leetcode.com/problems/task-scheduler/) \| [Video](https://www.youtube.com/watch?v=IcjlqToRGWI) |
| 9 | Hard | [Find Median from Data Stream](src/main/java/org/example/problems/heap/hard/FindMedianFromDataStream.java) | Find median from data stream. | See problem description | See problem description | O(log n) | [LeetCode](https://leetcode.com/problems/find-median-from-data-stream/) \| [Video](https://www.youtube.com/watch?v=IKpM6Q8wTIY) |

---

### 16. Interval

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Easy | [Meeting Rooms](src/main/java/org/example/problems/interval/easy/MeetingRooms.java) | Check if person can attend all meetings. | intervals = [[0,30],[5,10],[15,20]] | false | O(n log n) | [LeetCode](https://leetcode.com/problems/meeting-rooms/) \| [Video](https://www.youtube.com/watch?v=5nqLiwo0oC0) |
| 2 | Medium | [Merge Intervals](src/main/java/org/example/problems/interval/medium/MergeIntervals.java) | Merge all overlapping intervals. | intervals = [[1,3],[2,6],[8,10],[15,18]] | [[1,6],[8,10],[15,18]] | O(n log n) | [LeetCode](https://leetcode.com/problems/merge-intervals/) \| [Video](https://www.youtube.com/watch?v=n3F2v9f8OfY) |
| 3 | Medium | [Insert Interval](src/main/java/org/example/problems/interval/medium/InsertInterval.java) | Insert new interval and merge. | intervals = [[1,3],[6,9]], newInterval = [2,5] | [[1,5],[6,9]] | O(n) | [LeetCode](https://leetcode.com/problems/insert-interval/) \| [Video](https://www.youtube.com/watch?v=16YiKk6ga7Y) |
| 4 | Medium | [Non-overlapping Intervals](src/main/java/org/example/problems/interval/medium/NonoverlappingIntervals.java) | Remove minimum intervals to avoid overlap. | intervals = [[1,2],[2,3],[3,4],[1,3]] | 1 | O(n log n) | [LeetCode](https://leetcode.com/problems/non-overlapping-intervals/) \| [Video](https://www.youtube.com/watch?v=y8nBFmPsAF8) |
| 5 | Medium | [Meeting Rooms II](src/main/java/org/example/problems/interval/medium/MeetingRoomsIi.java) | Find min number of meeting rooms needed. | intervals = [[0,30],[5,10],[15,20]] | 2 | O(n log n) | [LeetCode](https://leetcode.com/problems/meeting-rooms-ii/) \| [Video](https://www.youtube.com/watch?v=sQkgNfoPrDw) |
| 6 | Medium | [Remove Interval](src/main/java/org/example/problems/interval/medium/RemoveInterval.java) | Remove intervals from list. | intervals = [[1,2],[3,4],[5,6]], toRemove = [2,5] | [[1,2],[5,6]] | O(n) | [LeetCode](https://leetcode.com/problems/remove-interval/) \| [Video](https://www.youtube.com/watch?v=YrB_zKEHgmQ) |
| 7 | Hard | [Minimum Interval to Include Each Query](src/main/java/org/example/problems/interval/hard/MinimumIntervalToIncludeEachQuery.java) | Find min interval for each query. | intervals = [[1,4],[2,4],[3,4]], queries = [2,3,4] | [2,3,4] | O(n log n) | [LeetCode](https://leetcode.com/problems/minimum-interval-to-include-each-query/) \| [Video](https://www.youtube.com/watch?v=FZtDTYzVUhU) |

---

### 17. Matrix

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Medium | [Search a 2D Matrix](src/main/java/org/example/problems/binarysearch/medium/SearchA2dMatrix.java) | Search for target in m x n matrix with sorted rows and columns. | matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 | true | O(log(m*n)) | [LeetCode](https://leetcode.com/problems/search-a-2d-matrix/) \| NA |
| 2 | Easy | [Plus One](src/main/java/org/example/problems/matrix/easy/PlusOne.java) | Add one to a number represented by array. | digits = [1,2,3] | [1,2,4] | O(n) | [LeetCode](https://leetcode.com/problems/plus-one/) \| [Video](https://www.youtube.com/watch?v=1KIcZqCXNHU) |
| 3 | Easy | [Happy Number](src/main/java/org/example/problems/matrix/easy/HappyNumber.java) | Determine if a number is happy. | n = 19 | true | O(log n) | [LeetCode](https://leetcode.com/problems/happy-number/) \| [Video](https://www.youtube.com/watch?v=d5SvCvRmmww) |
| 4 | Medium | [Game of Life](src/main/java/org/example/problems/matrix/medium/GameOfLife.java) | Simulate the Game of Life. | board = [[0,1],[1,1]] | [[0,0],[1,1]] | O(m*n) | [LeetCode](https://leetcode.com/problems/game-of-life/) \| [Video](https://www.youtube.com/watch?v=1FQNMDPZXRc) |
| 5 | Medium | [Pow(x, n)](src/main/java/org/example/problems/matrix/medium/PowxN.java) | Implement pow(x, n). | x = 2.0, n = 10 | 1024.0 | O(log n) | [LeetCode](https://leetcode.com/problems/powx-n/) \| [Video](https://www.youtube.com/watch?v=OUKFuUkb4p0) |
| 6 | Medium | [Multiply Strings](src/main/java/org/example/problems/matrix/medium/MultiplyStrings.java) | Multiply two strings. | num1 = "2", num2 = "3" | "6" | O(m*n) | [LeetCode](https://leetcode.com/problems/multiply-strings/) \| [Video](https://www.youtube.com/watch?v=1Hftrgb30BQ) |
| 7 | Medium | [Detect Squares](src/main/java/org/example/problems/matrix/medium/DetectSquares.java) | Count points forming a square. | See problem description | See problem description | O(1) | [LeetCode](https://leetcode.com/problems/detect-squares/) \| [Video](https://www.youtube.com/watch?v=1UooPSAHjfw) |
| 8 | Hard | [Longest Increasing Path in a Matrix](src/main/java/org/example/problems/matrix/hard/LongestIncreasingPathInAMatrix.java) | Find longest increasing path in matrix. | matrix = [[9,9,4],[6,6,8],[0,1,1]] | 4 | O(m*n) | [LeetCode](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) \| [Video](https://www.youtube.com/watch?v=gvwTGXP-reQ) |
| 9 | Medium | [Spiral Matrix](src/main/java/org/example/problems/matrix/medium/SpiralMatrix.java) | Return elements in spiral order. | matrix = [[1,2,3],[4,5,6],[7,8,9]] | [1,2,3,6,9,8,7,4,5] | O(m*n) | [LeetCode](https://leetcode.com/problems/spiral-matrix/) \| NA |
| 10 | Medium | [Rotate Image](src/main/java/org/example/problems/matrix/medium/RotateImage.java) | Rotate matrix 90 degrees clockwise. | matrix = [[1,2,3],[4,5,6],[7,8,9]] | [[7,4,1],[8,5,2],[9,6,3]] | O(m*n) | [LeetCode](https://leetcode.com/problems/rotate-image/) \| NA |

---

### 18. Greedy

| # | Level | Problem | Description | Example Input | Example Output | Complexity | Links |
|---|-------|---------|-------------|--------------|----------------|------------|-------|
| 1 | Medium | [Gas Station](src/main/java/org/example/problems/greedy/medium/GasStation.java) | Find starting station with enough gas. | gas = [1,2,3,4,5], cost = [2,3,4,5,1] | 0 | O(n) | [LeetCode](https://leetcode.com/problems/gas-station/) \| [Video](https://www.youtube.com/watch?v=ENDr9IfRMMw) |
| 2 | Medium | [Partition Labels](src/main/java/org/example/problems/greedy/medium/PartitionLabels.java) | Partition string into as many parts as possible. | s = "ababcbacadefegdehijhklij" | [9,7,8] | O(n) | [LeetCode](https://leetcode.com/problems/partition-labels/) \| [Video](https://www.youtube.com/watch?v=TvWEYhHPO0w) |
| 3 | Medium | [Hand of Straights](src/main/java/org/example/problems/greedy/medium/HandOfStraights.java) | Check if can group cards into consecutive groups. | hand = [1,2,3,6,2,3,4,7,8], groupSize = 3 | true | O(n log n) | [LeetCode](https://leetcode.com/problems/hand-of-straights/) \| [Video](https://www.youtube.com/watch?v=ISHUyNJVq_M) |
| 4 | Medium | [Merge Triplets to Form Target Triplet](src/main/java/org/example/problems/greedy/medium/MergeTripletsToFormTargetTriplet.java) | Check if can form target from triplets. | triplets = [[2,5,3],[1,8,0],[1,2,5],[2,7,5]], target = [1,2,5] | true | O(n) | [LeetCode](https://leetcode.com/problems/merge-triplets-to-form-target-trips/) \| [Video](https://www.youtube.com/watch?v=OVjB6kGr29g) |
| 5 | Medium | [Valid Parenthesis String](src/main/java/org/example/problems/greedy/medium/ValidParenthesisString.java) | Check if string with '(' and '*' is valid. | s = "(*))" | true | O(n) | [LeetCode](https://leetcode.com/problems/valid-parenthesis-string/) \| [Video](https://www.youtube.com/watch?v=h5YxPLC4lWs) |

---

