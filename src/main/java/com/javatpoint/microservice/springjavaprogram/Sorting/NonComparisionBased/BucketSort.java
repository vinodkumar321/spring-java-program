package com.javatpoint.microservice.springjavaprogram.Sorting.NonComparisionBased;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BucketSort {
    /*
     Bucket Sort mainly useful when i/p is distributed uniformly across a range.
     d=sort large set of floating-point numbers let's say 0.0. to 1.0
     create n bucket, keep each element in n*element bucket
     now sort each bucket using insertion sort,
     after that concatenate all the sorted bucket
     non-comparision based , stable out-place sorting algorithm.
     O(n)
     */

    public static void main(String[] args) {
        Integer n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter array Elements : ");
        Float[] arr = new Float[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextFloat();
        }
        bucketSort(arr,0, arr.length-1);
        System.out.println("After Applying Bucket Sort : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bucketSort(Float[] arr, int start, int end){
        List<Float>[] list = new ArrayList[10];
        int size,count;
        Float[] temp;
        count = 0;
        for(int i = 0; i <= 9; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = start; i <= end; i++){
            list[(int) ((10*arr[i])%10)].add(arr[i]);
        }
        // sort each list using insertion sort
        for(int i = 0; i <= 9; i++){
            size = list[i].size();
            if(size != 0) {
                temp = new Float[size];
                for (int j = 0; j < size; j++) {
                    temp[j] = list[i].get(j);
                }
                insertionSort(temp, 0, size - 1);
                for (int j = 0; j < size; j++) {
                    arr[count+j] = temp[j];
                }
                count += size;
            }
        }
    }

    public static void insertionSort(Float[] arr,int start,int end){
        float temp;
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
