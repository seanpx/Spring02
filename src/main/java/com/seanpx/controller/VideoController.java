package com.seanpx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public JsonData list() throws JsonProcessingException {
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("key-1","video card 1");
//        map.put("key-2","video card 2");
//        map.put("key-3","video card 3");

//        return map;
        System.out.println("##VideoController.list -start: " );
        List<Video> list = videoService.listVideo();


        System.out.println("##VideoController.list - Create objectMapper to host videoService list as jsonStr in String form: " );
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("##VideoController.list - objectMapper - writeValueAsString: " );
        String jsonStr = objectMapper.writeValueAsString(list);

        System.out.println("##VideoController.list - print jsonStr: " );
        System.out.println(jsonStr);

        // Now let's deserialize the JSON string back to List<Video>
        // This is suggested by ChatGPT as the correct way to Deserialize the Video Json
        System.out.println("##VideoController.list - Deserialize the JSON string back to List<Video>: ");
        List<Video> deserializedList = objectMapper.readValue(jsonStr, new TypeReference<List<Video>>() {});

        System.out.println("Deserialized List: ");
        for (Video video : deserializedList) {
            System.out.println(video);
        }

        System.out.println("Print deserializedList Directly: ");
        System.out.println(deserializedList);

        //Deserialization from XiaoDi Class
        // - according to ChatGPT, it is not the correct way to Deserialize the Json
        System.out.println("Deserialized List - XiaoDi Class : ");
        List<Video> temp = objectMapper.readValue(jsonStr,List.class);
        System.out.println(temp);

        System.out.println("##VideoController.list -end:" );

        System.out.println("##VideoController.list -end ####22222:" );
//        return list
        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideo(@RequestBody Video video){

        System.out.println("##VideoController: " + video.toString() );

        //return JsonData.buildSuccess("Video Saved Successfully");
        return JsonData.buildSuccess(video);
    }
}
