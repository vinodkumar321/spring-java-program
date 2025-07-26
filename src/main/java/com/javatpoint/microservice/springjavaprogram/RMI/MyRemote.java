package com.javatpoint.microservice.springjavaprogram.RMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
      public abstract String sayHello() throws RemoteException;
      public abstract String printPersonDetails(Person p) throws RemoteException;
}


