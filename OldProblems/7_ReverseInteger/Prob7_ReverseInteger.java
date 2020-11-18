package com.meganpaffrath;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *     Input: 123
 *     Output: 321
 * Example 2:
 *     Input: -123
 *     Output: -321
 * Example 3:
 *     Input: 120
 *     Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */

public class Prob7_ReverseInteger {
    public int reverse(int x) {
        // MAX = 2147483647
        // MIN = -2147483648
        int reversedValue = 0;
        while (x != 0) {
            int newDigit = x % 10;
            x /= 10;
            if (reversedValue > Integer.MAX_VALUE / 10 || (reversedValue == Integer.MAX_VALUE / 10 && newDigit > 7)) {
                return 0;
            }
            if (reversedValue < Integer.MIN_VALUE / 10 || (reversedValue == Integer.MIN_VALUE / 10 && newDigit > 8)) {
                return 0;
            }
            reversedValue = reversedValue * 10 + newDigit;
        }
        return reversedValue;
    }
}

/**
 * public class Main {
 *
 *     public static void main(String[] args) {
 *         Prob7_ReverseInteger problem = new Prob7_ReverseInteger();
 *         int reversed123 = problem.reverse(123);
 *         System.out.println("123 reversed: " + reversed123);
 *         int reversedNegative123 = problem.reverse(-123);
 *         System.out.println("-123 reversed: " + reversedNegative123);
 *         int reversed120 = problem.reverse(120);
 *         System.out.println("120 reversed: " + reversed120);
 *     }
 *
 * }
 *
 * --------------------------------------
 *
 * Output:
 * 123 reversed: 321
 * -123 reversed: -321
 * 120 reversed: 21
 */