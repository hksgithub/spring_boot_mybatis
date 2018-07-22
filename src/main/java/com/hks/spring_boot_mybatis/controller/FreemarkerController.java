package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 17:10
 * @Description: freemarker 模板测试
 */
//@Controller
@RequestMapping(value="/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping(value="index")
    public String index(ModelMap map){
        map.addAttribute("resource",resource);
        return "freemarker/index";
    }
}
