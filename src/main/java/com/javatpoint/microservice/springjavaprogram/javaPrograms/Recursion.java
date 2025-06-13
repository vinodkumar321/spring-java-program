package com.javatpoint.microservice.springjavaprogram.javaPrograms;

import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
       Integer a,b;
       Scanner scanner = new Scanner(System.in);
       Recursion recursion = new Recursion();
        System.out.println("Enter a : ");
        a = scanner.nextInt();
        System.out.println("Enter b : ");
        b = scanner.nextInt();
        System.out.println("Multiple of a & b : "+ recursion.multiply(a,b));
    }

    public Integer multiply(Integer a, Integer b) {
        if(b==0) {
            return 0;
        }else if(b == 1) {
            return a;
        }else{
            return multiply(a,b-1) + a;
        }

    }

}
