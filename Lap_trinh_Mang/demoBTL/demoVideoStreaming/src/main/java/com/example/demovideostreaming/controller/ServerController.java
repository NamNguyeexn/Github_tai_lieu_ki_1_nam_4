package com.example.demovideostreaming.controller;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController

public class ServerController {
    private final File imageFile;
    OpenCVFrameConverter converter;

    public ServerController() {
        imageFile = new File("/path/to/image.jpg");
    }

//    @Scheduled(fixedRate = 1000)
//    public void captureFrame() throws IOException {
//
//        // Capture frame from webcam
//        BufferedImage image = grabFrame();
//
//        // Save to file
//        ImageIO.write(image, "jpg", imageFile);
//
//    }

    @GetMapping("/video")
    public byte[] getVideo() throws IOException {

        return Files.readAllBytes(imageFile.toPath());

    }

//    private BufferedImage grabFrame() {
//
//        OpenCVFrameConverter converter = new OpenCVFrameConverter.ToOrgOpenCvCoreMat();
//
//
//
//    }

}
