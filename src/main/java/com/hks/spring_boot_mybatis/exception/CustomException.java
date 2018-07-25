package com.hks.spring_boot_mybatis.exception;

import com.hks.spring_boot_mybatis.enums.ResultEnum;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 17:57
 * @Description: 自定义异常类
 */
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(ResultEnum resultEnum){
        //重写父类的异常消息
        super(resultEnum.getMsg());
        //添加自定义的属性
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
