package com.javatpoint.microservice.springjavaprogram.Sorting.NonComparisionBased;

import java.util.Scanner;

public class RadixSort {
    /*
    Radix sort idea is sort input digit by digit start from LSD (Least significant digit) to MSD (Most significant digit)
    uses counting sort as subroutine to sort the elements.
    T(n) = O(d*(n+b)) , b = base for number representation , b = 10, = O(d*n), d -> no. of iterations ( digit count of max element present in array )
    stable & out-place sorting algorithm.
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
        radixSort(arr,0, arr.length-1);
        System.out.println("After Applying Radix Sort : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void radixSort(Integer[] arr,int start,int end){
        int max,iterations;
        iterations = 0;
        max = arr[start];
        for(int i = start+1; i < end; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        // max element we have now , find iterations ( number of digits in max element)
        while(max > 0){
            max /= 10;
            iterations++;
        }
        // iterations times we need to call count sort subroutine.
        for(int i = 1; i <= iterations; i++){
            countSort(arr,start,end,i);
        }
    }

    public static void countSort(Integer[] arr,int start,int end,int radix){
        Integer[] brr = new Integer[arr.length];
        Integer divide_integer,k;
        Integer[] count_array = new Integer[10];
        for(int i = 0; i <= 9; i++){
            count_array[i] = 0;
        }
        divide_integer = (int) Math.pow(10,radix-1);
        for(int i = start; i <= end; i++){
            k = arr[i]/divide_integer;
            count_array[k%10]++;
        }
        // modify the count array
        for(int i = 1; i <= 9; i++){
            count_array[i] += count_array[i-1];
        }
        // modify original array
        for(int i = end; i >= start; i--){
            k = arr[i]/divide_integer;
            brr[count_array[k%10]-1] = arr[i];
            count_array[k%10]--;
        }

        for(int i = start; i <= end; i++){
            arr[i] = brr[i];
        }
    }
}
