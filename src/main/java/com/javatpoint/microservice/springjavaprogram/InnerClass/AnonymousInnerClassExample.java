package com.javatpoint.microservice.springjavaprogram.InnerClass;

public class AnonymousInnerClassExample {
    public static void main(String args[]){
          Greeting greeting = new Greeting() {
              @Override
              public void sayHello(String name) {
                 System.out.println("Hello ,"+name);
              }
          };
          greeting.sayHello("Vinod Chandani");
    }
}

interface Greeting {
    void sayHello(String name);
}

