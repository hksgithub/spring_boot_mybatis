package com.hks.spring_boot_mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.hks.spring_boot_mybatis.entity.DemoItem;
import com.hks.spring_boot_mybatis.mapper.DemoItemMapper;
import com.hks.spring_boot_mybatis.mapper.DemoItemMapperCustom;
import com.hks.spring_boot_mybatis.service.DemoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: xiaohe
 * @Date: 2018/7/24 15:24
 * @Description:
 */
@Service
public class DemoItemServiceImpl implements DemoItemService {

    @Autowired
    DemoItemMapper demoItemMapper;

    @Autowired
    DemoItemMapperCustom demoItemMapperCustom;

    //添加
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveDemoItem(DemoItem demoItem){
        demoItemMapper.insert(demoItem);
    }

    //更新
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateDemoItem(DemoItem demoItem){
        demoItemMapper.updateByPrimaryKeySelective(demoItem);
    }

    //根据主键删除
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDemoItem(String id){
        demoItemMapper.deleteByPrimaryKey(id);
    }

    //根据主键查询
    @Transactional(propagation = Propagation.SUPPORTS)
    public DemoItem queryDemoItemById(String id){
        return demoItemMapper.selectByPrimaryKey(id);
    }

    //查询多条
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<DemoItem> queryDemoItemList(DemoItem demoItem){
        Example example = new Example(DemoItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(demoItem.getName())){
            criteria.andLike("name","%"+demoItem.getName()+"%");
        }
        List<DemoItem> demoItemList = demoItemMapper.selectByExample(example);
        return demoItemList;
    }

    //分页查询
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<DemoItem> queryDemoItemListPaged(DemoItem demoItem,Integer page,Integer pageSize){
        //开始分页
        PageHelper.startPage(page,pageSize);
        Example example = new Example(DemoItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(demoItem.getName())){
            criteria.andLike("name","%"+demoItem.getName()+"%");
        }
        List<DemoItem> demoItemList = demoItemMapper.selectByExample(example);
        return demoItemList;

    }

    //自定义原生SQL查询
    @Transactional(propagation = Propagation.SUPPORTS)
    public DemoItem queryDemoItemByIdCustom(String id){

        List<DemoItem> demoItemList = demoItemMapperCustom.queryDemoItemSimplyInfoById(id);

        if(demoItemList!=null && !demoItemList.isEmpty()){
            return (DemoItem) demoItemList.get(0);
        }
        return null;
    }

    //自定义原生SQL查询
    @Transactional(propagation = Propagation.SUPPORTS)
    public DemoItem queryDemoItemByNameCustom(String name){

        List<DemoItem> demoItemList = demoItemMapperCustom.queryDemoItemSimplyInfoByName(name);

        if(demoItemList!=null && !demoItemList.isEmpty()){
            return (DemoItem) demoItemList.get(0);
        }
        return null;
    }
}
