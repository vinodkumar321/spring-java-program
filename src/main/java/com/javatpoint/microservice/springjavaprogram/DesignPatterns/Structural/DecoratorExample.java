package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural Design Patterns --> deals with the Object Composition
    -> Decorator -> Add New Behaviour to Object Dynamically without Altering Structure.
*/

public class DecoratorExample {
    public static void main(String args[]){
        System.out.println("Structural Design Pattern Examples -> Decorator");
        Beverages coffee = new Coffee();
        CoffeeDecorator coffeeWithMilk = new MilkCoffeeDecorator(coffee);
        System.out.println("Description : "+coffeeWithMilk.getDescription());
        System.out.println("Cost : "+coffeeWithMilk.getCost());
        CoffeeDecorator coffeeWithSugar = new SugarCoffeeDecorator(coffee);
        System.out.println("Description : "+coffeeWithSugar.getDescription());
        System.out.println("Cost : "+coffeeWithSugar.getCost());
    }
}

interface Beverages {
    public String getDescription();
    public Double getCost();
}


class Coffee implements Beverages {

    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public Double getCost() {
        return 15.34;
    }
}

abstract class CoffeeDecorator implements Beverages {
    Beverages beverages;

    public CoffeeDecorator(Beverages beverages){
        this.beverages = beverages;
    }
    @Override
    public abstract String getDescription();

    @Override
    public abstract Double getCost();
}

class MilkCoffeeDecorator extends CoffeeDecorator {

    public MilkCoffeeDecorator(Beverages beverages) {
        super(beverages);
    }

    @Override
    public String getDescription() {
        return this.beverages.getDescription()+" with Milk";
    }

    @Override
    public Double getCost() {
        return this.beverages.getCost()+13.23;
    }
}

class SugarCoffeeDecorator extends CoffeeDecorator {

    public SugarCoffeeDecorator(Beverages beverages) {
        super(beverages);
    }

    @Override
    public String getDescription() {
        return this.beverages.getDescription()+" with Sugar";
    }

    @Override
    public Double getCost() {
        return this.beverages.getCost()+3.23;
    }
}


