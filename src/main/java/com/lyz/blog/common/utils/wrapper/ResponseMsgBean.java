package com.lyz.blog.common.utils.wrapper;

import com.google.gson.Gson;
import lombok.NonNull;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author why
 * @date 2017/7/24 0024
 */
public class ResponseMsgBean {

    private static final String RESULT = "result";
    private static Gson gson = new Gson();

    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误信息
     */
    private String resultMsg;

    /**
     * 业务数据
     */
    private Object body;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public static void main(String[] args) {

//         System.out.println(ResponseMsgBean.getMsgJson(ResultConstants.RESULT_CODE_7001, ResultConstants.RESULT_MSG_7001));
    }

    public ResponseMsgBean(String resultCode, String resultMsg, Object body) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        if (StringUtils.isEmpty(body)) {
            this.body = new Object();
        } else {
            this.body = body;
        }
    }

    public ResponseMsgBean(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.body = new Object();
    }

    /**
     * 自定义信息code、信息msg、业务数据
     *
     * @param resultCode 消息代码
     * @param resultMsg  消息内容
     * @param body       业务数据(可选项，为空null)
     * @return
     */
    public static String getMsgJson(@NonNull String resultCode, @NonNull String resultMsg, Object body) {
        ResponseMsgBean msgBean = new ResponseMsgBean(resultCode, resultMsg, body);
        Map map = new HashMap(1);
        map.put(RESULT, msgBean);
        return gson.toJson(map);
    }


    /**
     * 自定义信息code、信息msg
     * @param resultCode 消息代码
     * @param resultMsg  消息内容
     * @return
     */
    public static String getMsgJson(@NonNull String resultCode, @NonNull String resultMsg) {
        ResponseMsgBean msgBean = new ResponseMsgBean(resultCode, resultMsg);
        Map map = new HashMap(1);
        map.put(RESULT, msgBean);
        return gson.toJson(map);
    }

    /**
     * 请求参数或格式错误
     *
     * @return
     */
    public static String getMsgJsonParamError() {
        ResponseMsgBean msgBean = new ResponseMsgBean(ResultCode.PARAMS_ERROR.getCode(), ResultCode.PARAMS_ERROR.getMsg());
        Map map = new HashMap(1);
        map.put(RESULT, msgBean);
        return gson.toJson(map);
    }

    /**
     * 操作成功返回业务数据
     *
     * @param body 业务数据
     * @return
     */
    public static String getMsgJsonWithData(@NonNull Object body) {
        ResponseMsgBean msgBean = new ResponseMsgBean(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), body);
        Map map = new HashMap(1);
        map.put(RESULT, msgBean);
        return gson.toJson(map);
    }

    /**
     * 操作成功未返回业务数据
     *
     * @return
     */
    public static String getMsgJsonWithoutData() {
        ResponseMsgBean msgBean = new ResponseMsgBean(ResultCode.NODATA.getCode(), ResultCode.NODATA.getMsg());
        Map map = new HashMap(1);
        map.put(RESULT, msgBean);
        return gson.toJson(map);
    }

}
