package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Creational;

// Java Creational Design Patterns
// Creational Creational Design Patterns --> deals with Object Creation
// -> Factory Method --> interface for Object creation , type of Objects created can be altered by subclasses

public class FactoryMethod {
    public static void main(String args[]){
        System.out.println("Creational Design Pattern Examples -> Factory Method");
        Animal animal = AnimalFactory.getInstanceOfAnimal("Dog");
        animal.sound();
        animal = AnimalFactory.getInstanceOfAnimal("Cat");
        animal.sound();

    }
}

class AnimalFactory {
    public static Animal getInstanceOfAnimal(String type){
        Animal animal = null;
        if(type.equalsIgnoreCase("Dog")){
            animal = new Dog();
        }
        if(type.equalsIgnoreCase("Cat")){
            animal = new Cat();
        }
        return animal;
    }
}

interface Animal {
    public void sound();
}

class Dog implements Animal{

    @Override
    public void sound() {
        System.out.println("bhoo bhoo");
    }
}


class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("Meaw Meaw");
    }
}

