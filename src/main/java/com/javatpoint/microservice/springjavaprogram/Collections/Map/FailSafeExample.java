package com.javatpoint.microservice.springjavaprogram.Collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeExample {
    public static void main(String args[]) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");

        for (String s : list) {
            if (s.equals("a")) {
                list.remove("a");
                list.add("c");
                list.add("d");
            }
            System.out.println(s);
        }
        System.out.println();
        for (String s : list) {
            System.out.println(s);
        }


        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("1", "Vikkkd");
        map.put("2", "Vijay");
        map.put("3", "Ajay");
        //map.put("4", null);
        map.put("5", "Vikrant");
        map.put("6", "Atul");
        //map.put("7", null);
        map.put("8", "Vipul");
        map.put("9", "Abbas");
        //map.put(null, "Vinddhdhdhd");
        //Set<String> keys = map.keySet(); // iteration over keys
        Set<Map.Entry<String, String>> entrySet = map.entrySet(); // iteration over entrySet
        for (ConcurrentMap.Entry<String, String> entry : entrySet) {
            System.out.println("Entry key : " + entry.getKey() + " , value : " + entry.getValue());
            map.put("nony","nony");
        }
        System.out.println();System.out.println();System.out.println();
        for (ConcurrentMap.Entry<String, String> entry : entrySet) {
            System.out.println("Entry key : " + entry.getKey() + " , value : " + entry.getValue());
            map.put("nony","nony");
        }
    }
}
