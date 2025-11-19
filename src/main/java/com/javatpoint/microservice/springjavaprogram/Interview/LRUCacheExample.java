package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {
    public static void main(String args[]){
        LRUCache cache = new LRUCache(3);
        cache.put(1, 'A');
        cache.printCacheState();
        System.out.println();
        cache.put(2, 'B');
        cache.printCacheState();
        System.out.println();
        cache.put(3, 'C');
        cache.printCacheState();
        System.out.println();
        cache.get(1);
        cache.printCacheState();
        System.out.println();
        cache.put(4, 'D'); // removes key=2
        cache.printCacheState();
        System.out.println();
    }
}

class LRUCache {
    private final Integer capacity;
    private final Map<Integer,Node> cache;
    private final DoublyLinkList doublyLinkList;

    public LRUCache(Integer capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.doublyLinkList = new DoublyLinkList();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Map<Integer, Node> getCache() {
        return cache;
    }

    public DoublyLinkList getDoublyLinkList() {
        return doublyLinkList;
    }

    public String printMap(){
        StringBuffer stringBuffer = new StringBuffer("{ ");
        for(Integer key : cache.keySet()){
            stringBuffer.append(key+":"+cache.get(key).value+",");
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }

    public Character get(Integer key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            // bring this node to head position
            doublyLinkList.moveToHead(node);
            return node.value;
        }else{
            return '-';
        }
    }

    public void put(Integer key,Character value){
        // check if present , update value of that key
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            // move to Head position
            doublyLinkList.moveToHead(node);
        }else{
            // check capacity first
            if(cache.size() == capacity){
                Node node = doublyLinkList.removeTailNode();
                cache.remove(node.key);
            }
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            doublyLinkList.putAtHead(newNode);
        }
    }


    private static class Node {
        Integer key;
        Character value;
        Node prev,next;
        public Node(Integer key,Character value){
            this.key = key;
            this.value = value;
        }
    }

    public void printCacheState(){
        Node node = doublyLinkList.head.next;
        while(node !=doublyLinkList.tail){
            System.out.print(node.key+":"+node.value+" , ");
            node = node.next;
        }
    }

    private static class DoublyLinkList {
        LRUCache.Node head,tail;

        public DoublyLinkList(){
            head = new LRUCache.Node(0,'0');
            tail = new LRUCache.Node(0,'0');
            tail.next = null;
            tail.prev = head;
            head.prev = null;
            head.next = tail;
        }

        public void putAtHead(LRUCache.Node node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void moveToHead(LRUCache.Node node){
             node.prev.next = node.next;
             node.next.prev = node.prev;
             node.next = null;
             node.prev = null;
             putAtHead(node);
        }

        public LRUCache.Node removeTailNode(){
            LRUCache.Node result = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            result.next = null;
            result.prev = null;
            return result;
        }

    }

}
