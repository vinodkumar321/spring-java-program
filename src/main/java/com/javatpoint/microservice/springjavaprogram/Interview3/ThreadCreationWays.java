package com.javatpoint.microservice.springjavaprogram.Interview3;

import java.util.concurrent.*;

public class ThreadCreationWays {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        // Thread class
        MyThread myThread = new MyThread();
        myThread.start();
        // Runnable Interface
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        // 3. using Lambda Expression Java8
        Thread t2 = new Thread(() -> {
            System.out.println("Hello , This Thread is Executed using Lambda Expression...");
        });
        t2.start();
        // 4. Using Executor Service
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> System.out.println("Hello , This Thread Executed using Executor Service"));
        service.shutdown();
        // 5. Using Callable & Futures
        Callable<String> task = () -> "Thread Executed via Callable & Future";
        /*
        equvalent non-lambda expression
        Callable<String> task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Result Returned";
                }
            };
        */
        service = Executors.newFixedThreadPool(2);
        Future<String> result = service.submit(task);
        System.out.println("Result : "+result.get());
        service.shutdown();
        // 6. Using Fork Join Pool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> System.out.println("Thread Executed via Fork Join Pool"));
        forkJoinPool.shutdown();
    }
}

// 1. By Extending Thread class
class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Thread Running by Extending Thread class...");
    }
}

// 2. by Implementing Runnable Interface
class MyRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread Running by Implementing Runnable Interface ...");
    }
}


