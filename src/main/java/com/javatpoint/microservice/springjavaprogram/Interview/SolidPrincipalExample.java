package com.javatpoint.microservice.springjavaprogram.Interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class SolidPrincipalExample {
    public static void main(String args[]){
        Discount discount = new NoDiscoount();
        Billing billing = new Billing(discount);
        System.out.println("No Discount price : "+billing.calculateDiscount(100,discount));
        discount = new SeasonalDiscoount();
        Billing billing2 = new Billing(discount);
        System.out.println("Seasonal Discount price : "+billing.calculateDiscount(100,discount));

    }
}

interface Discount {
     double apply(double price);
}

class NoDiscoount implements Discount {
     @Override
     public double apply(double price) {
         return price;
     }
 }

class SeasonalDiscoount implements Discount {
    @Override
    public double apply(double price) {
        return price*.90;
    }
}

class Billing {
    private final Discount discount;

    public Billing(Discount discount){
        this.discount = discount;
    }
    public double calculateDiscount(double price,Discount discount){
        return discount.apply(price);
    }
}

interface Bird {

}

interface FlyingBird extends Bird{
    void fly();
}


class Ostrich implements Bird {
    // now we can't implement fly() method
    // valid as Ostrich is Bird but not the Flying one.
}

class Sparrow implements FlyingBird {

    @Override
    public void fly() {
        System.out.println("Sparrow is flying..");
    }
}

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}


class Robot implements Workable {

    @Override
    public void work() {
        // this is Ok.
    }
}


interface Database {
    void connect();
}

class MysqlDB implements Database {

    @Override
    public void connect() {
        // config. to connect MySQL DB.
    }
}

class PostgresqlDB implements Database {

    @Override
    public void connect() {
        // config. to connect PostgreSql DB.
    }
}

class App {
    private final Database database;
    public App(Database database){
        this.database = database;
    }
    // now we can inject any DB , without modifying the App Class
}

interface Engine {
    void start();
}

@Component
class PetrolEngine implements Engine {

    @Override
    public void start() {
        // starting.... Petrol Engine.
    }
}

@Component
class Cars {
    private final Engine engine;

    @Autowired // constructor injection
    public  Cars(Engine engine){
        this.engine = engine;
    }
    public void drive() {
        this.engine.start();
    }
    // here Cars , doesn't care which Engine it gets.
    // Spring inject Appropriate Engine Implementation.
    // Easily replaceable PetrolEngine with Diesal
    // or Mock Engines
}




// failed during Constructor Injection
// with BeanConcurrentlyinCreation Exception.

