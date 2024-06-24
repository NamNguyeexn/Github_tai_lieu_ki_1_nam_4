package com.demo.services.impl;

import com.demo.exception.VideoAlreadyExistsException;
import com.demo.models.Video;
import com.demo.repository.VideoRepo;
import com.demo.services.VideoService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class VideoServiceImpl implements VideoService {
    private VideoRepo repo;

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            System.out.println("---------------------- Check Log : " + repo.existsByName(name));
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }
}
