package com.seanpx.controller;

import com.seanpx.domain.Video;
import com.seanpx.service.VideoService;
import com.seanpx.service.impl.VideoServiceImpl;
import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    // @RequestMapping("list")
    // @RequestMapping(value = "list",method = RequestMethod.GET)

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
//    public Object list(){
    public JsonData list(){
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("key-1","video card 1");
//        map.put("key-2","video card 2");
//        map.put("key-3","video card 3");

//        return map;

        List<Video> list = videoService.listVideo();

//        return list;

        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideo(@RequestBody Video video){

        System.out.println(video.toString());

        return JsonData.buildSuccess("Video Saved Successfully");
    }
}
