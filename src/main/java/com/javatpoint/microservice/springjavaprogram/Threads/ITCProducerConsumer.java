package com.javatpoint.microservice.springjavaprogram.Threads;

public class ITCProducerConsumer {
    // Inter Thread Comunication with Standard Producer-Consumer Problem.
    public static void main(String args[]) throws InterruptedException {
        SharedBuffer sharedBuffer = new SharedBuffer();
        Thread producer = new Thread(new Producer(sharedBuffer),"Producer");
        Thread consumer = new Thread(new Consumer(sharedBuffer),"Consumer");
        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
        System.out.println("Main Program Completed");
    }
}

class SharedBuffer {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int n) throws InterruptedException {
        while(hasData){
            wait(); // wait until consumer Consumes the data
        }
        data = n;
        hasData = true;
        System.out.println("Produced : "+data+" , Thread Name : "+Thread.currentThread().getName());

        notify(); // notify consumer thread that data is available to consume
    }

    public synchronized int consume() throws InterruptedException {
        while(!hasData){
            wait();
        }
        hasData = false;
        System.out.println("Consumed : "+data+" , Thread Name : "+Thread.currentThread().getName());
        notify(); //notify Producer thread , it can produce the data
        return data;
    }
}

class Producer implements Runnable{
    private SharedBuffer buffer;
    public Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                buffer.produce(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
   private SharedBuffer buffer;
   public Consumer(SharedBuffer buffer){
       this.buffer = buffer;
   }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                buffer.consume();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
