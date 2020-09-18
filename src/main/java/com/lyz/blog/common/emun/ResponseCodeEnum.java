package com.lyz.blog.common.emun;


/**
 * @author intellif
 */

public enum ResponseCodeEnum {

    OK(200, "SUCCESS", "成功"),

    ERROR(500, "SERVER_ERROR", "系统错误"),
    POWER_ERROR(5002, "POWER_ERROR", "无访问权限!"),
    CHECK_PARAM_ERROR(5010, "CHECK_PARAM_ERROR", "校验参数异常"),
    CHECK_ID_ERROR(6000, "CHECK_ID_ERROR", "ID不允许为空！"),

    NO_LOGIN_ERROR(-100, "NO_LOGIN_ERROR", "The current user is not logged in, please log in !"),

    TOKEN_ERROR(-200, "TOKEN_ERROR", "token 错误"),
    CONTACTS_ERROR(6001, "CONTACTS_ERROR", "对不起您不能操作他人公开的联系人！");


    private final Integer mapping;

    private final String message;

    private final String meaning;

    public Integer getMapping() {
        return this.mapping;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMeaning() {
        return meaning;
    }

    private ResponseCodeEnum(Integer mapping, String message, String meaning) {
        this.mapping = mapping;
        this.message = message;
        this.meaning = meaning;
    }
}
