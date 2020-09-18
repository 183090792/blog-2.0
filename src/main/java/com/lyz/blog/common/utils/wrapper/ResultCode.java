package com.lyz.blog.common.utils.wrapper;



/**
 *
 * @author why
 * @date 2018/3/29 0029
 */
public enum   ResultCode {
    SUCCESS("8888","操作成功"),
    NODATA("8001","查询成功无记录"),
    PARAMS_ERROR("6001", "参数为空或格式错误");

    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
