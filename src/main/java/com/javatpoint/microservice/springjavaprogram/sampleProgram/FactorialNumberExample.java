package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialNumberExample {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Integer n;
        BigInteger result = new BigInteger("1");
        System.out.println("Enter n : ");
        n = scanner.nextInt();
        for(int i = 2; i <= n; i++){
            result = result.multiply(new BigInteger(""+i));
        }
        System.out.println("result : "+result);
    }
}
