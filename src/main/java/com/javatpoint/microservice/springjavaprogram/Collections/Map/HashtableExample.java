package com.javatpoint.microservice.springjavaprogram.Collections.Map;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("Apple", 10);
        table.put("Banana", 20);
        table.put("Orange", 30);

        // 1️⃣ Using Iterator over entrySet
        System.out.println("Using Iterator:");
        Iterator<Map.Entry<String, Integer>> it = table.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " → " + entry.getValue());
            // table.put("Candy",12); - concurrent modication exception -> Fail Fast
        }

        System.out.println();

        // 2️⃣ Using Enumerator over keys
        System.out.println("Using Enumerator:");
        Enumeration<String> keys = table.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + " → " + table.get(key));
            table.put("Candy",12); // no Exception works on copy/snapshot of collection. Fail-safe
        }
        System.out.println();
        System.out.println();
        Enumeration<String> keys1 = table.keys();
        while (keys1.hasMoreElements()) {
            String key = keys1.nextElement();
            System.out.println(key + " → " + table.get(key));

        }
    }
}
