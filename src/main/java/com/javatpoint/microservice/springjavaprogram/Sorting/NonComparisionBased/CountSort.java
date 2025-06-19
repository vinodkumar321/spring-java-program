package com.javatpoint.microservice.springjavaprogram.Sorting.NonComparisionBased;

import java.util.Scanner;

public class CountSort {

    /*
    assumes each of n input is an 0-n range. which sorts the array in O(n) time.
    works by counting different number of Objects having distinct key values.
    outplace sorting algo.
    T(n) = O(n+k) , k = input range
     */

    public static void main(String[] args) {
        Integer n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter array Elements : ");
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        arr = countSort(arr,0, arr.length-1);
        System.out.println("After Applying Count Sort : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static Integer[] countSort(Integer[] arr,int start,int end){
        int max;
        Integer[] brr = new Integer[arr.length];
        // scan for max element first
        max = arr[start];
        for(int i = start+1; i <= end; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        // now we have max element
        // count array of max+1 size;
        Integer[] count_array = new Integer[max+1];
        for(int i = 0; i <= max; i++){
            count_array[i] = 0;
        }
        for(int i = start; i <= end; i++){
            count_array[arr[i]]++;
        }
        // modify the count array
        for(int i = 1; i <= max; i++){
            count_array[i] += count_array[i-1];
        }
        // modify original array
        for(int i = start; i <= end; i++){
            brr[count_array[arr[i]]-1] = arr[i];
            count_array[arr[i]]--;
        }
        return brr;
    }

}
