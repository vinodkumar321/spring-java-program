package com.javatpoint.microservice.springjavaprogram.interview2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {

    }
    @Override
    public String sayHello(String name) {
        return "Hello " + name + " !";
    }
}
