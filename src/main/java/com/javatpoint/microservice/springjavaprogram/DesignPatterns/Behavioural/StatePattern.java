package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  State  --> Changes Behaviour based on Object state.
                        --> Think of Vending Machine
                                --> idle State  -->  waits for Selection
                                --> hasMoney  -->  Allows Selection
                                --> Sold out --> Reject Purchase
      --> Real World Analogy -> Traffic Light Green/Red/Yellow
                --> Each Light behaviour is different , Light controller just changes it's state.
                Red → Wait
                Green → Go
                Yellow → Slow down
*/

public class StatePattern {
    public static void main(String args[]){
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> State");
        VendingMachine vm = new VendingMachine();
        vm.pressButton();   // Insert coin first!
        vm.cancelButton(); // Transaction Cancelled
        vm.insertCoin();    // Coin inserted
        vm.cancelButton();
        vm.insertCoin();
        vm.pressButton();   // Product dispensed
    }
}

interface State {
    void insertCoin();
    void pressButton();
    void cancelTransaction();
}

class NoCoinState implements State {
    public void insertCoin() {
        System.out.println("Coin inserted. You can now press the button.");
    }

    public void pressButton() {
        System.out.println("Insert coin first!");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction Not Initiated!");
    }
}

class HasCoinState implements State {
    public void insertCoin() {
        System.out.println("Coin already inserted!");
    }

    public void pressButton() {
        System.out.println("Product dispensed.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction Cancelled, Please collect Money Back.");
    }

}

class VendingMachine {
    private State state;

    public VendingMachine() {
        state = new NoCoinState(); // default state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin();
        setState(new HasCoinState()); // Transition to HasCoinState
    }

    public void pressButton() {
        state.pressButton();
        setState(new NoCoinState()); // Reset back to NoCoinState
    }

    public void cancelButton() {
        state.cancelTransaction();
        setState(new NoCoinState()); // Reset back to NoCoinState
    }

}





