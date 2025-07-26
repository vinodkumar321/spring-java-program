package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Creational;

// Java Creational Design Patterns
// Creational Creational Design Patterns --> deals with Object Creation
/*
  -> Builder --> simplify the complex Object Creation Step by Step. constructor process can create different Representations of Object. Think of Computer System creation Process Which Requires processor, RAM, hard drive, etc.
*/


public class BuilderExample {
    public static void main(String args[]){
        System.out.println("Creational Design Pattern Examples -> Builder, simplyfy Complex Object creation .... Assume Computer Creation Process Which Requires processor, RAM, hard drive, etc.");
        Computer computer = new Computer.Builder()
                .setRam("8 GB")
                .setProcessor("Intel i7")
                .setStorage("512 GB")
                .build();
        Computer computer2 = new Computer.Builder()
                .setRam("16 GB")
                .setProcessor("Intel i5")
                .setStorage("256 GB")
                .build();
        System.out.println(computer);
        System.out.println(computer2);
    }
}

class Computer {
    private String processor;
    private String ram;
    private String storage;

    public Computer(Builder builder){
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    // Builder Class
    public static class Builder {
        private String processor;
        private String ram;
        private String storage;

        public String getProcessor() {
            return processor;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public String getRam() {
            return ram;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public String getStorage() {
            return storage;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }

    @Override
    public String toString(){
        return "Computer with Specifications [ Processor : "+this.getProcessor()+" , Storage : "+this.getStorage()+" , RAM : "+this.getRam()+" ] created.";
    }

}

