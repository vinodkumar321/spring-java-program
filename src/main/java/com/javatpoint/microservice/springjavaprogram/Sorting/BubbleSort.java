package com.javatpoint.microservice.springjavaprogram.Sorting;

import java.util.Scanner;

public class BubbleSort {

    /*
    sort neighbouring elements and swap if they not in correct postion, repeat till array size.
    after first pass max element will at last apply same process by leaving max element index-1
    O(n^2) each case
     */

    public static void main(String[] args) {
        Integer n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter Array Elements : ");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        bubbleSort(arr, 0, arr.length - 1);
        System.out.println("After Applying Bubble Sort...");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static void bubbleSort(Integer[] arr, int left, int right) {
        int temp;
        for(int i = right; i > left; i--) {
            for(int j = left; j < i ; j++) {
                if(arr[j] > arr[j+1]) {
                    // swap
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
