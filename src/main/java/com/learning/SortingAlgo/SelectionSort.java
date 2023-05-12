package com.learning.SortingAlgo;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,54,21,7,5,9,4};
        for(int i=0; i < arr.length-1; i++) {
            int smallest = i;
            for(int j=i+1; j < arr.length;j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
                // swap
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;

        }
        printArray(arr);
    }
    public static void printArray(int[] array) {
        for(int i=0;i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}






