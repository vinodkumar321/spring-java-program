package com.javatpoint.microservice.springjavaprogram.Threads;

public class ThreadGroupDemo {
    public static void main(String args[]){
       ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");
        Thread thread1 = new Thread(threadGroup, () -> {
            System.out.println(Thread.currentThread().getName() + " running");
        }, "Thread-1");
        Thread thread2 = new Thread(threadGroup, () -> {
            System.out.println(Thread.currentThread().getName() + " running");
        }, "Thread-2");
        Thread thread3 = new Thread(threadGroup, () -> {
            System.out.println(Thread.currentThread().getName() + " running");
        }, "Thread-3");
        thread1.start();
        thread2.start();
        // Info about the group
        System.out.println("Active Threads in group: " + threadGroup.activeCount());
        System.out.println("Thread Group Name : " + threadGroup.getName());
        System.out.println("Thread Group Parent Name : " + threadGroup.getParent().getName());
    }
}
