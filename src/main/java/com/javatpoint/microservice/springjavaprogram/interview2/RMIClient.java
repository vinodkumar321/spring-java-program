package com.javatpoint.microservice.springjavaprogram.interview2;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String args[]) {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost:1009/HelloService");
            String response = service.sayHello("Vinod");
            System.out.println("Response form Server : "+response);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
