package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Strategy -> Select Algorithm behaviour at Run-time.
                    --> Think of Payment Methods at E-commerce Website. UPI , Cash on Delivery , Credit card, NetBanking.
                    --> Think of Sorting of Students Marks ( using mergesort, quick-sort)
                    --> Navigation Apps : navigate through car or bike or walk final destination will be same.
*/

public class StrategyPattern {
    public static void main(String args[]){
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Strategy");
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(500); // Paid 500 using Credit Card.
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(250); // Paid 250 using PayPal.

    }
}

// Behavioural Design Patterns -> Strategy
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }
}
