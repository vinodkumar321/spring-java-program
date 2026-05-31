package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class ThreadCreationWays {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        // Thread Creation ways
        /*
             1. By Extending Thread Class and overriding run method

         */
        Thread t1 = new MyThread();
        t1.start();

        // 2. By Implementing Runnable Interface
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(10 * i);
                        Thread.sleep(2000);
                    }
                }catch (Exception exp){
                    System.out.println("Exception Occured while Thread Execution... using Runnable Interface");
                }
            }
        };

        Thread t2 = new Thread(task);
        t2.start();

        // 3. Using Lambda Expression
        Thread t3 = new Thread(() -> {
            System.out.println("Running Thread via Lambda Expression");
        });
        t3.start();

        // 4. without lambda Expression
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Thread without Lambda Expression");
            }
        });
        t4.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            System.out.println("New Thread Executing via Executor Service...");
        });
        executorService.shutdown();

        // 5. Callable + Future
        Callable<String> task2 = () -> "Processing Completed";
        executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(task2);
        System.out.println(result.get());
        executorService.shutdown();

        // 6. using Fork Join Pool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
           System.out.println("Running Task via ForkJoinPool");
        });
        forkJoinPool.shutdown();

        // Schdule a Task Using ExecutorService
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() ->{
           System.out.println("Running Task after 3 seconds");
        },3,TimeUnit.SECONDS);


        // Repeating Task
        service.scheduleAtFixedRate(() -> {
            System.out.println("Repeated Task after every 3 seconds");
        },1,3,TimeUnit.SECONDS);




    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(5 * i);
                Thread.sleep(1000);
            }
        }catch (Exception exp){
            System.out.println("Exception Occured while Thread Execution...");
        }
    }
}
