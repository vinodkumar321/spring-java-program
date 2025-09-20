package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.util.Scanner;

public class LeapYearSample {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter year : ");
            Integer year = scanner.nextInt();
            System.out.println(year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0)));
        } catch (Exception e) {
            System.out.println("Exception Occured : "+e.getMessage());
        }
    }
}
