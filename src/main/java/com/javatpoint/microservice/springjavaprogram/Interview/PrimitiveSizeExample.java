package com.javatpoint.microservice.springjavaprogram.Interview;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class PrimitiveSizeExample {
    public static void main(String args[]){
        Integer x = 10;
        int[] arr = new int[5];

        System.out.println("Integer Object Layout:");
        System.out.println(ClassLayout.parseInstance(x).toPrintable());
        System.out.println("\nint[] Object Layout:");
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
        System.out.println("\nTotal size of int[] including references:");
        System.out.println(GraphLayout.parseInstance(arr).toFootprint());

        int[] arr2 = new int[10];
        System.out.println("\nint[] arr2 Object Layout:");
        System.out.println(ClassLayout.parseInstance(arr2).toPrintable());
        System.out.println("\nTotal size of int[]  arr2 including references:");
        System.out.println(GraphLayout.parseInstance(arr2).toFootprint());
    }
}
