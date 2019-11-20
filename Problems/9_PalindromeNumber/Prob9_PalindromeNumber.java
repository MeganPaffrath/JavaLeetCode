package com.meganpaffrath;
/**
 * IMPROVE MEMORY USAGE
 *
 * Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
 * Memory Usage: 35.9 MB, less than 5.02% of Java online submissions for Palindrome Number.
 */


/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 *      Output: true
 *      Example 2:
 *
 * Input: -121
 *      Output: false
 *      Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 *
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */

// IMPROVED METHOD:
public class Prob9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = 0;
        int temp = x;

        // divi
        while (temp > 0) {
            y = y*10 + temp%10;
            temp = temp/10;
        }
        // System.out.println(y);
        if (x == y)
            return true;
        return false;
    }
}

