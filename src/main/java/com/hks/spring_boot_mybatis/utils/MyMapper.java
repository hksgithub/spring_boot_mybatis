package com.hks.spring_boot_mybatis.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: xiaohe
 * @Date: 2018/7/23 17:42
 * @Description: 继承自己的MyMapper
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
    //该接口不能被扫描到，否则会报错
}
