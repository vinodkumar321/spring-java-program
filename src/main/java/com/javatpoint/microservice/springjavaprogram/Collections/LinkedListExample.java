package com.javatpoint.microservice.springjavaprogram.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String args[]){
       LinkedList<Integer> linkedList = new LinkedList<>();
       /*
       internally uses Doubly Link List to Store Element
       maintains insertion order.
        */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(1);list.add(3);
        list.add(-1);list.add(0);list.add(2);list.add(1);
        list.add(1);list.add(1);list.add(1);list.add(1);list.add(1);
        list.add(2,19);
        linkedList.add(23);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(122);
        linkedList.add(213);
        linkedList.add(1332);
        linkedList.add(231);
        linkedList.add(-12331);
        System.out.println("List elements : ");
        for(Integer k : linkedList){
            System.out.print(k+" ");
        }
        linkedList.addAll(list);
        System.out.println("\n Now List elements : ");
        for(Integer k : linkedList){
            System.out.print(k+" ");
        }
        linkedList.retainAll(list);
        System.out.println("\n And Now List elements : ");
        for(Integer k : linkedList){
            System.out.print(k+" ");
        }
    }
}
