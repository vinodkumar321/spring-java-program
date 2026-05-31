package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.Scanner;

public class QuickSortExample {
    public static void main(String args[]){
        // single Pivot Quick Sort
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Length : ");
        Integer n = scanner.nextInt();
        System.out.print("Enter Array : ");
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("After Sorting ");
        QuickSortExample quickSortExample = new QuickSortExample();
        quickSortExample.quickSort(arr,0,n-1);
        for(Integer i : arr){
            System.out.print(i+" ");
        }
    }
    public void quickSort(Integer[] a,int start,int end){
        int partition;
        if(start < end){
            partition = this.partition_index(a,start,end);
            quickSort(a,start,partition-1);
            quickSort(a,partition+1,end);
        }
    }
    public int partition_index(Integer[] arr,int start,int end){
        int pivot,i,j,temp;
        pivot = start;
        i = pivot;
        j = pivot+1;
        while(j <= end){
            if(arr[pivot] > arr[j]){
                temp = arr[++i];
                arr[i] =  arr[j];
                arr[j] = temp;
            }
            j++;
        }
        if(pivot != i){
            temp = arr[pivot];
            arr[pivot] = arr[i];
            arr[i] = temp;
        }
        return i;
    }
}
