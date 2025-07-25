package com.javatpoint.microservice.springjavaprogram.Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ArrayListExample {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(1);list.add(3);
        list.add(-1);list.add(0);list.add(2);list.add(1);
        list.add(1);list.add(1);list.add(1);list.add(1);list.add(1);
        list.add(2,19);
        System.out.println("Element at Index 6 : "+list.get(6));
        Object[] objectList = list.toArray();
        System.out.println("object at index 0 : "+objectList[0]);
        System.out.println("size : "+list.size());
        for(Integer k : list){
            System.out.print(" "+k);
        }
        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println();
        System.out.println("After Sorting");
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for(Integer k : list){
            System.out.print(" "+k);
        }
        System.out.println("\nInteger Array : "+integers.length);
        for(Integer k : integers){
            System.out.print(" "+k);
        }
    }
}
