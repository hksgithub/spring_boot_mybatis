package com.hks.spring_boot_mybatis.entity;

import java.util.Date;

/**
 * @Author: xiaohe
 * @Date: 2018/7/22 17:51
 * @Description:
 */
public class User {

    private String name;

    private String password;

    private Integer age;

    private Date birthday;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
