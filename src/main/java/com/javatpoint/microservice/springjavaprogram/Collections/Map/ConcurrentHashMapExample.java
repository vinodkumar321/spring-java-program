package com.javatpoint.microservice.springjavaprogram.Collections.Map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String args[]){
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

        // computeIfAbsent : Add if key is Missing
        concurrentHashMap.computeIfAbsent("Apple",key -> 20);
        concurrentHashMap.computeIfAbsent("Banana",key -> 10);
        System.out.println("concurrentHashMap : "+concurrentHashMap);
        // computeIfPresent : update value if Key exists
        concurrentHashMap.computeIfPresent("Apple",(key,value) -> value+5);
        concurrentHashMap.computeIfPresent("Banana",(key,value) -> value*2); // preset , updates value according to function.
        concurrentHashMap.computeIfPresent("Cherry",(key,value) -> 50); // ignored as it is not present
        concurrentHashMap.computeIfAbsent("Banana",key -> 50); // ignored as it is present.
        System.out.println("concurrentHashMap : "+concurrentHashMap);

        // merge : add or update the value
        concurrentHashMap.merge("Apple",10,(oldValue,newValue) -> oldValue+newValue);
        concurrentHashMap.merge("Banana",20,(oldValue,newValue) -> oldValue*newValue);
        concurrentHashMap.merge("Cherry",5,(oldValue,newValue) -> oldValue+newValue);
        System.out.println("concurrentHashMap : "+concurrentHashMap);
    }
}
