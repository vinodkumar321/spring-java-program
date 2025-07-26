package com.javatpoint.microservice.springjavaprogram.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() {
        return "Hello! from Server";
    }

    @Override
    public String printPersonDetails(Person p) {
        StringBuilder stringBuilder = new StringBuilder("Person Details");
        stringBuilder.append(" Name : "+p.getName()+" , Age : "+p.getAge()+" , Salary : "+p.getSalary());
        return stringBuilder.toString();
    }
}
