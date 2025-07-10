package com.javatpoint.microservice.springjavaprogram.Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ITCWithBlockingQueue {

        public static void main(String[] args) {
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

            Runnable producer = () -> {
                int value = 0;
                try {
                    while (true) {
                        queue.put(value++); // waits if full
                        System.out.println("Produced: " + value);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {}
            };

            Runnable consumer = () -> {
                try {
                    while (true) {
                        int val = queue.take(); // waits if empty
                        System.out.println("Consumed: " + val);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {}
            };

            new Thread(producer).start();
            new Thread(consumer).start();
        }
}
