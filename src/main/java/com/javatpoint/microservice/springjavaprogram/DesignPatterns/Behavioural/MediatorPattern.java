package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Mediator -> Reduces Communication between classes , talk to mediator , not each other.
                -> promotes loose coupling by preventing objects from referring to each other directly. Instead, they communicate through a mediator object.
                -> efine an object that encapsulates how a set of objects interact. Promotes loose coupling by keeping objects from referring to each other explicitly.
      -->  Air Tracffic Controller
                -> pilots don't talk to each other directly.
                -> All communication goes via ATC.
                -> ATC Cordinates flight , prevents chaos.
      --> Use Cases : Mediator
                -> UI components (button, form fields, dialogs) managed by a central controller
                -> Chat rooms, air traffic control systems
      --> Benifits
                -> UI components (button, form fields, dialogs) managed by a central controller
                -> Chat rooms, air traffic control systems
*/

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String[] args) {
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Mediator Pattern");
        ChatRoomMediator chatRoom = new ChatRoomMediator();

        User user1 = new ConcreteUser(chatRoom, "Alice");
        User user2 = new ConcreteUser(chatRoom, "Bob");
        User user3 = new ConcreteUser(chatRoom, "Charlie");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hi everyone!");
        user3.send("Hey Alice!");
    }
}

interface ChatMediator {
    void showMessage(User user, String message);
}


class ChatRoomMediator implements ChatMediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void showMessage(User user, String message) {
        for (User u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

class ConcreteUser extends User {

    public ConcreteUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.showMessage(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}




