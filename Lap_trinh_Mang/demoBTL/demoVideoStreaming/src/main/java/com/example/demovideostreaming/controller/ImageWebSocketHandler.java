package com.example.demovideostreaming.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class ImageWebSocketHandler extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Khi một kết nối WebSocket được thiết lập, thêm session vào danh sách sessions
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Khi một kết nối WebSocket đóng, xóa session khỏi danh sách sessions
        sessions.remove(session);
    }

    // Phương thức này sẽ được gọi khi server có ảnh mới để gửi đi
    public void sendImage(byte[] imageData) throws IOException {
        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                session.sendMessage(new BinaryMessage(imageData));
            }
        }
    }
}
