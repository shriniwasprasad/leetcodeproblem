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

#### Easy
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Best Time to Buy and Sell Stock](src/main/java/org/example/problems/array/easy/BestTimeToBuyAndSellStock.java) | O(n) | [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [Video](https://www.youtube.com/watch?v=CCQBvgPages) |
| 2 | [Contains Duplicate](src/main/java/org/example/problems/array/easy/ContainsDuplicate.java) | O(n) | [Link](https://leetcode.com/problems/contains-duplicate/) | [Video](https://www.youtube.com/watch?v=c_q_Pc2yg_0) |
| 3 | [Contains Duplicate II](src/main/java/org/example/problems/array/easy/ContainsDuplicateIi.java) | O(n) | [Link](https://leetcode.com/problems/contains-duplicate-ii/) | |
| 4 | [Two Sum](src/main/java/org/example/problems/array/easy/TwoSum.java) | O(n) | [Link](https://leetcode.com/problems/two-sum/) | [Video](https://www.youtube.com/watch?v=BQ2IJ-fouJ4) |
| 5 | [Verifying an Alien Dictionary](src/main/java/org/example/problems/array/easy/VerifyingAnAlienDictionary.java) | O(n) | [Link](https://leetcode.com/problems/verifying-an-alien-dictionary/) | |

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Container With Most Water](src/main/java/org/example/problems/array/medium/ContainerWithMostWater.java) | O(n) | [Link](https://leetcode.com/problems/container-with-most-water/) | [Video](https://www.youtube.com/watch?v=wi8fqhNoV-Y) |
| 2 | [Find First and Last Position of Element in Sorted Array](src/main/java/org/example/problems/array/medium/FindFirstAndLastPositionOfElementInSortedArray.java) | O(log n) | [Link](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | |
| 3 | [Find Minimum in Rotated Sorted Array](src/main/java/org/example/problems/array/medium/FindMinimumInRotatedSortedArray.java) | O(log n) | [Link](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | |
| 4 | [Maximum Product Subarray](src/main/java/org/example/problems/array/medium/MaximumProductSubarray.java) | O(n) | [Link](https://leetcode.com/problems/maximum-product-subarray/) | |
| 5 | [Maximum Subarray](src/main/java/org/example/problems/array/medium/MaximumSubarray.java) | O(n) | [Link](https://leetcode.com/problems/maximum-subarray/) | [Video](https://www.youtube.com/watch?v=nr2djEYM7_A) |
| 6 | [N3 Sum](src/main/java/org/example/problems/array/medium/N3Sum.java) | O(n²) | [Link](https://leetcode.com/problems/3sum/) | |
| 7 | [Next Permutation](src/main/java/org/example/problems/array/medium/NextPermutation.java) | O(n) | [Link](https://leetcode.com/problems/next-permutation/) | |
| 8 | [Product of Array Except Self](src/main/java/org/example/problems/array/medium/ProductOfArrayExceptSelf.java) | O(n) | [Link](https://leetcode.com/problems/product-of-array-except-self/) | |
| 9 | [Remove Duplicates from Sorted Array](src/main/java/org/example/problems/array/medium/RemoveDuplicatesFromSortedArray.java) | O(n) | [Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | |
| 10 | [Search in Rotated Sorted Array](src/main/java/org/example/problems/array/medium/SearchInRotatedSortedArray.java) | O(log n) | [Link](https://leetcode.com/problems/search-in-rotated-sorted-array/) | |
| 11 | [Top K Frequent Elements](src/main/java/org/example/problems/array/medium/TopKFrequentElements.java) | O(n log k) | [Link](https://leetcode.com/problems/top-k-frequent-elements/) | |
| 12 | [Two Sum II - Input Array Is Sorted](src/main/java/org/example/problems/array/medium/TwoSumIiInputArrayIsSorted.java) | O(n) | [Link](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | |
| 13 | [Valid Sudoku](src/main/java/org/example/problems/array/medium/ValidSudoku.java) | O(1) | [Link](https://leetcode.com/problems/valid-sudoku/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Median of Two Sorted Arrays](src/main/java/org/example/problems/array/hard/MedianOfTwoSortedArrays.java) | O(log(min(m,n))) | [Link](https://leetcode.com/problems/median-of-two-sorted-arrays/) | |
| 2 | [Trapping Rain Water](src/main/java/org/example/problems/array/hard/TrappingRainWater.java) | O(n) | [Link](https://leetcode.com/problems/trapping-rain-water/) | [Video](https://www.youtube.com/watch?v=AFl_VxaO_F0) |

---

### 2. String

#### Easy
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [FizzBuzz](src/main/java/org/example/problems/string/easy/FizzBuzz.java) | O(n) | [Link](https://leetcode.com/problems/fizz-buzz/) | |
| 2 | [Is Subsequence](src/main/java/org/example/problems/string/easy/IsSubsequence.java) | O(n) | [Link](https://leetcode.com/problems/is-subsequence/) | |
| 3 | [Longest Common Prefix](src/main/java/org/example/problems/string/easy/LongestCommonPrefix.java) | O(s) | [Link](https://leetcode.com/problems/longest-common-prefix/) | |
| 4 | [Palindrome Linked List](src/main/java/org/example/problems/string/easy/PalindromeLinkedList.java) | O(n) | [Link](https://leetcode.com/problems/palindrome-linked-list/) | |
| 5 | [Remove Palindromic Subsequences](src/main/java/org/example/problems/string/easy/RemovePalindromicSubsequences.java) | O(n) | [Link](https://leetcode.com/problems/remove-palindromic-subsequences/) | |
| 6 | [Reverse Vowels of a String](src/main/java/org/example/problems/string/easy/ReverseVowelsOfAString.java) | O(n) | [Link](https://leetcode.com/problems/reverse-vowels-of-a-string/) | |
| 7 | [Valid Anagram](src/main/java/org/example/problems/string/easy/ValidAnagram.java) | O(n) | [Link](https://leetcode.com/problems/valid-anagram/) | |
| 8 | [Valid Palindrome](src/main/java/org/example/problems/string/easy/ValidPalindrome.java) | O(n) | [Link](https://leetcode.com/problems/valid-palindrome/) | |
| 9 | [Valid Parentheses](src/main/java/org/example/problems/string/easy/ValidParentheses.java) | O(n) | [Link](https://leetcode.com/problems/valid-parentheses/) | [Video](https://www.youtube.com/watch?v=D4l9TK0tWcI) |

#### Medium
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Encode and Decode Strings](src/main/java/org/example/problems/string/medium/EncodeAndDecodeStrings.java) | O(n) | [Link](https://leetcode.com/problems/encode-and-decode-strings/) | |
| 2 | [Group Anagrams](src/main/java/org/example/problems/string/medium/GroupAnagrams.java) | O(n * k log k) | [Link](https://leetcode.com/problems/group-anagrams/) | [Video](https://www.youtube.com/watch?v=dEMcIpBOHpg) |
| 3 | [Letter Combinations of a Phone Number](src/main/java/org/example/problems/string/medium/LetterCombinationsOfAPhoneNumber.java) | O(4^n) | [Link](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | |
| 4 | [Longest Palindromic Substring](src/main/java/org/example/problems/string/medium/LongestPalindromicSubstring.java) | O(n²) | [Link](https://leetcode.com/problems/longest-palindromic-substring/) | |
| 5 | [Longest Repeating Character Replacement](src/main/java/org/example/problems/string/medium/LongestRepeatingCharacterReplacement.java) | O(n) | [Link](https://leetcode.com/problems/longest-repeating-character-replacement/) | |
| 6 | [Longest Substring Without Repeating Characters](src/main/java/org/example/problems/string/medium/LongestSubstringWithoutRepeatingCharacters.java) | O(n) | [Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [Video](https://www.youtube.com/watch?v=RMQ-gRQAY0o) |
| 7 | [Palindromic Substrings](src/main/java/org/example/problems/string/medium/PalindromicSubstrings.java) | O(n²) | [Link](https://leetcode.com/problems/palindromic-substrings/) | |
| 8 | [Reverse Words in a String](src/main/java/org/example/problems/string/medium/ReverseWordsInAString.java) | O(n) | [Link](https://leetcode.com/problems/reverse-words-in-a-string/) | |

#### Hard
| # | Problem | Complexity | LeetCode Link | Video |
|---|---------|------------|---------------|-------|
| 1 | [Minimum Window Substring](src/main/java/org/example/problems/string/hard/MinimumWindowSubstring.java) | O(n) | [Link](https://leetcode.com/problems/minimum-window-substring/) | |
| 2 | [Text Justification](src/main/java/org/example/problems/string/hard/TextJustification.java) | O(n) | [Link](https://leetcode.com/problems/text-justification/) | |

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
