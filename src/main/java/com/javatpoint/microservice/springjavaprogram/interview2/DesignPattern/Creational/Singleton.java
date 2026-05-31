package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Sample Example for Singleton Design Pattern....
public class Singleton {
    public static void main(String args[]) {
        // Singleton Design Pattern - Ensures Single Instance Exist in Entire Application
        // provides global Access point to it, Common in shared Resources and centralized Management.
        DatabaseConnection instance = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        System.out.println(instance.equals(instance2));

    }
}
/*
   Singleton Use-Cases
            * DB Connection Manager
            * Logger / Audit Manager for central Logging Management
            * Configuration Management for Reading Setting like ( APIKey , URL ) once and share globally.
            * Thread Pool Manager -> Shared pool for all background Threads
            * Cache Manager. -> Shared in-Memory cache used by all Modules
            * Driver Manager ( JDBC ). -> JVM Manages Single Driver Registration Instance
 */

class DatabaseConnection {

    private static DatabaseConnection instance;

    // no one directly can create instance
    private DatabaseConnection() {
        System.out.println("Database Instance Created");
    }

    // static method getting Db Instance - use Synchronized ( Thread-Safe )
        // safe but Slower because Synchronization on every call
    public synchronized static DatabaseConnection getInstance() {
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }




}
