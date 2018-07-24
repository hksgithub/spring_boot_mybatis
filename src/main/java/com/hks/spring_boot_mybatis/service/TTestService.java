package com.hks.spring_boot_mybatis.service;

import com.hks.spring_boot_mybatis.entity.TTest;

import java.util.List;

/**
 * @Author: xiaohe
 * @Date: 2018/7/23 22:07
 * @Description:
 */
public interface TTestService {

    public void saveTest(TTest test);

    public void updateTest(TTest test);

    public void deleteTest(Integer testid);

    public TTest queryTestById(Integer testid);

    public List<TTest> queryTestList(TTest test);

    public List<TTest> queryTestListPaged(TTest test,Integer page,Integer pageSize);

    public TTest queryTestByIdCustom(Integer testid);


}
