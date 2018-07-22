package com.hks.spring_boot_mybatis.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 15:00
 * @Description: 资源文件注入
 */
@Configuration
@ConfigurationProperties(prefix="com.hks.mybatis")
@PropertySource(value="classpath:resource.properties")
public class Resource {

    private String name;

    private String website;

    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
