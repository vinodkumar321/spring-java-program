package com.javatpoint.microservice.springjavaprogram.varargs;

public class VariableNumberArgument {
    public static void main(String args[]){
        System.out.println("Variable Arguments Length : "+args.length);
        // calculate sum
        Integer input = null;
        Integer sum = 0;
        for(String s : args){
            input = Integer.parseInt(s);
            sum += input;
        }
        // sum
        System.out.println("Sum : "+sum);
    }
}
