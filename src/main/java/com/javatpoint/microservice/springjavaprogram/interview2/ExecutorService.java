package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorService {
    public static void main(String args[]) {
        try {
            java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(3);
            for(int i = 1; i <= 5; i++){
                int taskId = i;
                executorService.execute(
                        () -> System.out.println("Task : "+taskId+" , executed by Task-Name : "+Thread.currentThread().getName())
                );
            }

            Callable<String> task1 = () -> {
                Thread.sleep(1000);
                return "Hello Aakash!";
            };

            Callable<String> task2 = () -> {
                Thread.sleep(1000);
                return "Hello Vinod!";
            };

            Collection<Callable<String>> taskList = new ArrayList<>();
            taskList.add(task1);
            taskList.add(task2);

            List<Future<String>> result = executorService.invokeAll(taskList);
            for(Future<String> res : result){
                System.out.println("Result : "+res.get());
            }
            executorService.shutdown();

            ScheduledExecutorService schduler = Executors.newScheduledThreadPool(1);
            schduler.scheduleAtFixedRate(()-> System.out.println("Running in Every 2 Seconds"),5,2, TimeUnit.SECONDS);

        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
