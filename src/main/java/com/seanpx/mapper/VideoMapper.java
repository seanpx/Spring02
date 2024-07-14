package com.seanpx.mapper;

import com.seanpx.domain.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VideoMapper {
    static {
        System.out.println("##VideoMapper.Static: " + "Starting of VideoMapper");
    }
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

        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());

        // Print the list of videos
        System.out.println("##VideoMapper.Static: list of videos");
        for (Video video : list) {
            System.out.println(video);
        }


        /***
        // Create a map to hold categories, each category holds a videoMap
        Map<String, Map<Integer, Video>> categoryMap = new LinkedHashMap<>();
        categoryMap.put("Category1", videoMap);

        // Now we can access videos through categoryMap
        Map<Integer, Video> retrievedVideoMap = categoryMap.get("Category1");
        Video video = retrievedVideoMap.get(1);

        // Print the details of the retrieved video
        System.out.println(video);
         ***/

    }

    @PostConstruct
    public void init() {
        // This will be executed after the bean is fully initialized
        System.out.println("##VideoMapper.init : bean has been initialized");
    }

    public List<Video> listVideo(){

        System.out.println("##VideoMapper.listVideo :  listVideo is called");
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());

        return list;
    }
}
