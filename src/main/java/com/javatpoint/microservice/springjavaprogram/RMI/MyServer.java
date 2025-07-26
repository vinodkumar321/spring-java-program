package com.javatpoint.microservice.springjavaprogram.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MyServer {
    public static void main(String args[]){
        try{
            LocateRegistry.createRegistry(1009);
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("rmi://localhost:1009/HelloService",service);
            System.out.println("Server is Ready");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
