package com.javatpoint.microservice.springjavaprogram.SocketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPClient {
    public static void main(String args[]) throws IOException {
        // Create a UDP socket
        DatagramSocket socket = new DatagramSocket();

        // Server address & port
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 2246;

        // Send message to server
        String message = "Hello from UDP Client!";
        DatagramPacket packet = new DatagramPacket(
                message.getBytes(),
                message.length(),
                serverAddress,
                serverPort
        );
        socket.send(packet);

        // Receive response
        byte[] buffer = new byte[1024];
        DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(responsePacket);
        String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("Server says: " + response);

        socket.close();
    }
}
