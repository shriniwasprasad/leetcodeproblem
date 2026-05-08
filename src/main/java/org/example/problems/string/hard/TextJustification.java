package string.hard;

import java.util.*;

/**
 * Problem: Text Justification
 * Topic: String
 * Level: Hard
 *
 * Problem Description:
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth
 * characters and is fully (left and right) justified.
 *
 * You should pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line
 * has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
 * does not divide evenly between words, the empty slots on the left will be assigned more spaces than the
 * slots on the right.
 *
 * For the last line of text, it should be left-justified and no extra space is inserted between words.
 *
 * Hint: Greedily add words to a line until the next word would exceed maxWidth. Then calculate total spaces needed and distribute them using division and modulo.
 *
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Expected Output:
 * [
 *    "This    is    an",
 *    "example of text ",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Expected Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 *
 * Constraints:
 * - 1 <= words.length <= 300
 * - 1 <= words[i].length <= 20
 * - 1 <= maxWidth <= 300
 * - words[i] contains only English letters and symbols
 * - 1 <= max(words[i].length) <= maxWidth
 *
 * Video Explanation: https://www.youtube.com/watch?v=Pf_1Ox9ud_w
 * LeetCode Problem Link: https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public static void main(String[] args) {
        System.out.println("=== TextJustification ===");
        
        // Test case 1: Classic example
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result1 = (List<String>) solution(words1, 16);
        System.out.println("Test 1 (maxWidth=16):");
        for (String line : result1) {
            System.out.println("|" + line + "|"); // Show boundaries
        }
        
        // Test case 2: Single word per line
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> result2 = (List<String>) solution(words2, 16);
        System.out.println("\nTest 2 (maxWidth=16):");
        for (String line : result2) {
            System.out.println("|" + line + "|");
        }
        
        // Test case 3: Simple case
        String[] words3 = {"Science", "is", "what", "we", "understand", "well"};
        List<String> result3 = (List<String>) solution(words3, 20);
        System.out.println("\nTest 3 (maxWidth=20):");
        for (String line : result3) {
            System.out.println("|" + line + "|");
        }
        
        // Test case 4: Single word
        String[] words4 = {"justification"};
        List<String> result4 = (List<String>) solution(words4, 16);
        System.out.println("\nTest 4 (single word, maxWidth=16):");
        for (String line : result4) {
            System.out.println("|" + line + "|");
        }
        
        System.out.println("\nAlternative Solution:");
        String[] words5 = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result5 = (List<String>) alternativeSolution(words5, 16);
        System.out.println("Test 1 (maxWidth=16):");
        for (String line : result5) {
            System.out.println("|" + line + "|");
        }
    }

    /**
     * Solution 1: Greedy Line Construction with Justification (Clear and Modular)
     * 
     * Time Complexity: O(n * m) where n is number of words, m is maxWidth
     * Space Complexity: O(1) excluding output
     * 
     * Algorithm:
     * - Step 1: Pack words into lines greedily
     * - Step 2: Justify each line by distributing spaces
     * - Step 3: Handle last line with left justification
     * 
     * How it works with words=["This", "is", "an", "example", "of", "text"], maxWidth=16:
     * 1. Line 1 packing: "This" (4) + "is" (2) + "an" (2) = 8 chars + 2 gaps = 10 chars (fits)
     *    Add "example" (7): 8 + 1 + 7 = 16 total (fits exactly)
     *    Can't add "of": 8 + 2 + 2 = 12, but would need 3 (exceeds)
     *    -> Line 1: ["This", "is", "an"]
     * 
     * 2. Justification: 3 words, 9 chars, 16 width
     *    Spaces needed: 16 - 9 = 7 spaces for 2 gaps
     *    7/2 = 3 spaces, 7%2 = 1 extra
     *    -> "This" + 4 spaces + "is" + 3 spaces + "an"
     * 
     * 3. Continue with remaining words
     * 4. Last line: left-justify with single spaces
     */
    public static Object solution(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0; // Length without spaces
        
        for (String word : words) {
            // If adding word exceeds maxWidth, justify and add current line
            if (lineLength + word.length() + line.size() > maxWidth) {
                result.add(justifyLine(line, maxWidth, false));
                line = new ArrayList<>();
                lineLength = 0;
            }
            
            // Add word to current line
            line.add(word);
            lineLength += word.length();
        }
        
        // Last line - left justified
        if (!line.isEmpty()) {
            result.add(justifyLine(line, maxWidth, true));
        }
        
        return result;
    }
    
    /**
     * Helper method: Justify a single line
     * 
     * Parameters:
     * - line: list of words in this line
     * - maxWidth: target width
     * - isLast: true if this is the last line (left-justify only)
     * 
     * Algorithm:
     * 1. Calculate total spaces needed
     * 2. Distribute spaces evenly between words
     * 3. Handle extra spaces (assign to leftmost gaps first)
     */
    private static String justifyLine(List<String> line, int maxWidth, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        
        if (isLast) {
            // Last line: left justify with single spaces
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i));
                if (i < line.size() - 1) {
                    sb.append(" "); // Single space between words
                }
            }
        } else {
            // Middle lines: full justification
            int totalChars = 0;
            for (String word : line) {
                totalChars += word.length();
            }
            
            int totalSpaces = maxWidth - totalChars;
            int gaps = line.size() - 1;
            
            if (gaps == 0) {
                // Single word: add spaces to the right
                sb.append(line.get(0));
            } else {
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                
                for (int i = 0; i < line.size(); i++) {
                    sb.append(line.get(i));
                    
                    if (i < line.size() - 1) {
                        // Add base spaces
                        for (int j = 0; j < spacesPerGap; j++) {
                            sb.append(" ");
                        }
                        // Add extra space to leftmost gaps
                        if (i < extraSpaces) {
                            sb.append(" ");
                        }
                    }
                }
            }
        }
        
        // Pad right side with spaces to reach maxWidth
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        
        return sb.toString();
    }

    /**
     * Solution 2: Greedy with Combined Line Building and Justification
     * 
     * Time Complexity: O(n * m) same as Solution 1
     * Space Complexity: O(1) excluding output
     * 
     * Algorithm:
     * - Different approach to building lines and justifying
     * - Pack words, then build the formatted line directly
     * - More streamlined logic in single method
     * 
     * Pros: Combines line packing and justification
     * Cons: Less modular than Solution 1
     */
    public static Object alternativeSolution(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            // Step 1: Collect words for current line
            List<String> currentLine = new ArrayList<>();
            int lineLength = 0;
            
            // Pack as many words as possible in this line
            while (index < words.length) {
                String word = words[index];
                // Check if adding this word exceeds maxWidth
                // lineLength + word.length() is character count
                // currentLine.size() is number of spaces needed (minimum)
                if (lineLength + word.length() + currentLine.size() > maxWidth) {
                    break;
                }
                currentLine.add(word);
                lineLength += word.length();
                index++;
            }
            
            // Step 2: Format and justify this line
            boolean isLastLine = (index == words.length);
            String formattedLine = formatLine(currentLine, lineLength, maxWidth, isLastLine);
            result.add(formattedLine);
        }
        
        return result;
    }
    
    /**
     * Helper method: Format a line with proper justification
     * 
     * Alternative implementation of justification logic
     */
    private static String formatLine(List<String> words, int charCount, int maxWidth, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        
        if (isLast) {
            // Last line: left-justify
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if (i < words.size() - 1) {
                    sb.append(" ");
                }
            }
        } else {
            // Full justification
            int numGaps = words.size() - 1;
            
            if (numGaps == 0) {
                // Single word line
                sb.append(words.get(0));
            } else {
                // Multiple words
                int totalSpaces = maxWidth - charCount;
                int spacesPerGap = totalSpaces / numGaps;
                int extraSpaces = totalSpaces % numGaps;
                
                for (int i = 0; i < words.size(); i++) {
                    sb.append(words.get(i));
                    
                    if (i < words.size() - 1) {
                        // Add spaces between words
                        int spacesToAdd = spacesPerGap + (i < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spacesToAdd; j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
        }
        
        // Pad to reach maxWidth
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        
        return sb.toString();
    }
}
