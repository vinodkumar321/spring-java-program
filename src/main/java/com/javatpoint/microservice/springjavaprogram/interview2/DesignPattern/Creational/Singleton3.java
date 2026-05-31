package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

// Singleton Design Pattern - with static inner class
public class Singleton3 {
    public static void main(String args[]) {
        DatabaseConnection3 databaseConnection3 = DatabaseConnection3.getInstance();
        DatabaseConnection3 databaseConnection31 = DatabaseConnection3.getInstance();
        System.out.println(databaseConnection3.equals(databaseConnection31));
    }
}

class DatabaseConnection3 {


    // no one directly can create instance
    private DatabaseConnection3() {
        System.out.println("Database Instance Created");
    }

    // Static Inner class ( Thread Safe )
    // High Performance , Lazy Initialization , no Synchronization Overhead
    private static class Holder {
        private static final DatabaseConnection3 instance = new DatabaseConnection3();
    }

    public static DatabaseConnection3 getInstance() {
        return Holder.instance;
    }

}
