package com.demo.thuc_hanh_UDP.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class ServerUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2208);
            System.out.println("Server is running");
            byte[] receive = new byte[1024];
            while (true) {
                DatagramPacket receiveDatagramPacket = new DatagramPacket(receive, receive.length);
                server.receive(receiveDatagramPacket);
                String studentInfo = new String(receiveDatagramPacket.getData(), 0, receiveDatagramPacket.getLength());
                String[] listStudentInfo = studentInfo.split("\\;");
                for (String i : listStudentInfo) {
                    System.out.println(i);
                }
                String msg = "932;vo huu tuan";
                DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), receiveDatagramPacket.getAddress(), receiveDatagramPacket.getPort());
                server.send(sendPacket);
                String requestId = msg.split(";")[0];
                String data = msg.split(";")[1];
                data = String.join(",", Arrays.stream(data.split("\\s")).map(it -> it.substring(0, 1).toUpperCase() + it.substring(1).toLowerCase()).toList());
                String answer = requestId + ";" + data;
                receive = new byte[1024];
                receiveDatagramPacket = new DatagramPacket(receive, receive.length);
                server.receive(receiveDatagramPacket);
                String receiveAnswer = new String(receiveDatagramPacket.getData(), 0, receiveDatagramPacket.getLength());
                System.out.println("chuoi goc: " + answer + " size = " + answer.length());
                System.out.println("chuoi tu client: " + receiveAnswer + " size = " + answer.length());
                if (answer.equals(receiveAnswer)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
