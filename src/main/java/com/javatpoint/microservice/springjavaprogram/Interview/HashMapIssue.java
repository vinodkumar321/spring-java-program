package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.*;

public class HashMapIssue {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // Thread 1
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, "T1-" + i);
            }
        }).start();

        // Thread 2
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put(i, "T2-" + i);
            }
        }).start();

        // Main thread
        try { Thread.sleep(100); } catch (Exception e) {}
        System.out.println(map);
    }
}
