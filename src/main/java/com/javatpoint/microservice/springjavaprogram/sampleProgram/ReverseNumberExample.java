package com.javatpoint.microservice.springjavaprogram.sampleProgram;

import java.math.BigInteger;
import java.util.Scanner;

public class ReverseNumberExample {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Integer n;
        Long result;
        System.out.println("Enter n : ");
        n = scanner.nextInt();
        //System.out.println(-1%10);
        //System.out.println("Result using String : "+ReverseNumberExample.reverseNumberUsingString(n));
        result = ReverseNumberExample.reverseNumber(n);
        System.out.println("Result using Divide : "+result);
        if(result == n.longValue()){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }

    public static Long reverseNumberUsingString(Integer n){
        Long result = null;
        String str = new String(""+Math.abs(n));
        char arr[] = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer("");
        for(int i = arr.length-1; i>=0; i--){
            stringBuffer.append(arr[i]);
        }
        result = Long.parseLong(stringBuffer.toString());
        if(n < 0)
            result *= -1;
        return result;
    }

    public static Long reverseNumber(Integer n){
        Long result = 0l;
        Integer temp = n;
        while(temp != 0){
            result = result*10 + temp%10;
            temp /= 10;
            //System.out.println("result : "+result);
        }
        return result;
    }

}
