package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortingExample {
    public static void main(String args[]){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(4,22);
        map.put(5,23);
        map.put(6,12);
        map.put(7,290);
        map.put(1,7);
        map.put(2,11);
        map.put(3,21);
        map.put(76,7);
        map.put(223,11);
        map.put(12324,21);
        map.put(null,12);
        map.put(99,null);
        // based on Key , Using Stream API & Lambda Expression
        Map<Integer,Integer> map3 = map.entrySet().stream()
                .filter(e -> e.getKey() != null)
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        () -> new LinkedHashMap<>(),
                        (m,entry) -> m.put(entry.getKey(),entry.getValue()),
                        (m1,m2) -> m1.putAll(m2)
                );
        System.out.println("Map3 Entries");
        for(Integer i : map3.keySet()){
            System.out.println(i+","+map3.get(i));
        }

        // based on Key , Using Stream API &  Method Reference
        Map<Integer,Integer> map4 = map.entrySet().stream()
                .filter(e -> e.getKey() != null)
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        LinkedHashMap::new,
                        (m,entry) -> m.put(entry.getKey(),entry.getValue()),
                        HashMap::putAll
                );
        System.out.println("Map4 Entries");
        for(Integer i : map4.keySet()){
            System.out.println(i+","+map4.get(i));
        }


        // based on Values , custom Sorting
        // i want to sort map based on values
        Map<Integer, Integer> sortedByValue = map.entrySet()
                .stream()
                .filter(e -> e.getValue() != null)
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        LinkedHashMap::new, // supplier
                        (m,e) -> m.put(e.getKey(),e.getValue()),
                        HashMap::putAll

                );
        System.out.println("Sorted By Value : "+sortedByValue);

    }
}
