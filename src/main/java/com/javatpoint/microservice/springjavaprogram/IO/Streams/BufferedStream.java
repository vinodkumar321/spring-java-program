package com.javatpoint.microservice.springjavaprogram.IO.Streams;

import java.io.*;

public class BufferedStream {
    // Reads Bytes from file in one go.
    public static void main(String args[]) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,5);
        // reads 5 bytes at one, without 5 it reads 8192 B (8KB) data in one hit.
        byte[] bytes = bufferedInputStream.readAllBytes();
        for(byte bite : bytes){
            System.out.print((char)bite+" ");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt")
                ,true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        String intro = "Please Tell us About YourSelf..";
        bufferedOutputStream.write(intro.getBytes());
        bufferedOutputStream.flush(); // until flush() or close() not called , data is in internal buffer & not written to file.
    }
}
