package com.learning.Patterns;

public class ButterflyPattern {
    public static void main(String[] args) {
        int n = 4;
        for(int i=1; i <= n; i++) {
            for(int j=1; j <= i; j++) {
                System.out.print("*");
            }
            for(int j=1; j <= (n-i)*2; j++) {
                System.out.print(" ");
            }
            for(int j=1; j <= i ;j++) {
                System.out.print("*");

            }
            System.out.println();
        }
        for(int i=n; i>0; i--) {
            for(int j=i; j>0;j--) {
                System.out.print("*");
            }
            for(int j= (n-i)*2; j > 0 ;j--) {
                System.out.print(" ");
            }
            for(int j=i; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
