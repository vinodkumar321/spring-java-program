package com.javatpoint.microservice.springjavaprogram.RMI;

import java.rmi.Naming;

public class MyClient {
    public static void main(String args[]){
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost:1009/HelloService");
            String response = service.sayHello();
            System.out.println("Response : "+response);
            Person person = new Person("Vinod Kumar",28,74000d);
            String personDetails = service.printPersonDetails(person);
            System.out.println("Invoking printPerson Details Method");
            System.out.println("Response : "+personDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
