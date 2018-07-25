package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.DemoItem;
import com.hks.spring_boot_mybatis.entity.TTest;
import com.hks.spring_boot_mybatis.service.DemoItemService;
import com.hks.spring_boot_mybatis.service.TTestService;
import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private DemoItemService demoItemService;

    @Autowired
    private Sid sid;

    /**
     * 添加数据
     * @return
     */
    @RequestMapping(value="/saveTest")
    public JsonResult saveTest(){
        TTest test = new TTest();
        test.setName("test1");
        int a = 1/0;
        tTestService.saveTest(test);
        return JsonResult.ok("保存成功");
    }

    @RequestMapping("saveDemoItem")
    public JsonResult saveDemoItem(){
        DemoItem demoItem = new DemoItem();
        demoItem.setId(sid.nextShort());
        demoItem.setName("demo");
        demoItem.setAmount(12);
        demoItemService.saveDemoItem(demoItem);
        return JsonResult.ok("demo_item表添加成功");
    }

    @RequestMapping("updateDemoItem")
    public JsonResult updateDemoItem(){
        DemoItem demoItem = new DemoItem();
        demoItem.setId("180724BP0ZD33PSW");
        demoItem.setName("birthday");
        demoItem.setAmount(18);
        demoItemService.updateDemoItem(demoItem);
        return JsonResult.ok("修改成功");
    }

    @RequestMapping("deleteDemoItem")
    public JsonResult deleteDemoItem(){
        demoItemService.deleteDemoItem("180724BYSYMDPTF8");
        return JsonResult.ok("删除成功");
    }

    @RequestMapping("queryDemoItemList")
    public JsonResult queryDemoItemList(@RequestParam("name") String name){
        DemoItem demoItem = new DemoItem();
        demoItem.setName(name);
        return JsonResult.ok(demoItemService.queryDemoItemList(demoItem));
    }

    //分页查询
    @RequestMapping("queryDemoItemListPaged")
    public JsonResult queryDemoItemListPaged(@RequestParam("name") String name,@RequestParam("page")
            Integer page,@RequestParam("pageSize") Integer pageSize){
        DemoItem demoItem = new DemoItem();
        demoItem.setName(name);
        return JsonResult.ok(demoItemService.queryDemoItemListPaged(demoItem,page,pageSize));
    }

    //自定义原生SQL查询
    @RequestMapping("queryDemoItemByIdCustom")
    public JsonResult queryDemoItemByIdCustom(@RequestParam("name") String name){
        return JsonResult.ok(demoItemService.queryDemoItemByNameCustom(name));
    }

}
