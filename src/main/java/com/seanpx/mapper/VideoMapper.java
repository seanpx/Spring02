package com.seanpx.mapper;

import com.seanpx.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new LinkedHashMap<>();

    static {
        videoMap.put(1, new Video(1,"Video#01"));
        videoMap.put(2, new Video(2,"Video#02"));
        videoMap.put(3, new Video(3,"Video#03"));
        videoMap.put(4, new Video(4,"Video#04"));
        videoMap.put(5, new Video(5,"Video#05"));
    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());

        return list;
    }
}
