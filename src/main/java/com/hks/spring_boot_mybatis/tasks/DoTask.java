package com.hks.spring_boot_mybatis.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 12:29
 * @Description: 执行异步任务
 */
@RestController
@RequestMapping("doTask")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("asyncTask")
    public String asyncTask() throws Exception{

        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        //isDone为true代表任务执行完了
        while(!a.isDone() || !b.isDone() || !c.isDone()){
            if(a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时："+(end-start)+"毫秒";
        System.out.println(times);
        return times;
    }
}
