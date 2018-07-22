package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 17:43
 * @Description: thymeleaf 模板测试
 */
//@Controller
//@RequestMapping(value="th")
public class ThymeleafController {

    @RequestMapping(value="index")
    public String index(ModelMap map){
        map.addAttribute("name","thymeleaf");
        return "thymeleaf/index";
    }

    @RequestMapping(value="center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping(value="/test")
    public String test(ModelMap map){
        User user = new User();
        user.setName("thymeleaf");
        user.setPassword("123456");
        user.setAge(23);
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>mybatis</b></font>");

        map.addAttribute("user",user);

        User u = new User();
        u.setName("thymeleaf1");
        u.setPassword("111111");
        u.setAge(24);
        u.setBirthday(new Date());
        u.setDesc("mybatis1");

        User u1 = new User();
        u1.setName("thymeleaf3");
        u1.setPassword("222222");
        u1.setAge(19);
        u1.setBirthday(new Date());
        u1.setDesc("mybatis2");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u);
        userList.add(u1);

        map.addAttribute("userList",userList);
        return "thymeleaf/test";
    }

    @RequestMapping(value="postform")
    public String postform(User u){
        System.out.println(u.getName());
        System.out.println(u.getAge());
        return "redirect:/th/test";
    }
}
