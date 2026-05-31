package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleString {
    public static void main(String args[]){
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        paragraph = paragraph.replaceAll("[^a-zA-Z ]","");
        String[] arr = paragraph.split(" ");
        String[] banned = {"hit","ball"};
        Map<String,Long> map = Arrays.stream(arr).map(e -> e.toLowerCase()).filter(e -> !Arrays.asList(banned).contains(e)).collect(Collectors.groupingBy(
                word -> word ,
                Collectors.counting()
        ));
        Map.Entry<String,Long> maxFrequency = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println(maxFrequency.getKey());

    }
}
