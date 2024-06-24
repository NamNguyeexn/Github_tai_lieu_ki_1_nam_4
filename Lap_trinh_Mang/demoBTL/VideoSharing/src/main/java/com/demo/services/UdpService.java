package com.demo.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class UdpService {

    private DatagramSocket socket;

    @PostConstruct
    public void init() throws IOException {
        // Khởi tạo socket UDP
        socket = new DatagramSocket();
    }

    // Phương thức gửi dữ liệu
    public void sendData(byte[] data, InetAddress ip, int port) throws IOException {

        DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);

        socket.send(packet);
    }

    // Phương thức nhận dữ liệu
    public byte[] receiveData() throws IOException {

        byte[] buffer = new byte[65535];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        return packet.getData();
    }

    // Đóng socket khi service ngừng hoạt động
    @PreDestroy
    public void destroy() {
        socket.close();
    }

}