package com.learning.SortingAlgo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 3, 7, 10, 12};
        int result = BS(arr,7);

        System.out.print("Index of key is " + result);
    }
    public static int BS(int[] arr, int key) {

        int low = 0;//3
        int high = arr.length - 1;//5 3
        while(low <= high) {
            int mid = (low + high) / 2;//4
            if (arr[mid] == key) {
                return mid;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            }
        }

        return -1;
    }

}
