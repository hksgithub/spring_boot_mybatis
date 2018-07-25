package com.hks.spring_boot_mybatis.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 11:55
 * @Description: 测试定时器
 */
//@Component
public class testTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //定义执行秒数
    //@Scheduled(fixedRate = 2000)
    //@Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime(){
        System.out.println("现在时间是："+dateFormat.format(new Date()));
    }
}
