package com.hks.spring_boot_mybatis.service;

import com.hks.spring_boot_mybatis.entity.DemoItem;

/**
 * @Author: xiaohe
 * @Date: 2018/7/24 15:23
 * @Description:
 */
public interface DemoItemService {

    public void saveDemoItem(DemoItem demoItem);

    public void updateDemoItem(DemoItem demoItem);

    public void deleteDemoItem(String id);
}
