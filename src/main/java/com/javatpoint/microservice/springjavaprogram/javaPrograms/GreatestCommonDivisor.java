package com.javatpoint.microservice.springjavaprogram.javaPrograms;

import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        Integer m,n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m : ");
        m = scanner.nextInt();
        System.out.println("Enter n : ");
        n = scanner.nextInt();
        System.out.println("GCD of m & n : "+gcdOfGreatestCommonDivisor(m,n));
    }

    public static Integer gcdOfGreatestCommonDivisor(int m, int n) {
        if(n==0){
            throw new ArithmeticException("Greatest common divisor by zero");
        } else if (m % n == 0) {
            return n;
        }else{
            return gcdOfGreatestCommonDivisor(n,m%n);
        }
    }


}
