package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPIDemo {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.javatpoint.microservice.springjavaprogram.java8Features.Person2"); // or Person2.class

        System.out.println("Class Name: " + clazz.getName());

        System.out.println("\nFields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f.getName() + " : " + f.getType());
        }

        System.out.println("\nMethods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m.getName());
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }


        Person2 p2 = new Person2("Vijay",28);
        Field nameField = clazz.getDeclaredField("name");
        System.out.println("p2  name : "+p2.getName()+" , Age : "+p2.getAge());
        nameField.setAccessible(true); // bypass private access
        nameField.set(p2, "Vinod");
        System.out.println("Updated name: " + nameField.get(p2));
        System.out.println("p2  name : "+p2.getName()+" , Age : "+p2.getAge());


        // Invoke the Method Dynamically.
        Method method = p2.getClass().getMethod("sayHello");
        method.invoke(p2); // prints: Hello!

        // invoke Static method also
        Method method2 = p2.getClass().getMethod("sayHelloWorld");
        method2.invoke(p2.getClass());

        // invoking non existing method
        Method method3 = p2.getClass().getMethod("say");
        method3.invoke(p2);

    }
}

class Person2 {
    private String name;
    public int age;

    public Person2() {}
    public Person2(String name) {
        this.name = name;
    }
    public Person2(int age) {
        this.age = age;
    }
    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public static void sayHelloWorld() {
        System.out.println("Static Hello world Method!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


