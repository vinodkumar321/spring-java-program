package com.javatpoint.microservice.springjavaprogram.Sorting;

import java.util.Scanner;

public class TimSort {
    public static void main(String args[]){
        Integer n,run_size;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter array Elements : ");
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter Run Size : ");
        run_size = scanner.nextInt();
        timSort(arr,run_size);
        System.out.println("After Applying Tim-sort Algorithm : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void timSort(Integer[] arr, int size){
        int start,end,left,right,mid;
        start = 0;
        end = arr.length-1;
        for(int i = start; i <= end; i+=size){
            insertionSort(arr,i,Math.min(i+size-1,end));
        }
        // run chunks are sorted and now merge the sorted run chunks
        System.out.println("run chunks are sorted and now merge the sorted run chunks");
        for(int i = size; i <= end; i=2*i){
            System.out.println("i : "+i+" run : "+size);
            for(int j = 0; j <= end; j += 2*i){
                left = j;
                right = Math.min(j+2*i-1,end);
                mid = left+i-1;
                if(mid < right){
                    merge(arr,left,right,mid);
                }

            }
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
