package com.javatpoint.microservice.springjavaprogram.Sorting;

import java.util.Scanner;

public class HeapSort {

    /*
      Almost complete Binary tree -> at every node after completing left then only right.
      after completion of present level only go to next level.
      first we will have build heap procedure which will build the heap from array
      then apply heapify procedure on it.

      step - 1 . buildHeap -> O(n) , maxHeapify for sorted order , minHeapify for reverse sorted order.
      step - 2 . swap first with last.
      step - 3 . apply heapify at first index by decreasing last index.
      step - 4 . repeat step -2,3,4.

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
        heapSort(arr,0, arr.length-1);
        //buildHeap(arr,0, arr.length-1);
        System.out.println("After Applying HeapSort with Method(buildHeap -> minHeapify() method) : ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void buildHeap(Integer[] arr,int start,int end){
        int k = (int)Math.ceil(end/2);
        for(int i = k; i >= start; i--){
            minHeapify(arr,start,end,i);
            ///maxHeapify(arr,start,end,i);
        }
    }

    public static void minHeapify(Integer[] arr,int start,int end,int parent) {
        int leftChild, rightChild, temp, minIndex;
        leftChild = 2 * parent + 1;
        rightChild = 2 * parent + 2;
        minIndex = -1;
        if (rightChild <= end) {
            if (arr[leftChild] > arr[rightChild]) {
                minIndex = rightChild;
            } else {
                minIndex = leftChild;
            }
        }else {
            if(leftChild <= end) {
                minIndex = leftChild;
            }
        }
        if (minIndex != -1) {
            if (arr[parent] > arr[minIndex]) {
                // swap it.
                temp = arr[minIndex];
                arr[minIndex] = arr[parent];
                arr[parent] = temp;
                minHeapify(arr, start, end, minIndex);
            }
        }
    }

    public static void maxHeapify(Integer[] arr,int start,int end,int parent){
        int leftChild, rightChild, temp, maxIndex;
        leftChild = 2 * parent + 1;
        rightChild = 2 * parent + 2;
        maxIndex = -1;
        if (rightChild <= end) {
            if (arr[leftChild] > arr[rightChild]) {
                maxIndex = leftChild;
            } else {
                maxIndex = rightChild;
            }
        }else {
            if(leftChild <= end) {
                maxIndex = leftChild;
            }
        }
        if (maxIndex != -1) {
            if (arr[parent] < arr[maxIndex]) {
                // swap it.
                temp = arr[maxIndex];
                arr[maxIndex] = arr[parent];
                arr[parent] = temp;
                maxHeapify(arr, start, end, maxIndex);
            }
        }
    }

    public static void heapSort(Integer[] arr,int start,int end){

         // swap start with end
         // buildHeap with leaving last index -> Repeat
         int temp;
         // build Heap - with minHeapify() method
         buildHeap(arr,start,end);
         for (int i = end; i > start; i--) {
             temp = arr[start];
             arr[start] = arr[i];
             arr[i] = temp;
             minHeapify(arr,start,i-1,start);
         }
    }

}
