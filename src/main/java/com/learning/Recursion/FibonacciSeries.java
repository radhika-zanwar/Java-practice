package com.learning.Recursion;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("enter the number of numbers you want to generate");
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        Fibonacci(0,1 , 1, noOfElements);

    }
    public static void Fibonacci(int first, int sec, int i,int noOfElements) {
        if(i == 1) {
            System.out.print(first + " ");
            i++;
            System.out.print(sec + " ");
            i++;
        }
        if(i > noOfElements) {
            return;
        }
        int sum = first + sec;
        System.out.print(sum + " ");
        Fibonacci(sec, sum, i + 1,noOfElements);

    }
}
