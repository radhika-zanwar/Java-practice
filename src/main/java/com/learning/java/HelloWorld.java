
package com.learning.java;

import org.apache.commons.lang3.ArrayUtils;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] numInArray = {2,5,8,10};
        ArrayUtils.add(numInArray,6);
        System.out.println(numInArray);
        for (int a : numInArray) {
            System.out.println(a);
        }

    }
}