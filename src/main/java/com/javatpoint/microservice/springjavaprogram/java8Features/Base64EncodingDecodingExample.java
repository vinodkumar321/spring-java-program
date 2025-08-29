package com.javatpoint.microservice.springjavaprogram.java8Features;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodingDecodingExample {
    public static void main(String args[]){
        String str = "Hello Vinod Kumar Chandani, Welcome to the Java World!";
        byte[] bytes = Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8));
        System.out.println("String str : "+str);
        System.out.println("Encoded String with Base64 Encoder : "+new String(bytes));
        String decodedString  = new String(Base64.getDecoder().decode(bytes),StandardCharsets.UTF_8);
        System.out.println("Decoded String with Base64 Decoder : "+decodedString);

    }
}
