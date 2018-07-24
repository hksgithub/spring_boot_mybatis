package com.hks.spring_boot_mybatis.service.impl;

import com.hks.spring_boot_mybatis.entity.DemoItem;
import com.hks.spring_boot_mybatis.mapper.DemoItemMapper;
import com.hks.spring_boot_mybatis.service.DemoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiaohe
 * @Date: 2018/7/24 15:24
 * @Description:
 */
@Service
public class DemoItemServiceImpl implements DemoItemService {

    @Autowired
    DemoItemMapper demoItemMapper;

    //添加
    public void saveDemoItem(DemoItem demoItem){
        demoItemMapper.insert(demoItem);
    }

    public void updateDemoItem(DemoItem demoItem){
        demoItemMapper.updateByPrimaryKeySelective(demoItem);
    }

    public void deleteDemoItem(String id){
        demoItemMapper.deleteByPrimaryKey(id);
    }
}
