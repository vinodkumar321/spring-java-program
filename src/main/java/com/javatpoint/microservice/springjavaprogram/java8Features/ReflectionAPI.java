package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionAPI {
    public static void main(String args[]) throws ClassNotFoundException {
        Person person = new Person();
        Class cls = person.getClass();
        Method[] methods = cls.getMethods();
        for(Method method : methods){
            System.out.println("Method Name : "+method.getName());
            System.out.println("return Type : "+method.getGenericReturnType());
            System.out.println("toString : "+method.toString());
            // modifier packanameInformation..className.methodName(parameters if there)
            System.out.println("Generic String : "+method.toGenericString());
            Parameter[] parameters = method.getParameters();
            System.out.println("Method Parameters ");
            for(Parameter parameter : parameters){
                System.out.println(parameter);
            }
        }
    }
}

class Person {
    String name;
    Integer age;
    Double salary;


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}