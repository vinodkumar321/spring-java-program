package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Command  -> Decouple the Sender of an Request from the Object that executes it.
                    --> Task Queues, Remote-Controllers
                    --> Think it of as Restaurant
                            --> Waiter Takes Order -- command
                            --> Chef Prepares it.
                            --> waiter don't need to know how to cook. just need to Know how to Deliver commnand to Kitchen.
                            --> Think of a remote control for a smart home. Each button is linked to a command (like turn on lights, play music).
                                    --> The remote doesn't need to know how the light or music works — it just sends the command.
*/

public class CommandPattern {
    public static void main(String args[]){
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Command");
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();

    }
}

// Behavioural Design Patterns -> Command
interface Command {
    public void execute();
}

class Light {
    public void turnOn(){
        System.out.println("Light is Turned ON.");
    }

    public void turnOff(){
        System.out.println("Light is Turned OFF.");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }
}


class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }

}

class ConcreteCommand implements Command {
    private Light light;
    @Override
    public void execute() {
        light.turnOn();
    }
}

