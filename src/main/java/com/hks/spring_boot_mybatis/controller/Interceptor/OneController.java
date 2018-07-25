package com.hks.spring_boot_mybatis.controller.Interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 14:07
 * @Description: 拦截器测试类
 */
@Controller
@RequestMapping("one")
public class OneController {

    @RequestMapping("index")
    public String index(ModelMap map){
        map.addAttribute("Interceptor","interceptor");
        return "thymeleaf/index";
    }

}
