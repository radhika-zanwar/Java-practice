package com.learning.Recursion;

public class HanoiTower {
    public static void main(String[] args) {
        int n = 3;
        String src = "S";
        String helper = "H";
        String dest = "D";
        HanoiCalc(n,src,helper,dest);

    }
    public static void HanoiCalc(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        HanoiCalc(n-1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        HanoiCalc(n-1, helper, src, dest);
    }
}
