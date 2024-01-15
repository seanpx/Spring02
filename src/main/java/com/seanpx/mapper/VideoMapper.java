package com.seanpx.mapper;

import com.seanpx.domain.Video;

import java.util.HashMap;
import java.util.Map;

public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1, new Video(1,"Video#01"));
        videoMap.put(2, new Video(2,"Video#02"));

    }
}
