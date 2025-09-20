package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.util.Scanner;

public class ArmStrongNumber {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Integer n;
        boolean result;
        System.out.println("Enter n : ");
        n = scanner.nextInt();
        ArmStrongNumber armStrongNumber = new ArmStrongNumber();
        result = armStrongNumber.checkArmsStrongNumber(n);
        if(result){
            System.out.println("ArmStrong Number");
        }else{
            System.out.println("Not an ArmStrong Number");
        }
    }

    public boolean checkArmsStrongNumber(Integer n){
        boolean result = false;
        Integer temp;
        int sum;
        temp = n;
        sum = 0;
        while(temp != 0){
            sum += (int) Math.pow(temp%10,3);
            temp /= 10;
        }
        if(sum == n)
            result = true;
        return result;
    }

}
