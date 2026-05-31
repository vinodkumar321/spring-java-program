package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

// Factory Design Pattern -
// Provides Interface for Object creation and allows Subclass to alter type of object to be created at run-time.
/*
      Use Case
           * DriverManager.getConnection(url) - pass DB Specific URL and get MySQL, POstgresSql or Oracle DB Object as Required.
           * Spring Framework Bean  - Spring IOC Container , acts like container
             , creates & Manages beans using ApplicationContext.getBean()
           * GUI Frameworks - Button , label creted based on config setting on different OS - Windows/Unix/Linux
           * Logger Factory to return correct logger. based on Configuration log4j or Logback
           * PaymentGateway - UPI , Card / Credit card / NetBanking.
 */
public class Factory {
    public static void main(String args[]) {
        Animal cat = AnimalFactory.getInstance("Cat");
        Animal dog = AnimalFactory.getInstance("Dog");
        cat.sound();
        dog.sound();
    }
}

interface Animal {
    void sound();
}

class Dog implements Animal {
   @Override
   public void sound() {
       System.out.println("Bow Bow...");
   }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meaw Meaw...");
    }
}

class AnimalFactory {

    public AnimalFactory(){
    }

    public static Animal getInstance(String animalName){
        Animal animal = null;
        if(animalName.equalsIgnoreCase("Cat")) {
            animal = new Cat();
        }

        if(animalName.equalsIgnoreCase("Dog")) {
            animal = new Dog();
        }

        return animal;
    }

}