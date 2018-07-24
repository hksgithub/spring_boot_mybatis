package com.hks.spring_boot_mybatis.exception;

import com.hks.spring_boot_mybatis.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 21:48
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR_VIEW = "error";

    final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     *  错误处理
     * @param request 请求
     * @param response 响应
     * @param e 异常
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();
        if(isAjax(request)){
            log.error("日志记录发生错误,errorAjaxMessage: {}",e.getMessage());
            return JsonResult.errorException(e.getMessage());
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            log.error("日志记录发生错误,errorWebMessage: {}",e.getMessage());
            log.error("日志记录发生错误,errorWebUrl: {}",request.getRequestURL());
            return mav;
        }
    }

    /**
     * 是否ajax请求
     * @param httpRequest
     * @return
     */
    public static Boolean isAjax(HttpServletRequest httpRequest){
        return (httpRequest.getHeader("X-Requested-With") != null
        && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
