package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Integer n,target;
        Boolean search;
        String userChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        System.out.print("Enter array elements in sorted order : ");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        do {
            System.out.println("Enter element to be searched: ");
            target = scanner.nextInt();
            target = binarySearchOnElement(arr, target, 0, arr.length - 1);
            if (target == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element found at index " + target);
            }
            System.out.println("continue searching? [y/n]");
            userChoice = scanner.next();
            search = userChoice.charAt(0) == 'y';
        }while (search);
    }

    public static Integer binarySearchOnElement(Integer[] arr, int target, int low, int high) {
        int mid;
        if(low == high){
            if(arr[low] == target){
                return low;
            }else {
                return -1;
            }
        }else {
            mid = (low + high)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] > target) {
                // search in left of mid
                return binarySearchOnElement(arr, target, low, mid - 1);
            }else{
                // search in right of mid
                return binarySearchOnElement(arr, target, mid + 1, high);
            }

        }
    }
}
