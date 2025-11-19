package com.javatpoint.microservice.springjavaprogram.Interview;

public class SystemGCExample {
    public static void main(String args[]){
                String str = new String("Hello GC");
                str = null; // eligible for GC

                System.gc(); // suggest garbage collection
                System.out.println("Requested GC");
            }

            @Override
            protected void finalize() {
                System.out.println("finalize() called");
            }
    }
