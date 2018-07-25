package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.DemoItem;
import com.hks.spring_boot_mybatis.service.DemoItemService;
import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 16:03
 * @Description: 表单验证
 */
@RestController
@RequestMapping("validform")
public class ValidformController {

    @Autowired
    private DemoItemService demoItemService;

    @Autowired
    private Sid sid;

    /**
     * @Valid 校验注解
     * @param amount
     * @param demoItem
     * @param bindingResult 校验后的信息
     * @return
     */
    @RequestMapping("addDemoItem")
    public JsonResult addDemoItem(@RequestParam("amount") Integer amount,
                                  @Valid DemoItem demoItem , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return JsonResult.errorMsg("数据不对，"+bindingResult.getFieldError().getDefaultMessage());
        }

        demoItem.setId(sid.nextShort());
        demoItem.setName("amount");
        demoItem.setAmount(amount);
        demoItemService.saveDemoItem(demoItem);
        return JsonResult.ok("数据正确，保存成功");
    }
}
