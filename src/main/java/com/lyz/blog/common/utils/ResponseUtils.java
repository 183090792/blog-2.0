package com.lyz.blog.common.utils;


import com.alibaba.fastjson.JSON;
import com.lyz.blog.common.emun.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public final class ResponseUtils {
    //日志


    public static <T> ResponseModel<T> success() {
        return success(null);
    }

    public static <T> ResponseModel<T> success(T entity) {
        return ResponseModel.create(ResponseCodeEnum.OK, entity);
    }

    public static <T> ResponseModel<T> fail(ResponseCodeEnum code) {
        return fail(code, null);
    }

    public static <T> ResponseModel<T> fail(ResponseCodeEnum code, T entity) {
        return ResponseModel.create(code, entity);
    }

    public static <T> ResponseModel<T> error() {
        return error(null);
    }

    public static <T> ResponseModel<T> error(T entity) {
        return ResponseModel.create(ResponseCodeEnum.ERROR, entity);
    }

    private ResponseUtils() {
    }

    /**
     * 使用Response返回Json数据
     *
     * @param response
     * @param result
     */
    public static void responseOutWithJson(HttpServletResponse response, ResponseModel result) {
        //将实体对象转换为JSON Object转换
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSON.toJSONString(result));
        } catch (IOException e) {
            log.error("response json error ", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
