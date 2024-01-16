package com.seanpx.service.impl;

import com.seanpx.domain.Video;
import com.seanpx.mapper.VideoMapper;
import com.seanpx.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {

        return videoMapper.listVideo();
    }
}
