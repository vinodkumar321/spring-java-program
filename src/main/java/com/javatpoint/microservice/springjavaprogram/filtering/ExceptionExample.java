package com.javatpoint.microservice.springjavaprogram.filtering;

import java.io.IOException;

public class ExceptionExample {
    public static void main(String args[]) throws Exception {
        A a = new A();
        a.show();
        a = new B();
        // DMD Dynamic Method Dispatch.
        a.show();
        // B's show cannot declare Checked Exception but can declare Unchecked Exception.
        // if Parent class declares Exception , subclass Overridden method can declare same or no exception but cannot
        // declare parent Exception.
    }
}

class A {
    public void show() throws NumberFormatException {
        System.out.println("A's Show");
    }
}

class B extends A {
    @Override
    public void show() throws NumberFormatException {
        System.out.println("B's Show");
    }
}
