package com.javatpoint.microservice.springjavaprogram.InstanceInitializerBlock;

public class InstanceInitializerBlockExample {
    public static void main(String args[]){
        new Bike();
        new Bike("Black");
    }
}


class Vehicle {
    String color;
    public Vehicle(){
        System.out.println("Vehicle Constructor Called");
    }
}

class Bike extends Vehicle {

    // Instance Initializer Block
    {
        System.out.println("Instance Initializer Block is Called");
    }

    public Bike(){
        System.out.println("Bike Constructor Called");
    }

    public Bike(String color){
        this.color = color;
        System.out.println("Bike Constructor Called with color : "+color);
    }

}