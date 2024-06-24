package com.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class VideoController {

    @MessageMapping("/video/stream")
    public void streamVideo(VideoRequest request) {

        videoService.streamVideo(request.getVideo(), request.getIp(), request.getPort());

        // Gọi receivePackets để nhận dữ liệu
        videoService.receivePackets(request.getIp(), request.getPort());
    }

    @MessageMapping("/video/render")
    public void renderVideoFrame(Session session) {

        // Lấy khung hình mới nhất để render
        VideoFrame frame = videoService.getCurrentFrame();

        // Gửi khung hình qua websocket đến client
        session.send(frame);
    }

}