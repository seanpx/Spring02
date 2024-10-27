package com.seanpx.Spring02;

import com.seanpx.Main;
import com.seanpx.domain.Video;
import com.seanpx.service.VideoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@SpringBootTest(classes = {Main.class})
@AutoConfigureMockMvc
public class XdVideoTest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListAPI() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();

        System.out.println("PXXX : " + status);

        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));

        System.out.println("PXXX : " + result);

    }

    @BeforeEach
    public void testBefore1() {
        System.out.println("##XdVideoTest - testBefore1()");
    }

    @BeforeEach
    public void testBefore2() {
        System.out.println("##XdVideoTest - testBefore2()");
    }

    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();

        Assertions.assertTrue(videoList.size()>0);
    }


    @Test
    public void testing1() {
        System.out.println("##XdVideoTest - testing1()");
        Assertions.assertEquals(1,1);
    }

    @Test
    public void testing2() {
        System.out.println("##XdVideoTest - testing2()");
    }


    @AfterEach
    public void testAfter() {
        System.out.println("##XdVideoTest - testAfter()");
    }


}
