package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Questions {
    public static void main(String args[]){
        /*
        List<Integer> list = Arrays.asList(10, 20, 40, 30, 50);
         find 2nd highest or 3rd highest or 4th Highest
        */
        List<Integer> list = Arrays.asList(10, 20, 40, 30, 50);
        Optional<Integer> result = list.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst();
        result.ifPresent(System.out::println);
        String str = "banana";
        // count frequency of each character & return result in this format
        // {b=1, a=3, n=2}
        char arr[] = str.toCharArray();
        Map<Character,Long> map = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(Map.Entry<Character,Long> entry : map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println(map.toString());
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 1);
        // find duplicate elements in list
        Map<Integer,Long> map2 = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map2.toString());
        List<Integer> list2 = numbers.stream().distinct().filter(i -> Collections.frequency(numbers,i) > 1).toList();
        System.out.println(list2.toString());
        List<String> names = new ArrayList<>();
        names.add("Vinod");
        names.add("Kumar");
        names.add("Chandani");
        ListIterator<String> listItr = names.listIterator();
        while (listItr.hasNext()) System.out.println(listItr.next());
        while (listItr.hasPrevious()) System.out.println(listItr.previous());

    }
}
