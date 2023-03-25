package com.learning.threads;

public class Application {
    public static void main(String[] args) {
        int test = 10;
        f0();
        f1();
    }
    static void f1(){
        String name = "Radhika";
        f2();
    }
    static void f2(){
        try {
            throw new RuntimeException();
        }
        catch (Exception e){

            System.out.println("Exception Caught  ------"+ e);
        }
        System.out.println("Oh I got executed, means program handled exception well");
    }
    static void f0(){
        System.out.println("skip me");
    }
}
