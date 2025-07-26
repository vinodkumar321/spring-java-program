package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Creational;

   // Java Creational Design Patterns
   // Creational Creational Design Patterns --> deals with Object Creation
   //    -> Singleton --> Ensure class Has only one Instance

public class SingletonExample {
     public static void main(String args[]){
         System.out.println("Creational Design Pattern Examples -> SingleTon ");
         SingleTon singleTonExample = SingleTon.getSingleTonExampleObject();
         SingleTon singleTonExample2 = SingleTon.getSingleTonExampleObject();
         if(singleTonExample.equals(singleTonExample2)){
             System.out.println("Same Instances");
         }else{
             System.out.println("Different Instances");
         }
     }
}

class SingleTon {
    private static SingleTon singleTonExample;
    public SingleTon(){
        System.out.println("Instance Created");
    }

    public static SingleTon getSingleTonExampleObject(){
        if(singleTonExample == null){
            singleTonExample = new SingleTon();
        }
        return singleTonExample;
    }

}