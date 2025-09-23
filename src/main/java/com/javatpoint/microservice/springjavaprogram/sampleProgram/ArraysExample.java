package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String args[]){
        Integer[] arr = {1,2,3,4,5};
        //System.out.println(arr);
        Integer[] arr2 = new Integer[8];
        System.arraycopy(arr,0,arr2,0,3);
        System.out.println("arr Elements");
        for(Integer i : arr){
            System.out.print(i+" ");
        }
        System.out.println("\narr2 Elements");
        for(Integer i : arr2){
            System.out.print(i+" ");
        }
        Integer arr3[] = Arrays.copyOf(arr,5);
        System.out.println("\narr3 Elements");
        for(Integer i : arr3){
            System.out.print(i+" ");
        }
        Integer arr4[] = Arrays.copyOfRange(arr,2,4);
        System.out.println("\narr4 Elements");
        for(Integer i : arr4){
            System.out.print(i+" ");
        }
        Integer arr5[] = arr.clone();
        System.out.println("\narr5 Elements");
        for(Integer i : arr5){
            System.out.print(i+" ");
        }
        System.out.println("\n arr == arr3 : "+(arr == arr3));
        System.out.println("\n arr.equals(arr3) : "+arr.equals(arr3));
        System.out.println("\n Arrays.equals(arr,arr3) : "+Arrays.equals(arr,arr3)); // compares content for 1D Array
        System.out.println("\n arr == arr5 : "+(arr == arr5));
        System.out.println("\n arr.equals(arr5) : "+arr.equals(arr5));
        System.out.println("\n Arrays.equals(arr,arr5) : "+Arrays.equals(arr,arr5)); // compares content for 1D Array
        // Arrays.deepEquals(arr1, arr2);     // for nested (multi-dimensional) arrays
    }
}
