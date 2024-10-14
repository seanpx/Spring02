package com.seanpx.Spring02;

import com.seanpx.Main;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Main.class})
public class XdVideoTest {

    @BeforeEach
    public void testBefore1() {
        System.out.println("##XdVideoTest - testBefore1()");
    }

    @BeforeEach
    public void testBefore2() {
        System.out.println("##XdVideoTest - testBefore2()");
    }


    @Test
    public void testing1() {
        System.out.println("##XdVideoTest - testing1()");
        Assertions.assertEquals(1,3);
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
