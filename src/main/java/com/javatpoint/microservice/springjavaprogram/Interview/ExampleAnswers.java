package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleAnswers {
    public static void main(String args[]){
        Map<Character,Long> map = null;
        Map<Character,Long> wordMap = null;
        Boolean isPresent = true;
        Integer min_length = Integer.MAX_VALUE;
        String temp = null;
        String str = "Ah71752";
        List<Character> str2 = str.chars().filter(c -> c != ' ' && c > '9').mapToObj(c -> (char)c)
                .map(c -> Character.toLowerCase(c)).collect(Collectors.toList());
        map = str2.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("map : "+map);
        String words[] = {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
        for(String sts : words) {
            if(temp != null)
              System.out.println("temp : "+temp+" , length : "+temp.length());
            str2 = sts.chars().mapToObj(c -> (char)c)
                    .collect(Collectors.toList());
            wordMap = str2.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            System.out.println("wordMap : "+wordMap);
            isPresent = true;
            // check if all present with atleast frequency
            for (Character ch : map.keySet()) {
                if (wordMap.containsKey(ch)) {
                    if(map.get(ch) > wordMap.get(ch)){
                        isPresent = false;
                        break;
                    }
                }else{
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {
                if (temp == null) {
                    temp = sts;
                    min_length = temp.length();
                } else {
                    if (min_length > sts.length()) {
                        temp = sts;
                        min_length = sts.length();
                    }
                }
            }
        }
    }
}
