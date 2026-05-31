package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Creational;

// Abstract Factory Design Patterns - interface for creating Families of Related Objects
public class AbstractFactoryExample {
    public static void main(String args[]) {
        AbstractFactory abstractFactory = new MacFactory();
        abstractFactory.makeButton();
        abstractFactory.makeCheckBox();
    }
}

interface Button {
    public void createButton();
}

interface CheckBox {
    public void createCheckBox();
}

class WindowsButton implements Button {

    @Override
    public void createButton() {
        System.out.println("Windows Button is created");
    }
}

class MacButton implements Button {

    @Override
    public void createButton() {
        System.out.println("Mac Button is created");
    }
}

class WindowsCheckBox implements CheckBox {
    @Override
    public void createCheckBox() {
        System.out.println("Windows Check Box is Created");
    }
}

class MacCheckBox implements CheckBox {
    @Override
    public void createCheckBox() {
        System.out.println("Mac Check Box is Created");
    }
}


interface AbstractFactory {
    void makeButton();
    void makeCheckBox();
}

class WindowsFactory implements AbstractFactory{

    Button button;
    CheckBox checkBox;

    public void makeButton() {
        button = new WindowsButton();
        button.createButton();
    }

    public void makeCheckBox() {
        checkBox = new WindowsCheckBox();
        checkBox.createCheckBox();
    }

}

class MacFactory implements AbstractFactory {
    Button button;
    CheckBox checkBox;

    public void makeButton() {
        button = new MacButton();
        button.createButton();
    }

    public void makeCheckBox() {
        checkBox = new MacCheckBox();
        checkBox.createCheckBox();
    }

}