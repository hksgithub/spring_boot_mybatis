package com.hks.spring_boot_mybatis.config;

import com.hks.spring_boot_mybatis.controller.Interceptor.OneInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 15:21
 * @Description: 重写WebMvcConfigurationSupport里的addInterceptors方法,进行拦截
 */
//WebMvcConfigurerAdapter spring5.0已废弃
//1.解决 extends WebMvcConfigurationSupport
//2. implements WebMvcConfigurer
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    //重写WebMvcConfigurationSupport里的方法
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
    }
}
