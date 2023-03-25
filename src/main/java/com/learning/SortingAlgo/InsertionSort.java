package com.learning.SortingAlgo;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {65, 2, 98, 6, 9, 11, 23, 5};
        System.out.println("---Before Sort---");
        PrintArray(arr);
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current < arr[j]) {
                    int temp = arr[j];
                    arr[j] = current;
                    arr[i] = temp;
                    i--;// swap with position of curr elem being compared
                }
            }
        }
        System.out.println("--AfterSort--");
        PrintArray(arr);
        System.out.println("---end of program");
    }


    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

