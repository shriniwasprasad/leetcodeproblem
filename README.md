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

#### Easy
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Detect Cycle in a Linked List](src/main/java/org/example/problems/linkedlist/easy/DetectCycleInALinkedList.java) | O(n) | [Link](https://leetcode.com/problems/linked-list-cycle/) | |
| 2 | [LinkedList Cycle](src/main/java/org/example/problems/linkedlist/easy/LinkedListCycle.java) | O(n) | [Link](https://leetcode.com/problems/linked-list-cycle/) | |
| 3 | [Merge Two Sorted Lists](src/main/java/org/example/problems/linkedlist/easy/MergeTwoSortedLists.java) | O(n+m) | [Link](https://leetcode.com/problems/merge-two-sorted-lists/) | |
| 4 | [Middle of the Linked List](src/main/java/org/example/problems/linkedlist/easy/MiddleOfTheLinkedlist.java) | O(n) | [Link](https://leetcode.com/problems/middle-of-the-linked-list/) | |
| 5 | [Reverse A Linked List](src/main/java/org/example/problems/linkedlist/easy/ReverseALinkedList.java) | O(n) | [Link](https://leetcode.com/problems/reverse-linked-list/) | |
| 6 | [Reverse Linked List](src/main/java/org/example/problems/linkedlist/easy/ReverseLinkedList.java) | O(n) | [Link](https://leetcode.com/problems/reverse-linked-list/) | [Video](https://www.youtube.com/watch?v=FHhItaCZ2pE) |

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Add Two Numbers](src/main/java/org/example/problems/linkedlist/medium/AddTwoNumbers.java) | O(max(m,n)) | [Link](https://leetcode.com/problems/add-two-numbers/) | |
| 2 | [Copy List with Random Pointer](src/main/java/org/example/problems/linkedlist/medium/CopyListWithRandomPointer.java) | O(n) | [Link](https://leetcode.com/problems/copy-list-with-random-pointer/) | |
| 3 | [LRU Cache](src/main/java/org/example/problems/linkedlist/medium/LruCache.java) | O(1) | [Link](https://leetcode.com/problems/lru-cache/) | |
| 4 | [Remove Nth Node From End of List](src/main/java/org/example/problems/linkedlist/medium/RemoveNthNodeFromEndOfList.java) | O(n) | [Link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | |
| 5 | [Reorder List](src/main/java/org/example/problems/linkedlist/medium/ReorderList.java) | O(n) | [Link](https://leetcode.com/problems/reorder-list/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Merge K Sorted Lists](src/main/java/org/example/problems/linkedlist/hard/MergeKSortedLists.java) | O(n log k) | [Link](https://leetcode.com/problems/merge-k-sorted-lists/) | |
| 2 | [Reverse Nodes in K-Group](src/main/java/org/example/problems/linkedlist/hard/ReverseNodesInKGroup.java) | O(n) | [Link](https://leetcode.com/problems/reverse-nodes-in-k-group/) | |

---

### 4. Tree

#### Easy
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Balanced Binary Tree](src/main/java/org/example/problems/tree/easy/BalancedBinaryTree.java) | O(n) | [Link](https://leetcode.com/problems/balanced-binary-tree/) | |
| 2 | [Diameter of Binary Tree](src/main/java/org/example/problems/tree/easy/DiameterOfBinaryTree.java) | O(n) | [Link](https://leetcode.com/problems/diameter-of-binary-tree/) | |
| 3 | [Invert Binary Tree](src/main/java/org/example/problems/tree/easy/InvertBinaryTree.java) | O(n) | [Link](https://leetcode.com/problems/invert-binary-tree/) | |
| 4 | [Maximum Depth of Binary Tree](src/main/java/org/example/problems/tree/easy/MaximumDepthOfBinaryTree.java) | O(n) | [Link](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | |
| 5 | [Same Tree](src/main/java/org/example/problems/tree/easy/SameTree.java) | O(n) | [Link](https://leetcode.com/problems/same-tree/) | |
| 6 | [Subtree of Another Tree](src/main/java/org/example/problems/tree/easy/SubtreeOfAnotherTree.java) | O(n*m) | [Link](https://leetcode.com/problems/subtree-of-another-tree/) | |
| 7 | [Symmetric Tree](src/main/java/org/example/problems/tree/easy/SymmetricTree.java) | O(n) | [Link](https://leetcode.com/problems/symmetric-tree/) | |

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Add and Search Word](src/main/java/org/example/problems/tree/medium/AddAndSearchWord.java) | O(n) | [Link](https://leetcode.com/problems/add-and-search-word-data-structure-design/) | |
| 2 | [Binary Tree Level Order Traversal](src/main/java/org/example/problems/tree/medium/BinaryTreeLevelOrderTraversal.java) | O(n) | [Link](https://leetcode.com/problems/binary-tree-level-order-traversal/) | |
| 3 | [Binary Tree Right Side View](src/main/java/org/example/problems/tree/medium/BinaryTreeRightSideView.java) | O(n) | [Link](https://leetcode.com/problems/binary-tree-right-side-view/) | |
| 4 | [Binary Tree Zigzag Level Order Traversal](src/main/java/org/example/problems/tree/medium/BinaryTreeZigzagLevelOrderTraversal.java) | O(n) | [Link](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | |
| 5 | [Construct Binary Tree from Preorder and Inorder Traversal](src/main/java/org/example/problems/tree/medium/ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | O(n) | [Link](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | |
| 6 | [Kth Smallest Element in a BST](src/main/java/org/example/problems/tree/medium/KthSmallestElementInABst.java) | O(n) | [Link](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | |
| 7 | [Lowest Common Ancestor of BST](src/main/java/org/example/problems/tree/medium/LowestCommonAncestorOfBst.java) | O(h) | [Link](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | |
| 8 | [Validate Binary Search Tree](src/main/java/org/example/problems/tree/medium/ValidateBinarySearchTree.java) | O(n) | [Link](https://leetcode.com/problems/validate-binary-search-tree/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Binary Tree Maximum Path Sum](src/main/java/org/example/problems/tree/hard/BinaryTreeMaximumPathSum.java) | O(n) | [Link](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | |
| 2 | [Serialize and Deserialize Binary Tree](src/main/java/org/example/problems/tree/hard/SerializeAndDeserializeBinaryTree.java) | O(n) | [Link](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | |

---

### 5. Graph

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Clone Graph](src/main/java/org/example/problems/graph/medium/CloneGraph.java) | O(n) | [Link](https://leetcode.com/problems/clone-graph/) | |
| 2 | [Course Schedule](src/main/java/org/example/problems/graph/medium/CourseSchedule.java) | O(n + e) | [Link](https://leetcode.com/problems/course-schedule/) | |
| 3 | [Course Schedule II](src/main/java/org/example/problems/graph/medium/CourseScheduleIi.java) | O(n + e) | [Link](https://leetcode.com/problems/course-schedule-ii/) | |
| 4 | [Graph Valid Tree](src/main/java/org/example/problems/graph/medium/GraphValidTree.java) | O(n) | [Link](https://leetcode.com/problems/graph-valid-tree/) | |
| 5 | [Number of Connected Components in an Undirected Graph](src/main/java/org/example/problems/graph/medium/NumberOfConnectedComponentsInAnUndirectedGraph.java) | O(n + e) | [Link](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) | |
| 6 | [Number of Islands](src/main/java/org/example/problems/graph/medium/NumberOfIslands.java) | O(n*m) | [Link](https://leetcode.com/problems/number-of-islands/) | [Video](https://www.youtube.com/watch?v=H-2Nh2RXX6g) |
| 7 | [Number of Provinces](src/main/java/org/example/problems/graph/medium/NumberOfProvinces.java) | O(n²) | [Link](https://leetcode.com/problems/number-of-provinces/) | |
| 8 | [Pacific Atlantic Water Flow](src/main/java/org/example/problems/graph/medium/PacificAtlanticWaterFlow.java) | O(n*m) | [Link](https://leetcode.com/problems/pacific-atlantic-water-flow/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Alien Dictionary](src/main/java/org/example/problems/graph/hard/AlienDictionary.java) | O(n) | [Link](https://leetcode.com/problems/alien-dictionary/) | |
| 2 | [Word Ladder](src/main/java/org/example/problems/graph/hard/WordLadder.java) | O(n * m²) | [Link](https://leetcode.com/problems/word-ladder/) | |

---

### 6. Dynamic Programming

#### Easy
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Climbing Stairs](src/main/java/org/example/problems/dynamicprogramming/easy/ClimbingStairs.java) | O(n) | [Link](https://leetcode.com/problems/climbing-stairs/) | |
| 2 | [Min Cost Climbing Stairs](src/main/java/org/example/problems/dynamicprogramming/easy/MinCostClimbingStairs.java) | O(n) | [Link](https://leetcode.com/problems/min-cost-climbing-stairs/) | |
| 3 | [Pascals Triangle](src/main/java/org/example/problems/dynamicprogramming/easy/PascalsTriangle.java) | O(n²) | [Link](https://leetcode.com/problems/pascals-triangle/) | |

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Coin Change II](src/main/java/org/example/problems/dynamicprogramming/medium/CoinChangeIi.java) | O(amount * n) | [Link](https://leetcode.com/problems/coin-change-ii/) | [Video](https://www.youtube.com/watch?v=khIBdTrRggk) |
| 2 | [Longest Common Subsequence](src/main/java/org/example/problems/dynamicprogramming/medium/LongestCommonSubsequence.java) | O(m*n) | [Link](https://leetcode.com/problems/longest-common-subsequence/) | |
| 3 | [Unique Paths](src/main/java/org/example/problems/dynamicprogramming/medium/UniquePaths.java) | O(m*n) | [Link](https://leetcode.com/problems/unique-paths/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Regular Expression Matching](src/main/java/org/example/problems/dynamicprogramming/hard/RegularExpressionMatching.java) | O(m*n) | [Link](https://leetcode.com/problems/regular-expression-matching/) | |

---

### 7. Heap & Priority Queue

#### Easy
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [High Five](src/main/java/org/example/problems/heap/easy/HighFive.java) | O(n log k) | [Link](https://leetcode.com/problems/high-five/) | |
| 2 | [Kth Largest Element in a Stream](src/main/java/org/example/problems/heap/easy/KthLargestElementInAStream.java) | O(n log k) | [Link](https://leetcode.com/problems/kth-largest-element-in-a-stream/) | |
| 3 | [Last Stone Weight](src/main/java/org/example/problems/heap/easy/LastStoneWeight.java) | O(n log n) | [Link](https://leetcode.com/problems/last-stone-weight/) | |

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Kth Largest Element in an Array](src/main/java/org/example/problems/heap/medium/KthLargestElementInAnArray.java) | O(n log k) | [Link](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [Video](https://www.youtube.com/watch?v=kmUL7CAOSwc) |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Find Median from Data Stream](src/main/java/org/example/problems/heap/hard/FindMedianFromDataStream.java) | O(log n) | [Link](https://leetcode.com/problems/find-median-from-data-stream/) | |

---

### 8. Backtracking

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Combination Sum II](src/main/java/org/example/problems/backtracking/medium/CombinationSumIi.java) | O(2^n) | [Link](https://leetcode.com/problems/combination-sum-ii/) | |
| 2 | [Palindrome Partitioning](src/main/java/org/example/problems/backtracking/medium/PalindromePartitioning.java) | O(n * 2^n) | [Link](https://leetcode.com/problems/palindrome-partitioning/) | |
| 3 | [Permutations](src/main/java/org/example/problems/backtracking/medium/Permutations.java) | O(n!) | [Link](https://leetcode.com/problems/permutations/) | |
| 4 | [Subsets](src/main/java/org/example/problems/backtracking/medium/Subsets.java) | O(2^n) | [Link](https://leetcode.com/problems/subsets/) | |
| 5 | [Subsets II](src/main/java/org/example/problems/backtracking/medium/SubsetsIi.java) | O(2^n) | [Link](https://leetcode.com/problems/subsets-ii/) | |
| 6 | [Word Search](src/main/java/org/example/problems/backtracking/medium/WordSearch.java) | O(n * 3^n) | [Link](https://leetcode.com/problems/word-search/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [N-Queens](src/main/java/org/example/problems/backtracking/hard/NQueens.java) | O(n!) | [Link](https://leetcode.com/problems/n-queens/) | |

---

### 9. Stack

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Min Stack](src/main/java/org/example/problems/stack/medium/MinStack.java) | O(1) | [Link](https://leetcode.com/problems/min-stack/) | [Video](https://www.youtube.com/watch?v=To2iap-ac3g) |

---

### 10. Matrix

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Spiral Matrix](src/main/java/org/example/problems/matrix/medium/SpiralMatrix.java) | O(m*n) | [Link](https://leetcode.com/problems/spiral-matrix/) | |

---

### 11. Interval

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Merge Intervals](src/main/java/org/example/problems/interval/medium/MergeIntervals.java) | O(n log n) | [Link](https://leetcode.com/problems/merge-intervals/) | [Video](https://www.youtube.com/watch?v=n3F2v9f8OfY) |

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
