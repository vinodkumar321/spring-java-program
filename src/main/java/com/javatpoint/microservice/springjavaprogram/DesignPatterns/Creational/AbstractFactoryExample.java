package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Creational;

// Java Creational Design Patterns
// Creational Creational Design Patterns --> deals with Object Creation
/*
 -> Abstract Factory --> interface for creating Falimiles of Related Objects without specifying their concrete Classes
            ---> button + checkbox combinations for Different GUI (Windows or Mac ) and you want to Switch between them Easily
but you will not be able to create Window Button with Mac CheckBox or Window CheckBox with Mac Button.
Like Furniture Facotry
                -> Offeres Victoria Style Sofas and Chairs
                -> Also Offers Mordern Style Sofas and Chairs
                -> We want able to create Matching Set but not non-matching set
                -> A Victorian Style Chair and Mordern Style Sofas or vice-versa.
*/


public class AbstractFactoryExample {
    public static void main(String args[]){
          System.out.println("Creational Design Pattern Examples -> AbstractFactory Method");
          String operatingSystem = "Windows";
          GUIFactory guiFactory = "Mac".equalsIgnoreCase(operatingSystem) ? new MacFactory() : new WindowFactory();
          GUIApplication guiApplication = new GUIApplication(guiFactory);
          guiApplication.paintUI();

    }
}

// Product Button
interface Button {
    public void makeButton();
}

// Product CheckBox
interface CheckBox {
    public void makeCheckBox();
}

class WindowButton implements Button {

    @Override
    public void makeButton() {
        System.out.println("Windows Button Created Successfully....");
    }
}


class MacBookButton implements Button {

    @Override
    public void makeButton() {
        System.out.println("MacBook Button Created Successfully....");
    }
}

class WindowCheckBox implements CheckBox {

    @Override
    public void makeCheckBox() {
        System.out.println("Windows CheckBox Created Successfully....");
    }
}


class MacBookCheckBox implements CheckBox {

    @Override
    public void makeCheckBox() {
        System.out.println("MacBook CheckBox Created Successfully....");
    }
}

interface GUIFactory {
    public Button createButton();
    public CheckBox createCheckbox();
}

class WindowFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new WindowCheckBox();
    }
}


class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacBookButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacBookCheckBox();
    }
}

class GUIApplication {
    Button button;
    CheckBox checkBox;

    public GUIApplication(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckbox();
    }

    public void paintUI(){
        button.makeButton();;
        checkBox.makeCheckBox();
    }

}

