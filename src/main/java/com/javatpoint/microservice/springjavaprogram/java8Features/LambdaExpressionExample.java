package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionExample {
    public static void main(String args[]){
        List<String> list = Arrays.asList("A","B","C");
        list.forEach(item -> System.out.println(item)); // lambda Expression
        System.out.println();
        list.forEach(System.out::println); // method reference shortcut for calling methods using :: instead of writing full lambda expressions.
    }
}
