package com.javatpoint.microservice.springjavaprogram.IO.Character;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReaderExample {
    public static void main(String args[]) throws IOException {
        FileReader fileReader = new FileReader(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"));
        char[] buffer = new char[100];
        fileReader.read(buffer);
        for(char ch : buffer){
            System.out.print(ch+" ");
        }
        String greetMessgae = "Welcome to BookMyShow";
        FileWriter fileWriter = new FileWriter(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"),true);
        fileWriter.write(greetMessgae);
        fileWriter.close();
    }
}
