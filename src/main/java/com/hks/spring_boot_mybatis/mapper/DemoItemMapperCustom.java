package com.hks.spring_boot_mybatis.mapper;

import com.hks.spring_boot_mybatis.entity.DemoItem;

import java.util.List;

public interface DemoItemMapperCustom {
    List<DemoItem> queryDemoItemSimplyInfoById(String id);
    List<DemoItem> queryDemoItemSimplyInfoByName(String name);
}