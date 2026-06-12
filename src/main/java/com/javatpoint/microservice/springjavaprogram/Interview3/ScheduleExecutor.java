package com.javatpoint.microservice.springjavaprogram.Interview3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor {
    public static void main(String args[]){
        ScheduledExecutorService schduler = Executors.newScheduledThreadPool(2);
        schduler.schedule(() -> {
                    System.out.println("Executed after 5 Seconds");
                }
                ,5, TimeUnit.SECONDS);
        schduler.shutdown();
        schduler = Executors.newScheduledThreadPool(2);
        schduler.scheduleAtFixedRate(
                () -> {
                    System.out.println("Executed after 3 Seconds");
                }
                ,0,3,TimeUnit.SECONDS);
    }
}
