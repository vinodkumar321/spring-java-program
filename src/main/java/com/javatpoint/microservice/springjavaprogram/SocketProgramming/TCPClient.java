package com.javatpoint.microservice.springjavaprogram.SocketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("localhost",2245);
        // I/O
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("Hello from Client!");
        String response = bufferedReader.readLine();
        System.out.println("Server Says : "+response);
        printWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
