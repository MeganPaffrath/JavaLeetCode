package com.meganpaffrath;

/**
 * Runtime: 1 ms, faster than 74.16% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Longest Common Prefix.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */

public class Prob14_LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0)
                return "";
            if (strs.length == 1)
                return strs[0];

            String prefix = "";
            int maxL = strs[0].length();
            int stringCount = strs.length;

            for (int i = 0; i < maxL; i++) { // each possible str index
                boolean charsMatch = true;
                char currChar = strs[0].charAt(i);
                for (int j = 1; j < stringCount; j++) { // j is array index
                    if (strs[j].length() < i + 1 || currChar != strs[j].charAt(i)) {
                        charsMatch = false;
                        break;
                    }
                }
                if (!charsMatch) {
                    break;
                } else {
                    prefix += String.valueOf(strs[0].charAt(i));
                }
            }
            return prefix;
        }
    }
}
