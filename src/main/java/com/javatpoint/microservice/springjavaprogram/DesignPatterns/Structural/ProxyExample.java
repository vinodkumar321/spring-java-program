package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural Design Patterns --> deals with the Object Composition
    -> Proxy  -->  Controlled Access to an Object. Credit Card Virtual Money is proxy for our Actual Money. Controlled Acess , Track Usage & Adds some Security.
            -> Virtual Proxy --> lazy Loading.
            -> Protection Proxy --> Deals with Permission.
            -> Remote Proxy --> Represent Object in Diffrent Object Space ( RMI ).
            -> Smart Proxy -->  Adds Additional Behaviour.
 */

public class ProxyExample {
    public static void main(String args[]){
        System.out.println("Structural Design Pattern Examples -> Proxy");
        Image image = new ProxyImage("Vinod.jpg");
        System.out.println("First display call");
        image.display();

        System.out.println("Second display call");
        image.display();
    }
}

// Proxy Pattern Related Classes
interface Image{
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("Displaying Image : "+this.fileName);
    }

    public void loadFromDisk() {
        System.out.println("Loading File From Disk : "+this.fileName);
    }
}

class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if(this.realImage == null) {
            this.realImage = new RealImage(this.fileName); // lazy loading , loading when only it is needed Costly Operation.
            realImage.loadFromDisk();
        }
        realImage.display();
    }
}

