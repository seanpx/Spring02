package com.seanpx.controller;

import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/test")
@PropertySource({"classpath:pay/pay.properties"})
public class TestController {

    @Value("${wxpay.appid}")
    private String payAppid;
    @Value("${wxpay.secret}")
    private String paySecret;
    @Value("${wxpay.merchantid}")
    private String merchantID;

    @GetMapping("get_wxpay_config")
    public JsonData testConfig(){

        Map<String,String> map = new LinkedHashMap<>();
        map.put("appid",payAppid);
        map.put("secret",paySecret);
        map.put("merchant_id",merchantID);

        return JsonData.buildSuccess(map);

    }

}
