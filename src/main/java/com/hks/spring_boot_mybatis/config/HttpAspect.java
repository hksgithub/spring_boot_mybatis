package com.hks.spring_boot_mybatis.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 17:15
 * @Description: aspect 测试
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.hks.spring_boot_mybatis.controller.MyBatisCRUDController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        //保存了请求的参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        //URL
        logger.info("url={}",request.getRequestURL());

        //method 请求类型 如：GET POST
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法 getDeclaringTypeName() 类名  getName() 方法名
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数 URL?后的参数
        logger.info("args={}",joinPoint.getArgs());

    }

    /**
     * 执行方法后执行
     */
    @After("log()")
    public void doAfter(){
        logger.info("执行方法后执行");
    }

    /**
     * 处理完返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
