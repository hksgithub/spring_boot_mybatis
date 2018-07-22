package com.hks.spring_boot_mybatis.exception;

import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 21:39
 * @Description: ajax异常处理
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {

    //@ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest req
            ,Exception e) throws Exception{
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
