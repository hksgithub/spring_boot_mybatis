package com.hks.spring_boot_mybatis.enums;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 17:59
 * @Description: 注意分号结尾
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功"),
    ERROR(500,"错误"),
    BEAN_ERROR(501,"bean验证错误"),
    TOKEN_ERROR(502,"拦截器拦截到用户token出错"),
    EXCEPTION_ERROR(555,"异常抛出信息"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
