package com.javatpoint.microservice.springjavaprogram.Collections.Map;

import java.util.*;

public class MapExample {
    public static void main(String args[]){
        Map<String,String> map = new HashMap<>();
        map.put("1","Vikkkd");
        map.put("2","Vijay");map.put("3","Ajay");
        map.put("4",null);map.put("5","Vikrant");map.put("6","Atul");
        map.put("7",null);map.put("8","Vipul");map.put("9","Abbas");map.put(null,"Vinddhdhdhd");
        //Set<String> keys = map.keySet(); // iteration over keys
        Set<Map.Entry<String,String>> entrySet = map.entrySet(); // iteration over entrySet
        for(Map.Entry<String,String> entry : entrySet){
            System.out.println("Entry key : "+entry.getKey()+" , value : "+entry.getValue());
        }
        // map.putAll(map2); common keys skipped and null keys value is updated if present in both maps.
        System.out.println("Linked HashMap values");
        Map<String,String> linkedHashMap = new LinkedHashMap<>();
        // Linked HashMap uses hashTable to store entries & Doubly Link List to maintain insertion Order.
        linkedHashMap.put("1","Vinod");
        linkedHashMap.put("2","Vijay");linkedHashMap.put("3","Ajay");
        linkedHashMap.put("4",null);linkedHashMap.put("5","Vikrant");linkedHashMap.put("6","Atul");
        linkedHashMap.put("7",null);linkedHashMap.put("8","Vipul");linkedHashMap.put("9","Abbas");linkedHashMap.put(null,"Vinod");
        linkedHashMap.putAll(map);
        Set<Map.Entry<String,String>> entrySet2 = linkedHashMap.entrySet(); // iteration over entrySet
        for(Map.Entry<String,String> entry : entrySet2){
            System.out.println("Entry key : "+entry.getKey()+" , value : "+entry.getValue());
            // linkedHashMap.put("skd",null); - ConcurrentModificationException
        }
        System.out.println("TreeMap");
        Map<String,String> treeMap = new TreeMap<>();
        // Linked HashMap uses hashTable to store entries & Doubly Link List to maintain insertion Order.
        treeMap.put("1","Vinod");
        treeMap.put("21","Vijay");treeMap.put("13","Ajay");
        treeMap.put("42",null);treeMap.put("25","Vikrant");treeMap.put("61","Atul");
        treeMap.put("732",null);treeMap.put("82","Vipul");treeMap.put("93","Abbas");
        Set<Map.Entry<String,String>> treeMapEntry = treeMap.entrySet(); // iteration over entrySet
        // contains keys always in ascending order
        for(Map.Entry<String,String> entry : treeMapEntry){
            System.out.println("Entry key : "+entry.getKey()+" , value : "+entry.getValue());
        }




    }
}
