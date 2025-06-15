package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Scanner;

public class SelectionProcedure {
    public static void main(String[] args) {
        Integer n,k;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter Array Elements : ");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter kth smallest Element Index : ");
        k = scanner.nextInt();
        System.out.println("kth Smallest Element : "+selectionProcedure(arr,0,arr.length-1,k));
    }

    public static Integer selectionProcedure(Integer[] arr,int start,int end,int k) {
        int pivot_index;
        if(start <= end && k >= start && k <= end) {
            pivot_index = partitionUsingPivotAsFirstElement(arr,start,end);
            if(pivot_index == k) {
                return arr[pivot_index];
            } else if (pivot_index > k) {
                // apply selection procedure left side
                return selectionProcedure(arr,start,pivot_index-1,k);
            }else{
                // apply selection procedure right side
                return selectionProcedure(arr,pivot_index+1,end,k);
            }
        }else{
            throw new ArrayIndexOutOfBoundsException("k should be greater than start and less than end");
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

}
