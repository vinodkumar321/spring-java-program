package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural Creational Design Patterns --> deals with the Object Composition
    -> Facade -> Simplified Interface to Complex System.
                        --> Think as Single Remote control for TV , Speaker, Setup box Contolling all three with Single Remote Control.
                        --> System may Include Multiple SubSystems Think of Home Theater System, which includes DVD Player , Projector , SurroundSoundSystem & Lights -> Each component is complex and has its own interface
                        --> HomeTheaterFacade that exposes a simpler interface to the client.
*/


public class FacadeSystem {
    public static void main(String args[]){
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SurroundSoundSystem surroundSoundSystem = new SurroundSoundSystem();
        Lights lights = new Lights();
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(dvdPlayer,surroundSoundSystem,lights,projector);
        homeTheaterFacade.watchMovie("Sanam Teri Kasam 2");
        homeTheaterFacade.endMovie();
    }
}

class DVDPlayer {
    public void on(){
        System.out.println("DVDPlayer is ON.");
    }

    public void off(){
        System.out.println("DVDPlayer is Off.");
    }

    public void play(String movie){
        System.out.println("Watching Movie : "+movie);
    }

    public void stop(){
        System.out.println("Stopping Movie");
    }
}

class Projector {
    public void on(){
        System.out.println("Projector is ON.");
    }

    public void off(){
        System.out.println("Projector is Off.");
    }

    public void setInput(String input){
        System.out.println("Project input set to "+input);
    }
}

class SurroundSoundSystem {
    public void on(){
        System.out.println("SurroundSoundSystem is ON.");
    }

    public void off(){
        System.out.println("SurroundSoundSystem is Off.");
    }

    public void setSoundVolume(Integer input){
        System.out.println("SurroundSoundSystem Volume Level Set to : "+input);
    }
}

class Lights {
    public void on(){
        System.out.println("Lights is ON.");
    }

    public void off(){
        System.out.println("Lights is Off.");
    }

    public void setDim(Integer level){
        System.out.println("Light is in Dim Mode with Level Set to : "+level);
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private SurroundSoundSystem surroundSoundSystem;
    private Lights lights;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvdPlayer,SurroundSoundSystem surroundSoundSystem,Lights lights,Projector projector){
        this.dvdPlayer = dvdPlayer;
        this.surroundSoundSystem = surroundSoundSystem;
        this.lights = lights;
        this.projector = projector;
    }

    public void watchMovie(String name){
        System.out.println("Get ready to watch a movie...");
        lights.setDim(10);  // Dim the lights
        projector.on();  // Turn on the projector
        projector.setInput("DVD");  // Set projector input to DVD
        surroundSoundSystem.on();  // Turn on surround sound system
        surroundSoundSystem.setSoundVolume(5);  // Set the volume
        dvdPlayer.on();  // Turn on the DVD player
        dvdPlayer.play(name);  // Start playing the movie
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater system...");
        lights.on();  // Turn on the lights
        projector.off();  // Turn off the projector
        surroundSoundSystem.off();  // Turn off the surround sound system
        dvdPlayer.stop();  // Stop the DVD player
        dvdPlayer.off();  // Turn off the DVD player
    }

}

