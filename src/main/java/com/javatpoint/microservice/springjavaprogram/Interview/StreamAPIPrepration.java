package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIPrepration {
    public static void main(String args[]){
        String arr[] = {"Vinod","Abhinav","Amritesh",null};
        Integer arr2[] = {3,4,5,1,2,4,6,7,8,9,35,5,6,45,33,2,2,null};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        Stream<String> stream = list.stream();
        Stream<Integer> integerStream = Arrays.stream(arr2);
        Stream<Character> charStream = Stream.of('A','B','C','D');
        List<List<String>> listOfStrings = Arrays.asList(
            Arrays.asList("Vinod","Abhinav"),
            Arrays.asList("Amritesh", "Aakash")
        );
        System.out.println("stream list");
        listOfStrings.stream().flatMap(e -> e.stream()).forEach(System.out::println);



    }
}
