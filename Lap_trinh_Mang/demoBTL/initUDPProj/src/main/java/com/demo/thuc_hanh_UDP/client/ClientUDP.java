package com.demo.thuc_hanh_UDP.client;

import java.io.IOException;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Client started...");
        String msg = "Data from Client !";
        //send Data
        byte buferString[] = msg.getBytes();
        InetAddress ia = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(buferString, buferString.length, ia, 2208);
        ds.send(dp);
        System.out.println("Packet sending...");
        //get Data
        byte rD1[] = new byte[1024];
        DatagramPacket dprD1 = new DatagramPacket(rD1, rD1.length);
        ds.receive(dprD1);
        String str = new String(dp.getData());
        System.out.println("Receive Data from server : " + str);
    }
}
