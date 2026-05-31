package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.*;

public class ArrayListExample {
    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("Vinod");
        list.add("Kumar");
        list.add("Chandani");
        list.add(null);
        System.out.println(list.toString());
        list.set(1,"Sonal");
        list.add(2,"Kumar");
        System.out.println(list.toString());
    List<String> sortedList = list.stream().filter(Objects::nonNull).sorted().toList();
        System.out.println(sortedList.toString());
    }
}
