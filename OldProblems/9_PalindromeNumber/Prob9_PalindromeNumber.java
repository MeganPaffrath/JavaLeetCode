package com.meganpaffrath;
/**
 * IMPROVE MEMORY USAGE
 * do so by only reverting half of the number?
 *
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

/**
 * Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
 * Memory Usage: 35.9 MB, less than 5.02% of Java online submissions for Palindrome Number.
 */
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

// Splitting x first did not improve time or memory
/**
 * Runtime: 8 ms, faster than 40.40% of Java online submissions for Palindrome Number.
 * Memory Usage: 36.2 MB, less than 5.02% of Java online submissions for Palindrome Number.
 */
//public class Prob9_PalindromeNumber {
//    public boolean isPalindrome(int x) {
//        if (x < 0)
//            return false;
//        int xLength = String.valueOf(x).length();
//        if (xLength == 1)
//            return true;
//        int splitLength = 0;
//        int leadingVals = x;
//        int endingVals = 0;
//        int temp = x;
//
//        if (xLength%2 != 0) { // odd
//            splitLength = (xLength - 1)/2;
//        } else {
//            splitLength = xLength / 2;
//        }
//
//        while (splitLength > 0) { // append to ending vals
//            // Append to ending vals and remove from leading vals
//            endingVals = endingVals*10 + leadingVals%10;
//            leadingVals = leadingVals/10;
//            splitLength--;
//        }
//        if (xLength%2 != 0) { // if odd remove another val from leadingVals
//            leadingVals = leadingVals/10;
//        }
//
//        if (leadingVals == endingVals)
//            return true;
//        return false;
//    }
//}

