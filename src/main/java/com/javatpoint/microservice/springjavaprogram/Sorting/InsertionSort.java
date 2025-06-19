package com.javatpoint.microservice.springjavaprogram.Sorting;

import java.util.Scanner;

public class InsertionSort {
    /*
      sorting array elements based on insertion order -> like sorting of playing cards in hand
      Assume the first element is already sorted.
      Pick the next element and insert it into its correct position in the sorted part, by swapping the elements
      Repeat until Array is sorted.
      O(n2) in Each case (Worst case & Average case).
      O(n) in best case ( if array already sorted and no swap is performed in first pass
     */
    public static void main(String args[]){
        Integer n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter array Elements : ");
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        insertionSort(arr,0, arr.length-1);
        System.out.println("After Applying Insertion Sort : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertionSort(Integer[] arr,int start,int end){
        int temp;
        for(int i = start; i < end; i++){
            for(int j = i+1; j > start; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}