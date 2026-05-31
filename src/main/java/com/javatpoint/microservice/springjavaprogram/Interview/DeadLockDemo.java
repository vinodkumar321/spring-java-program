package com.javatpoint.microservice.springjavaprogram.Interview;

public class DeadLockDemo {
    public static void main(String args[]){
       Resource r1 = new Resource("R1");
       Resource r2 = new Resource("R2");
       Thread t1 = new Thread(() -> {
           synchronized (r1) {
               System.out.println("Thread t1 locked Resounce - R1");
               try {
                   Thread.sleep(2000);
                   System.out.println("Thread t1 waiting for Resounce - R2");
                   synchronized (r2) {
                       System.out.println("Thread t1 locked Resource - R2");
                   }
               }catch (InterruptedException exception){
                   System.out.println("exception Message : "+exception.getMessage());
               }
           }
       });

        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("Thread t2 locked Resounce - R2");
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread t2 waiting for Resounce - R1");
                    synchronized (r1) {
                        System.out.println("Thread t2 locked Resource - R1");
                    }
                }catch (InterruptedException exception){
                    System.out.println("exception Message : "+exception.getMessage());
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Resource {
    String name;

    public Resource(String name){
        this.name = name;
    }

}
