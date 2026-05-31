package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

// Creational - Prototype Design Pattern
// when object creation is costly , when we want duplicate objects with slight modification by cloning it.
public class PrototypeExample {
    public static void main(String args[]) {
        Circle original = new Circle("Red",2.23);
        Circle copy = original.clone();
        copy.setColor("blue");
        copy.setRadius(2.88);
        System.out.println(original);
        System.out.println(copy);
    }
}

interface Prototype extends Cloneable {
    Prototype clone();
}

class Circle implements Prototype {

    private String color;
    private Double radius;

    public Circle(String color, Double radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this.color,this.radius);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}