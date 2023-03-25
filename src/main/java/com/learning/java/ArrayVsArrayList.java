package com.learning.java;

import java.util.ArrayList;


public class ArrayVsArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Object a = new Object();
        arrList.add(20);
        arrList.add(30);
        arrList.add(40);
        System.out.println(arrList);
        arrList.add(1,33);
        System.out.println(arrList);
        //arrList.remove(1);
        if(arrList.contains(33)) {
            arrList.remove(new Integer(33));
        }
        System.out.println(arrList);
        System.out.println(arrList.size());
        System.out.println(arrList.indexOf(new Integer(40)));
        System.out.println(arrList.indexOf(new Integer(30)));
        int s = (int)Math.random();
        System.out.println(s);
    }
}
