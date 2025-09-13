package com.javatpoint.microservice.springjavaprogram.Threads;

public class ThreadCreation {

    public static void main(String[] args) {
        // using thread class
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread2.start();

        // using Runnable
        Thread thread = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread.start();
        thread2.start();

        // using Java8 (lambda Expression)
        Thread thread1 = new Thread(() -> {
            System.out.println("Lambda Thread Running...");
        });
        thread1.start();

        // using direct Runnable Interface
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Running using direct Runnable...");
            }
        });
        thread5.start();


    }
}

class MyThread extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("MyThread Running, i : "+i+" , Thread Name : "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class MyRunnable implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("MyRunnable Running, i : "+i+" , Thread Name : "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
