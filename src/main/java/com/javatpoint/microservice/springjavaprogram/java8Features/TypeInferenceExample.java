package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.util.ArrayList;
import java.util.List;

public class TypeInferenceExample {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<>();
        // Type Inference - provides ability to compiler to look at each method invocation
        // & corresponding declaration to determine the type of argument.
        // compiler can infer the type as Integer for list2.
    }
}
