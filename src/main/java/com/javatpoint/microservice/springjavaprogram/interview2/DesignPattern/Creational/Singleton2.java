package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

// Singleton - Uses Double Check Locking with volatile keyword
public class Singleton2 {
    public static void main(String args[]) {
       DatabaseConnection2 instance = DatabaseConnection2.getInstance();
       DatabaseConnection2 instance2 = DatabaseConnection2.getInstance();
       System.out.println(instance2.equals(instance));
    }
}

class DatabaseConnection2 {

    private static volatile DatabaseConnection2 instance;

    // no one directly can create instance
    private DatabaseConnection2() {
        System.out.println("Database Instance Created");
    }

    // Double Check Locking ( Thread Safe )
    // High Performance , Lazy Initialization -> Still Synchronization Overhead
    public synchronized static DatabaseConnection2 getInstance() {
        if(instance == null) { // first check ( with no lock )
            synchronized (DatabaseConnection2.class) {
                if(instance == null){ // second check with lock
                    instance = new DatabaseConnection2();
                }
            }
        }
        return instance;
    }

}
