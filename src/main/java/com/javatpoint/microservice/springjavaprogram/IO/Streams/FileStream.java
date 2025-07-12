package com.javatpoint.microservice.springjavaprogram.IO.Streams;

import java.io.*;

public class FileStream {
    // Reads/Writes Single Byte from File in one go.
    public static void main(String args[]) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"));
        byte[] bytes = fileInputStream.readAllBytes();
        for(byte bite : bytes){
            System.out.print((char)bite+" ");
        }
        String world = "Hello Java World!";
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"),true);
        fileOutputStream.write(world.getBytes());
        fileOutputStream.close();
    }
}
