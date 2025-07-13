package com.javatpoint.microservice.springjavaprogram.SocketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

public class UDPServer {
    public static void main(String args[]) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(2246);
        System.out.println("Server Connected , waiting for client");
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
        // receive data
        datagramSocket.receive(datagramPacket);
        String message = new String(datagramPacket.getData(),0, buffer.length);
        System.out.println("Client Says : "+message);
        String response = "Hello from UDP Server!";
        DatagramPacket datagramPacket1 = new DatagramPacket(response.getBytes(),response.length()
                ,datagramPacket.getAddress(),datagramPacket.getPort());
        datagramSocket.send(datagramPacket1);
        datagramSocket.close();

    }
}
