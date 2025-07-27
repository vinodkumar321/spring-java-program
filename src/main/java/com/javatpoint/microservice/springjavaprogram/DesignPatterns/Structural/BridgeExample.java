package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural Design Patterns --> deals with the Object Composition
    -> Bridge --> Seperates Abstarction From Implementation , creating shapes & want to support Different Rendering Modes
 */

public class BridgeExample {
    public static void main(String args[]){
        System.out.println("Structural Design Pattern Examples -> Bridge");
        Device tv = new TV();
        Device radio = new Radio();
        Remote remote = new BasicRemote(tv);
        remote.togglePower();
        remote.togglePower();
        remote = new BasicRemote(radio);
        remote.togglePower();
        remote.togglePower();
    }
}

// Bridge Pattern Related Classes
// Implementor
interface Device {
    void turnOn();
    void turnOff();
}

// ConcreteImplementors
class TV implements Device {
    public void turnOn() {
        System.out.println("TV turned ON");
    }
    public void turnOff() {
        System.out.println("TV turned OFF");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio turned ON");
    }
    public void turnOff() {
        System.out.println("Radio turned OFF");
    }
}

// Abstraction
abstract class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    abstract void togglePower();
}

// Refined Abstraction
class BasicRemote extends Remote {
    private boolean on = false;

    public BasicRemote(Device device) {
        super(device);
    }

    public void togglePower() {
        if (on) {
            device.turnOff();
        } else {
            device.turnOn();
        }
        on = !on;
    }
}

