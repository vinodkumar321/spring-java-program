package com.javatpoint.microservice.springjavaprogram.java8Features;

import jakarta.annotation.Nullable;

import java.util.Optional;

public class OptionalClass {
    public static void main(String args[]){
        Optional<String> string = Optional.of("Vinod Kumar");
        // Optional.of(null) -> throws Nullpointer but Optional.ofNullable(null) accespts null values.
        Optional<String> string2 = Optional.empty();
        Optional<String> string3 = Optional.ofNullable("Vishal Kumar");
        // executes logic , if value exist.
        string.ifPresent(e -> System.out.println("string : "+e));

        string2.ifPresentOrElse(e -> System.out.println("string2 : " + e), new Runnable() {
            @Override
            public void run() {
                System.out.println("Empty String2");
            }
        });
        string3.ifPresentOrElse(e -> System.out.println("string3 : " + e), new Runnable() {
            @Override
            public void run() {
                System.out.println("Empty String3");
            }
        });
    }
}
