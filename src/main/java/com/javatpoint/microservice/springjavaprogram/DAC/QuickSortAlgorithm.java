package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Scanner;

public class QuickSortAlgorithm {
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
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(Integer[] arr, int left, int right) {
        int pivot;
        if (left < right) {
             // pivot = partitionUsingPivotAsFirstElement(arr, left, right);
             //pivot = partitionUsingPivotAsLastElement(arr, left, right);
            pivot = partitionUsingPivotAsMidElement(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }

    public static int partitionUsingPivotAsFirstElement(Integer[] arr, int left, int right) {
         int pivot,i,j,temp;
         pivot = arr[left];
         i = left;
         j = i+1;
         while (j <= right) {
             if(pivot > arr[j]) {
                 i++;
                 temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
             }
             j++;
         }
         if(i != left){
             temp = arr[i];
             arr[i] = arr[left];
             arr[left] = temp;
         }
         return i;
    }

    public static int partitionUsingPivotAsLastElement(Integer[] arr, int left, int right) {
        int pivot,i,j,temp;
        pivot = arr[right];
        i = left;
        j = i;
        while (j < right) {
            if(pivot > arr[j]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        if(i != right){
            temp = arr[i];
            arr[i] = arr[right];
            arr[right] = temp;
        }
        return i;
    }

    public static int partitionUsingPivotAsMidElement(Integer[] arr, int left, int right) {
        int pivot,i,j,temp;
        pivot = arr[(left+right)/2];
        i = left;
        j = i+1;
        // swap pivot with first element
        temp = arr[i];
        arr[i] = arr[(left+right)/2];
        arr[(left+right)/2] = temp;

        while (j <= right) {
            if(pivot > arr[j]) {
                    i++;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            j++;
        }
        if(i != left){
            temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
        }
        return i;
    }

}
