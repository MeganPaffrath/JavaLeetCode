package com.meganpaffrath;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        JewelsAndStones problemJS = new JewelsAndStones();

        int retVal1 = problemJS.numJewelsInStones("z", "ZZz");
        System.out.println(retVal1);

        int retVal2 = problemJS.numJewelsInStones("zAc", "ZZaaAz");
        System.out.println(retVal2);
    }
}