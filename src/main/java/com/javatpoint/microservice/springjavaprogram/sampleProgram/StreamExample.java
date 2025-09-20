package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.util.*;

public class StreamExample {
    public static void main(String args[]){
        List<Object> list = Arrays.asList(1,1,2,3,1,2,3,null,4,null," ","",5,"Vinod","Vinod");
        System.out.println(list);
        list.stream().filter(e -> (e instanceof String ? !((String) e).isBlank() : true)).distinct().forEach(System.out::println);
        System.out.println("Helo");
        list.stream().filter(e -> Collections.frequency(list,e) >= 3).distinct().forEach(System.out::println);
    }
}
