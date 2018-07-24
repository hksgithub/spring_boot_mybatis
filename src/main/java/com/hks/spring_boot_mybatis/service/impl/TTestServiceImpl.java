package com.hks.spring_boot_mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.hks.spring_boot_mybatis.entity.TTest;
import com.hks.spring_boot_mybatis.mapper.TTestMapper;
import com.hks.spring_boot_mybatis.service.TTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: xiaohe
 * @Date: 2018/7/23 22:16
 * @Description:
 */
@Service
public class TTestServiceImpl implements TTestService{

    @Autowired
    private TTestMapper tTestMapper;

    //增加
    public void saveTest(TTest test){
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        tTestMapper.insert(test);
    }

    //修改
    public void updateTest(TTest test){
        tTestMapper.updateByPrimaryKeySelective(test);
    }

    //删除
    public void deleteTest(Integer testid){
        tTestMapper.deleteByPrimaryKey(testid);
    }

    //主键查询
    public TTest queryTestById(Integer testid){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return tTestMapper.selectByPrimaryKey(testid);
    }

    //查询多条
    public List<TTest> queryTestList(TTest test){
        Example example = new Example(TTest.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(test.getName())){
            //模糊查询
            criteria.andLike("name","%"+test.getName()+"%");
        }
        List<TTest> testList = tTestMapper.selectByExample(example);
        return testList;
    }

    //分页查询
    public List<TTest> queryTestListPaged(TTest test,Integer page,Integer pageSize){
        //开始分页
        PageHelper.startPage(page,pageSize);
        Example example = new Example(TTest.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(test.getName())){
            criteria.andLike("name","%"+test.getName()+"%");
        }
        List<TTest> testList = tTestMapper.selectByExample(example);
        return testList;
    }

    //原生SQL查询
    public TTest queryTestByIdCustom(Integer testid){
        return null;
    }
}