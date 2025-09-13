package com.javatpoint.microservice.springjavaprogram.Threads;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1 - " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2 - " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
        t1.start();
        // main thread will wait until t1 and t2 finishes it's execution
        t1.join();
        t2.join();


        System.out.println("Main thread finished");
    }
}
