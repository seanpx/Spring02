package com.seanpx.controller;

import com.seanpx.config.WxConfig;
import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/test")
public class TestController2 {

    @Autowired
    private WxConfig wxConfig;

    @GetMapping("get_wxpay_config2")
    public JsonData testConfig() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("appid", wxConfig.getAppid());
        map.put("secret", wxConfig.getSecret());
        //map.put("merchantid", wxConfig.getMerchantid());

        return JsonData.buildSuccess(map);
    }

}
