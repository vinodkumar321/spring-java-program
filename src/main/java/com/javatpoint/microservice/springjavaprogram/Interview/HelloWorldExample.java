package com.javatpoint.microservice.springjavaprogram.Interview;

import java.util.*;

public class HelloWorldExample {
    public static void main(String args[]){
        // find anagrams
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array Length ");
        Integer n = sc.nextInt();
        System.out.println("Enter array Strings ");
        String arr[] = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }
        // now we have input
        HelloWorldExample helloWorldExample = new HelloWorldExample();
        List<List<String>> result = helloWorldExample.findAnagram(arr);
        for(List<String> list : result){

            System.out.println(list.toString());
        }
    }

   public List<List<String>> findAnagram(String[] arr){
       Map<String,List<String>> result = new HashMap<>();
       List<List<String>> result2 = new ArrayList<>();
       List<String> list = null;
       String key = null;
       int len = arr.length;
       for(String str : arr){
           int[] count = new int[26];
           for(char c : str.toCharArray()){
               count[c-'a']++;
           }
           key = Arrays.toString(count);
           result.computeIfAbsent(key,k -> new ArrayList<>()).add(str);
       }
       result2.addAll(result.values());
       return result2;
   }

}





/*
Give an array of strings,group the anagrams together

input:[["eat","tea","tan","ate","nat","bat"]]

output:[["bat"],["nat","tan"],["ate","eat","tea"]]
 */