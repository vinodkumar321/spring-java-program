package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Creational;

/*
    // Java Creational Design Patterns
     Creational Creational Design Patterns --> deals with Object Creation
    -> Prototype --> creates new Object by copying Existing one. -> used when cost of creating a New Object is complex or Expensive and Object Cloning saves time as well.
*/

public class PrototypeExample {
    public static void main(String args[]){
        System.out.println("Creational Design Pattern Examples -> prototype Method -> Creating Book Original & clone of Original Book");
        Book book = new Book("Let us C","Yaswant Rai Kanetkar",39.89);
        Book clonedBook = (Book) book.clone();
        System.out.println("Book => "+book);
        System.out.println("Cloned Book => "+clonedBook);
        clonedBook.setAuthor("Robert Schilbertez");
        clonedBook.setName("Operation System");
        clonedBook.setPrice(89.12);
        System.out.println("after cloned Book Modification...");
        System.out.println("Book => "+book);
        System.out.println("Cloned Book => "+clonedBook);

    }
}

interface Prototype {
    Prototype clone();
}

class Book implements Prototype {
    private String name;
    private String author;
    private Double price;

    public Book(String name,String author,Double price){
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Prototype clone() {
        return new Book(this.name,this.author,this.price);
    }

    @Override
    public String toString(){
        return "Book  [ Name : "+this.getName()+" , Author : "+this.getAuthor()+" , Price : "+this.getPrice()+" ]";
    }

}




