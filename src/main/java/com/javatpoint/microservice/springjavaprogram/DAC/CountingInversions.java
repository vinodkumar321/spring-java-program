package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Scanner;

public class CountingInversions {
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
        System.out.println("Total Inversion : "+countingInversions(arr,0,arr.length-1));
    }

    public static Integer countingInversions(Integer[] arr,int start,int end) {
        int mid,c1,c2;
        if(start == end) {
            return 0;
        }else{
            mid = (start + end)/2;
            c1 = countingInversions(arr,start,mid);
            c2 = countingInversions(arr,mid+1,end);
            return c1+c2+merge(arr,start,end,mid);
        }
    }
    public static Integer merge(Integer[] arr,int start,int end,int mid) {
        int len1 = mid-start+1;
        int len2 = end-mid;
        Integer[] arr2 = new Integer[len1];
        Integer[] arr3 = new Integer[len2];
        int i,j,k,count;
        for (i = 0; i < len1; i++) {
            arr2[i] = arr[start+i];
        }
        for (i = 0; i < len2; i++) {
            arr3[i] = arr[mid+1+i];
        }
        k = start;
        i = 0;
        j = 0;
        count = 0;
        while(i < len1 && j < len2) {
            if(arr2[i] < arr3[j]) {
                arr[k++] = arr2[i++];
            }else {
                count += len1-i;
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
        return count;
    }

}
