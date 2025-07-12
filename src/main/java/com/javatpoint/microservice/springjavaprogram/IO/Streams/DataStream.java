package com.javatpoint.microservice.springjavaprogram.IO.Streams;

import java.io.*;

public class DataStream {
    // Expect Data in BinaryFormat, Designed for Reading/Writing primitives data types
    /*
    readInt() reads 4 bytes from the stream and:

    Combines them into a single 32-bit int.

    Interprets them as a single integer in big-endian order.
    File content is
    1 2 3 4 5 9 0 8
    '1' (49)

    ' ' (32)

    '2' (50)

    ' ' (32)

    ((49 & 0xFF) << 24) | ((32 & 0xFF) << 16) | ((50 & 0xFF) << 8) | (32 & 0xFF)

     (49 << 24) + (32 << 16) + (50 << 8) + 32
        = 822083584 + 2097152 + 12800 + 32
        = 824193568


     */
    public static void main(String args[]) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod2.txt"));
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        Integer bytes = dataInputStream.readInt();
        //for(byte bite : bytes){
            System.out.print(bytes+" ");
        //}
        /*
        String world = "Hello Java World!";
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/java/com/javatpoint/microservice/springjavaprogram/IO/vinod.txt"),true);
        fileOutputStream.write(world.getBytes());
        fileOutputStream.close();
         */
    }
}
