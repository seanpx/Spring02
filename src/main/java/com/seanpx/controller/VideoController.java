package com.seanpx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @RequestMapping("list")
    public Object list(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("key-1","video card 1");

        map.put("key-2","video card 2");

        map.put("key-3","video card 3");

        return map;
    }
}
