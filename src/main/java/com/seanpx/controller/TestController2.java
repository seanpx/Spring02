package com.seanpx.controller;

import com.seanpx.config.WxConfig;
import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/test")
public class TestController2 {

    @Autowired
    private WxConfig wxConfig;

    @GetMapping("list")
    public JsonData testExt(){

        int i = 1/0;

        return JsonData.buildSuccess("");
    }

    @GetMapping("get_wxpay_config2")
    public JsonData testConfig() {
        try {
            if (Objects.equals(wxConfig.getAppid(), "1234567890")) {
                throw new IllegalArgumentException("App ID cannot be null");
            }
        Map<String, String> map = new LinkedHashMap<>();
        map.put("appid", wxConfig.getAppid());
        map.put("secret", wxConfig.getSecret());
        map.put("merchantid", wxConfig.getMerchantid());

        return JsonData.buildSuccess(map);
        } catch (IllegalArgumentException exception){
            // Handle a specific illegal argument exception
            return JsonData.buildErrorWithCustomMessage("Invalid argument: " + exception.getMessage(), -2);
        }

    }

}
