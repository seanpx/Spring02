package com.seanpx.controller;

import com.seanpx.task.AsyncTask;
import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("async")
    public JsonData testAsync(){
        long begin = System.currentTimeMillis();
        System.out.println(LocalDateTime.now() + " test/async Start");

        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();

        Future<String>  taskA1 = asyncTask.taskA1();
        Future<String>  taskA2 = asyncTask.taskA2();

        for(;;){
            if(taskA1.isDone() && taskA2.isDone()){
                try {
                    String taskA1Result = taskA1.get();
                    System.out.println("testAsync - taskA1Result " + taskA1Result);

                    String taskA2Result = taskA2.get();
                    System.out.println("testAsync - taskA2Result " + taskA2Result);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } finally {
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(LocalDateTime.now() + " test/async End");

        return JsonData.buildSuccess(end - begin);
    }

}
