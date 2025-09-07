package com.javatpoint.microservice.springjavaprogram.InnerClass;

public class InnerClassExample {
    public static void main(String args[]){
        Outer outer = new Outer("Vinod Chandani");
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}

class Outer {
    private String name;
    public Outer(String name){
        this.name = name;
    }
    class Inner {
        void display(){
            System.out.println("Name : "+name);
        }
    }
}
