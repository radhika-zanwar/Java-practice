package com.learning.SortingAlgo;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {6,21,4,9,7,42,23,5};
        for(int i=0;i<arr.length-1;i++){
            int smallest = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;

                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        PrintArray(arr);
    }
    public static void PrintArray(int[] array){
        for(int i=0;i< array.length;i++){
            System.out.print(array[i] + " ");
        }
    }
}
