package com.javatpoint.microservice.springjavaprogram.Threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                // core pool size
                4,                // maximum pool size
                10, TimeUnit.SECONDS,  // keep-alive time
                new LinkedBlockingQueue<>(2), // work queue
                new ThreadPoolExecutor.CallerRunsPolicy() // rejection policy
        );

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.execute(() ->
                    System.out.println("Task " + taskId + " run by " + Thread.currentThread().getName())
            );
        }

        executor.shutdown();
    }
}
