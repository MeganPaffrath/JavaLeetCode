package com.meganpaffrath;

public class Main {

    public static void main(String[] args) {
        ReverseInteger problem = new ReverseInteger();
        int reversed123 = problem.reverse(123);
        System.out.println("123 reversed: " + reversed123);
        int reversedNegative123 = problem.reverse(-123);
        System.out.println("-123 reversed: " + reversedNegative123);
        int reversed120 = problem.reverse(120);
        System.out.println("120 reversed: " + reversed120);
    }
}