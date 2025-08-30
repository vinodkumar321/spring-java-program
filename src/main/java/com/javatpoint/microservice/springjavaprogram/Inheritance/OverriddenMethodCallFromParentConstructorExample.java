package com.javatpoint.microservice.springjavaprogram.Inheritance;

public class OverriddenMethodCallFromParentConstructorExample {
    public static void main(String args[]){
        // new Parent();
        new Child();
    }
}

class Parent {
    public Parent(){
        System.out.println("Parent Constructor called");
        show();
    }
    public void show(){
        System.out.println("Parent Show() called...");
    }
}

class Child extends Parent {
    int x = 10;
    public Child(){
        System.out.println("Child Constructor called");
    }

    @Override
    public void show(){
        System.out.println("Child Show() called. x = "+x);
    }
}
