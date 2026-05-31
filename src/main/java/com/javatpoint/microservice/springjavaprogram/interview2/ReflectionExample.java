package com.javatpoint.microservice.springjavaprogram.interview2;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Reflection API
        Class<?> clazz = Class.forName("com.javatpoint.microservice.springjavaprogram.interview2.Employe");
        System.out.println("Name : "+clazz.getName());

        // Fields
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println("Field  : "+field.getName());
        }

        Employe employe = new Employe("Vinod","Development");
        Field field = clazz.getDeclaredField("company");
        field.setAccessible(true);
        String value = (String) field.get(employe);
        System.out.println("Value : "+value);

        // invoking Methods Dynamically
        Method method1 = clazz.getMethod("setDeparment", String.class);
        method1.invoke(employe,"Programming");
        System.out.println("Department : "+employe.getDeparment());

        // Methods
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            System.out.println("Method Name : "+method.getName());
            System.out.println("Method Return Type : "+method.getReturnType());
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters) {
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Type : " + parameter.getType());
            }
            System.out.println("Method Parameter Count : "+method.getParameterCount());
        }

        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("Constructor Param count : "+constructor.getParameterCount());
            Parameter[] params = constructor.getParameters();
            for(Parameter parameter : params) {
                System.out.println("Consturctor Parameter Name : " + parameter.getName());
                System.out.println("Constructor Parameter Type : " + parameter.getType());
            }
        }

    }
}

class Employe {
    private String name;
    private String deparment;
    private String company = "Jocata";

    public Employe(){
        this.name = "default";
        this.deparment = "Sales";
    }

    public Employe(String name,String deparment){
        this.name = name;
        this.deparment = deparment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }
}


