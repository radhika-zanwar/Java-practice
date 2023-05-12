package com.learning.SortingAlgo;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,1,5,32,8,43,3,7};
        int n = arr.length;
        sorting(arr);

    }
    public static void sorting(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high-1;j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        high--;


    }
}
