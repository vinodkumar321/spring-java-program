package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortAlgorithm {
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
        System.out.println("Final Array after Applying Merge Sort : ");
        mergeSort(arr,0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(Integer[] arr, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, right, mid);
        }
    }
    public static void merge(Integer[] arr,int start,int end,int mid) {
        int len1 = mid-start+1;
        int len2 = end-mid;
        Integer[] arr2 = new Integer[len1];
        Integer[] arr3 = new Integer[len2];
        int i,j,k;
        for (i = 0; i < len1; i++) {
            arr2[i] = arr[start+i];
        }
        for (i = 0; i < len2; i++) {
            arr3[i] = arr[mid+1+i];
        }
        k = start;
        i = 0;
        j = 0;
        while(i < len1 && j < len2) {
            if(arr2[i] < arr3[j]) {
                arr[k++] = arr2[i++];
            }else {
                arr[k++] = arr3[j++];
            }
        }
        if(i < len1) {
            while(i < len1) {
                arr[k++] = arr2[i++];
            }
        }else {
            while(j < len2) {
                arr[k++] = arr3[j++];
            }
        }
    }
}
