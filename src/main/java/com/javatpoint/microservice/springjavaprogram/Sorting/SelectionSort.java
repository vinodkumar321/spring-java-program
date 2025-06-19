package com.javatpoint.microservice.springjavaprogram.Sorting;

import java.util.Scanner;

public class SelectionSort {

    /*
      consider first element as minimum element and scan the array for finding minimum element.
       -> after first pass ( we have minimum element & swap it with first place)
      apply same process for remaining unsorted array. ( after n passes , we will be having array sorted )
      O(n2) in Each case (Worst case & Average case & Best case).
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
        selectionSort(arr,0, arr.length-1);
        System.out.println("After Applying Selection Sort : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort(Integer[] arr,int start,int end){
        int temp,index;
        for(int i = start; i < end; i++){
            index = i;
            for(int j = i+1; j <= end; j++){
                if(arr[index] > arr[j]){
                    index = j;
                }
            }
            // swap i with index position
            if(i != index) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}
