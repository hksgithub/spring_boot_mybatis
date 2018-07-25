package com.hks.spring_boot_mybatis.service;

import com.hks.spring_boot_mybatis.entity.DemoItem;

import java.util.List;

/**
 * @Author: xiaohe
 * @Date: 2018/7/24 15:23
 * @Description:
 */
public interface DemoItemService {

    public void saveDemoItem(DemoItem demoItem);

    public void updateDemoItem(DemoItem demoItem);

    public void deleteDemoItem(String id);

    public DemoItem queryDemoItemById(String id);

    public List<DemoItem> queryDemoItemList(DemoItem demoItem);

    public List<DemoItem> queryDemoItemListPaged(DemoItem demoItem,Integer page,Integer pageSize);

    public DemoItem queryDemoItemByIdCustom(String id);

    public DemoItem queryDemoItemByNameCustom(String name);

}
