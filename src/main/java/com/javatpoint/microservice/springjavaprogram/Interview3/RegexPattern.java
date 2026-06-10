package com.javatpoint.microservice.springjavaprogram.Interview3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
    public static void main(String args[]){
        String hello = "My Name is  Vinod & My Mobile Number is 9079292343";
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(hello);
        if(matcher.find()){
            System.out.println("Mobile Number : "+matcher.group());
        }else{
            System.out.println("Not Found any Mobile Number in given String");
        }
    }
}
