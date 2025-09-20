package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Integer a,b,c;
        System.out.println("Enter a : ");
        a = scanner.nextInt();
        System.out.println("Enter b : ");
        b = scanner.nextInt();
        c = a;
        a = b;
        b = c;
        System.out.println("a : "+a+" , b : "+b);
        // without using 3rd variable
        a += b;
        b -= a;
        b *= -1;
        a -= b;
        System.out.println("a : "+a+" , b : "+b);
    }
}
