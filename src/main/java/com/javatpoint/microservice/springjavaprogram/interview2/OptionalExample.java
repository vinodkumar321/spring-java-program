package com.javatpoint.microservice.springjavaprogram.interview2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class OptionalExample {
    public static void main(String args[]){
        Optional<String> str = Optional.of("Vinod"); // throw Null pointer on null values
        Optional<String> str2 = Optional.ofNullable(null); // accepts null
        Optional<String> str3 = Optional.empty();
        // Optional<String> str4 = Optional.of(null); // throw Null pointer on null values
        str2.ifPresent(System.out::println);
        System.out.println(str2.orElse("Default Name"));
        // System.out.println(str2.orElse("Default String"));
        // System.out.println(str3.get());
        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.of(1997,8,8);
        Period period = Period.between(dob,today);
        System.out.println("Age : "+period.getYears()+" Years "+period.getMonths()+" months "+period.getDays()+" Days");
    }
}
