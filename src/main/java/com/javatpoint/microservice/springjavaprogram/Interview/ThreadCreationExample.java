package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.concurrent.*;

public class ThreadCreationExample {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        // by Extending Thread class and overriding run() method
        Thread t1 = new VehiclePrivate("Vinod");
        Thread t2 = new VehiclePrivate("Kumar");
        t1.start();
        t2.start();
        // by implementing Runnable Interface and overridding run() method
        Thread t3 = new Thread(new VehiclePublic());
        t3.start();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Moto!");
            }
        };
        Thread t4 = new Thread(task);
        t4.start();

        // using Lambda Expression
        Thread t5 = new Thread(() -> {
             System.out.println("Hello Vinod");
        });
        t5.start();

        // using ExecutorService (Thread Pool)
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> System.out.println("Threads Running via Executor Service"));
        service.shutdown();

        // using callable + Future
        Callable<String> task2 = () -> "processing completed";
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        Future<String> result = service2.submit(task2);
        System.out.println(result.get());
        service2.shutdown();

        // using ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(() -> System.out.println("Okay , running via ForkJoin Pool"));
        pool.shutdown();
    }
}

class VehiclePrivate extends Thread {

    public VehiclePrivate(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            System.out.println(5*i+" , printed by Thread : "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread is Running , name : "+Thread.currentThread().getName());
    }
}

class VehiclePublic implements Runnable {

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            System.out.println(10*i+" , printed by Thread : "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread is Running , name : "+Thread.currentThread().getName());
    }
}
