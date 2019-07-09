package com.meganpaffrath;

public class Main {
    public static void main( String[] args ) {
        final Problem_7 problem7 = new Problem_7();
        System.out.println("\t1534236469: " + problem7.reverse(1534236469));
        System.out.println("\t1463847412: " + problem7.reverse(1463847412));
        System.out.println("\t50231: " + problem7.reverse(50231));
        System.out.println("\t231: " + problem7.reverse(231));
        System.out.println("\t230: " + problem7.reverse(230));
        System.out.println("\t123: " + problem7.reverse(123));
        System.out.println("\t120: " + problem7.reverse(120));
        System.out.println("\t21: " + problem7.reverse(21));
        System.out.println("\t2: " + problem7.reverse(2));
        System.out.println("\t1: " + problem7.reverse(1));
        System.out.println("\t-3: " + problem7.reverse(-3));
        System.out.println("\t-31: " + problem7.reverse(-31));
        System.out.println("\t-123: " + problem7.reverse(-123));
        System.out.println("\t-231: " + problem7.reverse(-231));
        System.out.println("\t-232: " + problem7.reverse(-232));
        problem7.testfunct();
    }
}
