package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinMax {

    private Integer min;
    private Integer max;


    public static void main(String[] args) {
        Integer n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Array Length : ");
        n = scanner.nextInt();
        System.out.println("Enter Array Element : ");
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Integer[] result = new Integer[2];
        findMinMaxInArray(arr,0,n-1,result);
        System.out.println("Maximum Element : " + result[1]);
        System.out.println("Minimum Element : "+result[0]);
    }

    public static void findMinMaxInArray(Integer[] arr,Integer start,Integer end,Integer[] result) {

        Integer min,max,mid;
        if(start == end) {
            result[0] = arr[start];
            result[1] = arr[end];
        }else if(start == end-1) {
            if(arr[start] < arr[end]) {
                result[0] = arr[start];
                result[1] = arr[end];
            }else{
                result[0] = arr[end];
                result[1] = arr[start];
            }
        }else{
            mid = (start + end)/2;
            findMinMaxInArray(arr,start,mid,result);
            min = result[0];
            max = result[1];
            findMinMaxInArray(arr,mid+1,end,result);
            if(min < result[0]) {
                result[0] = min;
            }
            if(max > result[1]) {
                result[1] = max;
            }
        }
    }

}
