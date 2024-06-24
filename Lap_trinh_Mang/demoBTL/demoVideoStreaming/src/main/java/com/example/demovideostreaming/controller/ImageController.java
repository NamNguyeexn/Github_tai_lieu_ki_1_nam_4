package com.example.demovideostreaming.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    @GetMapping("/image-socket")
    public ResponseEntity<byte[]> getImage() throws IOException {
        // Đọc file ảnh từ server
        ClassPathResource imageFile = new ClassPathResource("D:\\Tai_lieu_ki_1_nam_4\\Lap_trinh_Mang\\demoBTL\\demoVideoStreaming\\Pkg\\Data\\images");

        // Đọc dữ liệu ảnh thành mảng byte
        byte[] imageData = imageFile.getInputStream().readAllBytes();

        // Tạo response header để định dạng file ảnh
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        // Trả về file ảnh dưới dạng ResponseEntity
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }
}