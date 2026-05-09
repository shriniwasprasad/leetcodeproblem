# LeetCode Problems in Java

A comprehensive collection of LeetCode problems solved in Java, organized by category and difficulty level.

## Project Overview

This project contains **190+ LeetCode problems** implemented in Java, covering:
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

## Summary Statistics

| Difficulty | Count |
|------------|-------|
| Easy | ~65 |
| Medium | ~100 |
| Hard | ~25 |
| **Total** | **190** |

## Contributing

Feel free to add more problems or improve existing solutions!

## License

This project is for educational purposes.
