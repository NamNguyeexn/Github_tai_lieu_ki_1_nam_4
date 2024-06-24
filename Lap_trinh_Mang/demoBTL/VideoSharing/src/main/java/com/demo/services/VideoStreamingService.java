package com.demo.services;

import com.demo.models.Video;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
public class VideoStreamingService {

    private UdpService udpService;

    // Chia video thành các packet
    public void splitVideoToPackets(Video video) {

        int packetSize = 1000; // Kích thước 1 packet

        for(int i = 0; i < video.getSize(); i+= packetSize) {

            byte[] packet = new byte[packetSize];

            // Lấy dữ liệu từ vị trí i đến i+packetSize của video
            System.arraycopy(video.getData(), i, packet, 0,
                    Math.min(video.getData().length - i, packetSize));

            // Gán ID cho packet
            packet.setId(i/packetSize);

            // Gửi packet
            udpService.sendData(packet, ip, port);
        }
    }

    // Gọi phương thức này khi có yêu cầu phát video
    public void streamVideo(Video video, InetAddress ip, int port) {

        splitVideoToPackets(video);
    }
    public void receivePackets(InetAddress ip, int port) throws Exception {

        while(true) {

            byte[] packet = udpService.receiveData();

            int id = extractPacketId(packet);

            packets.put(packet); // Lưu packet vào Map

            if(packets.isComplete()) { // Nếu đã nhận đủ packet

                reconstructVideo();
                renderVideo();
            }
        }
    }

    private void reconstructVideo() {
        // Lắp ráp video từ các packet
    }
}