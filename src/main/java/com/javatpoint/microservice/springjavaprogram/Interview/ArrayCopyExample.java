package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.Arrays;

public class ArrayCopyExample {
    public static void main(String args[]){
        int arr[] = {10,20,30,40,50};
        int copy[] = Arrays.copyOfRange(arr,2,10);
        int copyOf[] = Arrays.copyOf(arr,8);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(copyOf));
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        System.arraycopy(src,2,dest,2,2);
        System.out.println(Arrays.toString(dest));
    }
}
