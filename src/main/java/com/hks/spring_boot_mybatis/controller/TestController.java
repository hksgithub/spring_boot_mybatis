package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.Resource;
import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 14:36
 * @Description:
 */
//@RestController
public class TestController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/test")
    public JsonResult testAction(@RequestParam("website") String website){
        return JsonResult.ok("hellos "+website);
    }

    //资源文件注入测试
    @RequestMapping(value="/getResource")
    public Object getResource(){
        Resource bean = new Resource();
        //copy对象
        BeanUtils.copyProperties(resource,bean);
        return bean;

    }
}
