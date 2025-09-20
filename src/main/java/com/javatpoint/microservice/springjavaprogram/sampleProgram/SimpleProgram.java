package com.javatpoint.microservice.springjavaprogram.sampleProgram;

public class SimpleProgram {
    public static void main(String args[]){
        String str = "Hello";
        String str2 = "Hello";
        StringBuffer stringBuffer = new StringBuffer(str);
        String str3 = stringBuffer.append('k').toString();
        System.out.println("str : "+str);
        System.out.println("str2 : "+str2);
        System.out.println("str3 : "+str3);
    }


}
