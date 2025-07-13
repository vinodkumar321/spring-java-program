package com.javatpoint.microservice.springjavaprogram.SocketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2245);
        System.out.println("Server Connected , waiting for client");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
        String message = bufferedReader.readLine();
        System.out.println("Client says : "+message);
        printWriter.print("Hello from Server!");
        printWriter.close();
        bufferedReader.close();
        clientSocket.close();
        serverSocket.close();
    }
}
