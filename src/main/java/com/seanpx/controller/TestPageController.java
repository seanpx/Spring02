package com.seanpx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/testpages")
@PropertySource({"classpath:pay/pay.properties"})
public class TestPageController {

    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.merchantid}")
    private String merchantid;

    @GetMapping("config")
    public Map<String, String> getWxPayConfig() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("appid", payAppid);
        response.put("merchantid", merchantid);
        return response;
    }
}
