package com.javatpoint.microservice.springjavaprogram.interview2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    public String sayHello(String name) throws RemoteException;
}
