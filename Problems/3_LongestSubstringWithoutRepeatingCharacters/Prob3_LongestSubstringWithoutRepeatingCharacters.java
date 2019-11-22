package com.meganpaffrath;

/**
 * Runtime: 224 ms, faster than 5.03% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.5 MB, less than 14.63% of Java online submissions for Longest Substring Without Repeating Characters.
 */

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


public class Prob3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        String currString = String.valueOf(s.charAt(0));
        String longestString = String.valueOf(s.charAt(0));


        for (int i = 1; i < s.length(); i++) { // full string
            for (int j = i; j < s.length(); j ++) { // sub check
                boolean repeated = false;
                for (int k = 0; k < currString.length(); k++) { // curr compare
                    if (s.charAt(j) == currString.charAt(k)) {
                        repeated = true;
                        break;
                    }
                }
                if(!repeated) {
                    currString += String.valueOf(s.charAt(j));
                    if (currString.length() > longestString.length()) {
                        longestString = currString;
                    }
                } else {
                    break;
                }
            }
            currString = String.valueOf(s.charAt(i));
        }
        return longestString.length();
    }
}
