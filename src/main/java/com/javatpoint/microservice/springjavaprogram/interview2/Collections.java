package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.Arrays;
import java.util.Collection;

public class Collections {
    public static void main(String args[]){
        Collection<String> list = Arrays.asList("Vinod","Kumar","Chandani");
        Object[] arr = list.toArray();
        for(Object obj : arr){
            System.out.println(obj);
        }
        String[] arrString = list.toArray(new String[0]);
        System.out.println();
        for(String str : arrString) {
            System.out.println(str);
        }
        String vinod = "Vinod";
        System.out.println(vinod.contains("Vin"));
    }
}
