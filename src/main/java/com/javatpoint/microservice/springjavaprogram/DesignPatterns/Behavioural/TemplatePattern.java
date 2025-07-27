package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Template
                -> skeleton of an algorithm in a method, deferring some steps to subclasses. It lets subclasses override specific steps of the algorithm without changing its structure.
                -> Real-World Examples
                        -> Document rendering (Word, PDF generation)
                        -> Hook methods in frameworks like Spring and JUnit
                        -> Lifecycle methods (init(), start(), destroy() in servlets)
                -> Benefits
                        -> Code reuse (common steps in base class)
                        -> Enforces a consistent structure
                        -> Flexible customization by subclasses
*/

public class TemplatePattern {
    public static void main(String[] args) {
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Template Pattern");
        BeverageMaker tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        BeverageMaker coffee = new Coffee();
        coffee.prepareRecipe();
    }
}


abstract class BeverageMaker {

    // Template Method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps to be customized by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
}

class Tea extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}


