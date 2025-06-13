package com.javatpoint.microservice.springjavaprogram.javaPrograms;

import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        Integer a,b;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        a = scanner.nextInt();
        System.out.print("Enter b : ");
        b = scanner.nextInt();
        System.out.println("LCM of "+a+" & "+b+" : "+lcm(a,b,1,1));
        System.out.println("LCM of "+a+" & "+b+" using 2ndWay : "+lcm2ndWay(a,b));
    }

    public static int lcm(Integer a, Integer b,Integer x,Integer y) {

        if(a == 0) {
            return Math.abs(b);
        }else if(b == 0) {
            return Math.abs(a);
        }else if(Math.abs(a*x) == Math.abs(b*y)) {
            return Math.abs(a*x);
        }else if (Math.abs(a*x) > Math.abs(b*y)) {
            return lcm(a,b,x,y+1);
        }else if (Math.abs(a*x) < Math.abs(b*y)) {
            return lcm(a,b,x+1,y);
        }
        return 0;
    }

    public static int lcm2ndWay(Integer a, Integer b) {

        Integer min,max,i;
        if(a == 0) {
            return Math.abs(b);
        }else if(b == 0) {
            return Math.abs(a);
        }else {
            min = Math.min(Math.abs(a),Math.abs(b));
            max = Math.max(Math.abs(a),Math.abs(b));
            for(i = max; ;i+= max) {
                if(i % min == 0){
                    return i;
                }
            }
        }
    }

}
