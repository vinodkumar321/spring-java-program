package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.util.StringJoiner;

public class StringJoinerClass {
    public static void main(String args[]){
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add("Vinod");
        stringJoiner.add("Abhinav");
        stringJoiner.add("Amritesh");
        stringJoiner.add("Mrigesh");
        StringJoiner stringJoiner2 = new StringJoiner(",");
        stringJoiner2.add("Vinod");
        stringJoiner2.add("Abhinav");
        stringJoiner2.add("Amritesh");
        stringJoiner2.add("Mrigesh");
        System.out.println("stringJoiner : "+stringJoiner);
        System.out.println("stringJoiner2 : "+stringJoiner2);
    }
}
