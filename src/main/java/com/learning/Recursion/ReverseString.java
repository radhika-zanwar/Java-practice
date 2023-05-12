package com.learning.Recursion;

import static org.apache.commons.lang3.StringUtils.substring;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        int a = s.length()-1;
        Reverse(a,s);
    }
    public static void Reverse(int a, String s) {
        if( a < 0){
            return;
        }
        System.out.print(s.charAt(a));
        Reverse(a-1,s);

    }
}
