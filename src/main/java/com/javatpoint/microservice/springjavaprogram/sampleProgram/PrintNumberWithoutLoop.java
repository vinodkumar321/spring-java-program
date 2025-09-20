package com.javatpoint.microservice.springjavaprogram.sampleProgram;

public class PrintNumberWithoutLoop {
    public static void main(String args[]){
        PrintNumberWithoutLoop printNumberWithoutLoop = new PrintNumberWithoutLoop();
        printNumberWithoutLoop.printNumbersWithoutLoop(100);
    }

    public void printNumbersWithoutLoop(Integer n){
        if(n == 1){
            System.out.println(n);
            return;
        }else{
            printNumbersWithoutLoop(n-1);
            System.out.println(n);
        }
    }
}
