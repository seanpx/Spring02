package com.seanpx.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/testpages")
@PropertySource(value = "classpath:pay/pay.properties", encoding = "UTF-8")
public class TestPageController {

    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.merchantid}")
    private String merchantid;

    @GetMapping("config")
    public Map<String, String> getWxPayConfig(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        Map<String, String> config = new LinkedHashMap<>();
        config.put("appid", payAppid);
        config.put("merchantid", merchantid);
        return config;
    }
}
