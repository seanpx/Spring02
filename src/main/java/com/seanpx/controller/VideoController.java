package com.seanpx.controller;

import com.seanpx.domain.Video;
import com.seanpx.service.VideoService;
import com.seanpx.service.impl.VideoServiceImpl;
import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    // @RequestMapping("list")
    // @RequestMapping(value = "list",method = RequestMethod.GET)

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public Object list(){
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("key-1","video card 1");
//        map.put("key-2","video card 2");
//        map.put("key-3","video card 3");

//        return map;

        List<Video> list = videoService.listVideo();

//        return list;

        return JsonData.buildSuccess(list);
    }
}
