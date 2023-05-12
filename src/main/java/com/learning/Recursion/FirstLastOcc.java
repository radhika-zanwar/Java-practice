package com.learning.Recursion;

public class FirstLastOcc {
    public static void main(String[] args) {
        String s = "uweghnvwdbhwwhy";
        char element = 'a';
        int index = 0;
        Occurence(s,element,index);


    }
    public static void Occurence(String s,char element, int index) {
        char currentChar = s.charAt(index);
        Occurence(s,element,index + 1);

    }
}