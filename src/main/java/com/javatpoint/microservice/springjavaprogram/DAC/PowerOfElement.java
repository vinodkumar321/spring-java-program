package com.javatpoint.microservice.springjavaprogram.DAC;

import java.util.Scanner;

public class PowerOfElement {
    public static void main(String[] args) {
        Integer n,p;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n : ");
        n = scanner.nextInt();
        System.out.print("Enter p : ");
        p = scanner.nextInt();
        System.out.println("value of "+n+" power "+p+" : "+isPowerOf2(n,p));
    }
    public static Double isPowerOf2(Integer n,Integer p) {
        Double result;
        if(p == 0){
            return 1.0;
        } else if (p == 1) {
            return n.doubleValue();
        } else if (p == -1) {
            return 1/n.doubleValue();
        }else{
            result = isPowerOf2(n,p/2);
            result = result*result;
            if(p % 2 == 1){
                result = result*n;
            }
            return result;
        }
    }
}
