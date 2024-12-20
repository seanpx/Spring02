package com.seanpx.controller;

import com.seanpx.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/prv/order")
public class VideoOrderController {

    @RequestMapping("place")
    public JsonData saveOrder(){
        return JsonData.buildSuccess("Order Placed Successfully");
    }
}
