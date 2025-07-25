package com.javatpoint.microservice.springjavaprogram.java8Features;

public class FunctionalInterfaceExample {
    public static void main(String args[]){
        Calculate calculate = (a,b) -> a+b;
        // works with lambda expression even without @FunctionalInterface
        // @FunctionalInterface -> Optional , Enforces Single Abstract Method Rule at compile-time.
        // can have multiple Static methods and default methods.
        // it can contain any number of Object class method
        System.out.println(calculate.add(2,4));
    }
}

interface Calculate {
    int add(int a,int b);
}
