package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural Design Patterns --> deals with the Object Composition
    -> FlyWeight --> Reduces Memory uses by Sharing Common Data.
                            --> Think of Text Editor , where each character has different position (x,y) , but they have shared font family , font size and style usually.
                            --> Game Design with Millions of trees , where each tree has
                                   -->  Unique position (x,y)
                                   -->  Shared state ( Type,Texture,Color)
                                   --> Instead of storing data for Each tree , store data once & simply reference it.
                            ---> Icon's in IDE or Browsers.
 */

import java.util.HashMap;
import java.util.Map;

public class FlyWeightExample {
    public static void main(String args[]){
        System.out.println("Structural Design Pattern Examples -> FlyWeight Example");
        String text = "hello";
        Integer x = 0;
        ConcreteCharacterFactory concreteCharacterFactory = new ConcreteCharacterFactory();
        java.lang.Character character = null;
        for(char ch : text.toCharArray()){
            Character character1 = concreteCharacterFactory.getCharater(ch);
            character1.display(x++, 1); // x is extrinsic
        }
    }
}

// FlyWeight
interface Character {
    public void display(int x,int y);
}

class ConcreteCharacter implements Character {

    private char symbol; // interensic -- specific to Object

    public ConcreteCharacter(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Character : "+this.symbol+" , position (x,y) "+x+","+y);
    }
}

class ConcreteCharacterFactory {
    Map<java.lang.Character, ConcreteCharacter> characterMap = new HashMap<>();
    public Character getCharater(char ch){
        characterMap.putIfAbsent(ch,new ConcreteCharacter(ch));
        return characterMap.get(ch);
    }
}

