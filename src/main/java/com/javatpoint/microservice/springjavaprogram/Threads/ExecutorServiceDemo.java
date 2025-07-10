package com.javatpoint.microservice.springjavaprogram.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running in: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Don't forget to shut it down!
    }
}
