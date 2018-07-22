package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 22:14
 * @Description: 异常测试
 */
//@Controller
//@RequestMapping(value="/err")
public class ErrorController {

    @RequestMapping(value="error")
    public String error(){
        int a = 1/0;
        return "thymeleaf/error";
    }

    @RequestMapping(value="ajaxerror")
    public String ajaxerror(){
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping(value="getAjaxerror")
    @ResponseBody
    public JsonResult getAjaxerror(){
        int a = 1/0;
        return JsonResult.ok();
    }
}
