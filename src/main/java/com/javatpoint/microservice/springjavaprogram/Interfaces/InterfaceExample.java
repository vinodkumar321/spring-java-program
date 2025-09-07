package com.javatpoint.microservice.springjavaprogram.Interfaces;

public class InterfaceExample {
    public static void main(String args[]){
        MyClass myClass = new MyClass();
        myClass.show();
    }
}

interface A {
    default void show() {
        System.out.println("A show");
    }
}

interface B {
    default void show() {
        System.out.println("B show");
    }
}

class MyClass implements A, B {
    @Override
    public void show() {
        // must resolve ambiguity
        B.super.show(); // or A.super.show()
        System.out.println("MyClass show");
    }
}
