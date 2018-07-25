package com.hks.spring_boot_mybatis.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 12:07
 * @Description: 异步调用任务
 */
@Component
public class AsyncTask {

    //Future<V>,其中V代表了Future执行的任务返回值的类型
    @Async
    public Future<Boolean> doTask11() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("任务11耗时："+(end-start)+"毫秒");
        //返回true,告诉此任务已完成
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask22() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("任务22耗时："+(end-start)+"耗时");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask33() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(4000);
        long end = System.currentTimeMillis();
        System.out.println("任务33耗时："+(end-start)+"耗时");
        return new AsyncResult<>(true);
    }

}
