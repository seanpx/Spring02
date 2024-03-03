package com.seanpx.mapper;

import com.seanpx.domain.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new LinkedHashMap<>();

    static {
        System.out.println("##VideoMapper.Static: " + "initializer of VideoMapper");
        videoMap.put(1, new Video(1,"Video#01"));
        System.out.println("##VideoMapper.Static: " + "executed 1");
        videoMap.put(2, new Video(2,"Video#02"));
        System.out.println("##VideoMapper.Static: " + "executed 2");
        videoMap.put(3, new Video(3,"Video#03"));
        System.out.println("##VideoMapper.Static: " + "executed 3");
        videoMap.put(4, new Video(4,"Video#04"));
        System.out.println("##VideoMapper.Static: " + "executed 4");
        videoMap.put(5, new Video(5,"Video#05"));
        System.out.println("##VideoMapper.Static: " + "executed 5");
    }

    @PostConstruct
    public void init() {
        // This will be executed after the bean is fully initialized
        System.out.println("VideoMapper bean has been initialized");
    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());

        return list;
    }
}
