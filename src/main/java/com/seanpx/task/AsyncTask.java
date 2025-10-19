package com.seanpx.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Component
@Async
public class AsyncTask {

    public void task1(){
        try{
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " task 1");
    }

    public void task2(){
        try{
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " task 2");
    }

    public void task3(){
        try{
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " task 3");
    }

    public CompletableFuture<String> taskA1(){
        System.out.println(LocalDateTime.now() + " task A1 Start");
        try{
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " task A1 Done");
        return CompletableFuture.completedFuture("###Task A1 Returned");
    }

    public CompletableFuture<String> taskA2(){
        System.out.println(LocalDateTime.now() + " task A2 Start");
        try{
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now() + " task A2 Done");
        return CompletableFuture.completedFuture("###Task A2 Returned");
    }

}
