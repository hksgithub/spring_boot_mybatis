package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.TTest;
import com.hks.spring_boot_mybatis.service.TTestService;
import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaohe
 * @Date: 2018/7/23 22:02
 * @Description: mybatis实现增删改查
 */
@RestController
@RequestMapping(value="/mybatis")
public class MyBatisCRUDController {

    @Autowired
    private TTestService tTestService;

    /**
     * 添加数据
     * @return
     */
    @RequestMapping(value="/saveTest")
    public JsonResult saveTest(){
        TTest test = new TTest();
        test.setId(1);
        test.setName("test1");
        tTestService.saveTest(test);
        return JsonResult.ok("保存成功");
    }
}
