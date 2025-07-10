package com.javatpoint.microservice.springjavaprogram.Threads;

import java.util.LinkedList;
import java.util.Queue;

// classic Producer-Consumer Problem
/*
It’s a classic concurrency problem where:

Producer(s): create data and put it into a shared buffer (e.g., queue).

Consumer(s): take data from that buffer and process it.

The challenge:

Producers shouldn’t add to the buffer when it’s full.

Consumers shouldn’t remove from the buffer when it’s empty.

Both must work concurrently without corrupting shared data.

 */
public class InterThreadCommunication {
    public static void main(String[] args) {
         ProducerConsumer producerConsumer = new ProducerConsumer();

         Thread producer = new Thread(() -> {
             try{
                 producerConsumer.produce();
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }
         });

        Thread consumer = new Thread(() -> {
            try{
                producerConsumer.consume();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();

    }
}

class ProducerConsumer {
    Queue<Integer> queue = new LinkedList<>();
    Integer capacity = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == capacity) {
                    wait(); // wait until buffer has space
                }
                queue.add(value++);
                System.out.println("Produced: " + value);
                notifyAll(); // wake up consumers
            }
            Thread.sleep(500); // simulate time to produce
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait(); // wait until buffer has items
                }
                int val = queue.poll();
                System.out.println("Consumed: " + val);
                notifyAll(); // wake up producers
            }
            Thread.sleep(1000); // simulate time to consume
        }
      }
}



