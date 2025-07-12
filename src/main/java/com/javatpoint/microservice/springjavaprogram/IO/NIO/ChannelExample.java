package com.javatpoint.microservice.springjavaprogram.IO.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ChannelExample {
    public static void main(String args[]){
        try {

            List<String> contents = Files.readAllLines(Path.of("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"));
            System.out.println(contents.get(0));
            String str = "Hello from NIO!";
            Files.writeString(Path.of("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"),str, StandardOpenOption.APPEND);

            FileChannel fileChannel = FileChannel.open(Path.of("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"));
            ByteBuffer buffer = ByteBuffer.allocate(64);
            while(fileChannel.read(buffer) > 0){
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                System.out.println();
            }
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
