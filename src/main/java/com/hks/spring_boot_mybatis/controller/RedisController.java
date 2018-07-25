package com.hks.spring_boot_mybatis.controller;

import com.hks.spring_boot_mybatis.entity.DemoItem;
import com.hks.spring_boot_mybatis.utils.JsonResult;
import com.hks.spring_boot_mybatis.utils.JsonUtils;
import com.hks.spring_boot_mybatis.utils.RedisOperator;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 11:10
 * @Description: redis使用
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Sid sid;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("test")
    public JsonResult test() {
        //redis set字符串
        stringRedisTemplate.opsForValue().set("hello","website");

        DemoItem demoItem = new DemoItem();
        demoItem.setId(sid.nextShort());
        demoItem.setName("language");
        demoItem.setAmount(12);
        //redis set对象
        stringRedisTemplate.opsForValue().set("json:demoItem", JsonUtils.objectToJson(demoItem));
        //redis 获取
        DemoItem jsonDemoItem = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:demoItem"),DemoItem.class);
        return JsonResult.ok(jsonDemoItem);
    }

    //redis封装后的set/get操作
    @RequestMapping("getJsonList")
    public JsonResult getJsonList(){
        DemoItem demoItem = new DemoItem();
        demoItem.setId(sid.nextShort());
        demoItem.setName("website");
        demoItem.setAmount(11);

        DemoItem demoItem1 = new DemoItem();
        demoItem1.setId(sid.nextShort());
        demoItem1.setName("Transactional");
        demoItem1.setAmount(22);

        DemoItem demoItem2 = new DemoItem();
        demoItem2.setId(sid.nextShort());
        demoItem2.setName("propagation");
        demoItem2.setAmount(33);

        List<DemoItem> demoItemList = new ArrayList<>();
        demoItemList.add(demoItem);
        demoItemList.add(demoItem1);
        demoItemList.add(demoItem2);

        redis.set("json:info:demoItemList",JsonUtils.objectToJson(demoItemList),1000);

        String demoItemListJson = redis.get("json:info:demoItemList");
        List<DemoItem> demoItemList1 = JsonUtils.jsonToList(demoItemListJson,DemoItem.class);

        return JsonResult.ok(demoItemList1);
    }

}
