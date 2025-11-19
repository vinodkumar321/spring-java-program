package com.javatpoint.microservice.springjavaprogram.Interview;

public class OverrideMethodRestrictiveExample {
    public static void main(String args[]){
        new Vehicle("Red").display();
    }
}

class Vehicle {
    String color;

    public Vehicle(String color) {
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected void display(){
        System.out.println("Vehicle colour : "+this.color);
        System.err.println("Vehicle colour : "+this.color);
    }

}

class Car extends Vehicle {

    public Car(String color) {
        super(color);
    }

    @Override
    protected void display(){
        System.out.println("Vehicle colour : "+this.color);
        System.err.println("Vehicle colour : "+this.color);
    }


}


