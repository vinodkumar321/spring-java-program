package com.javatpoint.microservice.springjavaprogram.Threads;

public class StaticSynchronizationExample {
    public static void main(String[] args) {
        // Two different objects
        Table t1 = new Table();
        Table t2 = new Table();

        // Threads using static synchronized method
        Thread thread1 = new Thread(() -> Table.printTable(5), "Thread-1");
        Thread thread2 = new Thread(() -> Table.printTable(10), "Thread-2");

        thread1.start();
        thread2.start();
    }
}

class Table {
    // Static synchronized method
    public static synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + (n * i));
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}


