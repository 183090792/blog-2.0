package com.lyz.blog.common.config.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lyz.blog.common.constant.GlobalConstant;
import com.lyz.blog.common.emun.ResponseCodeEnum;
import com.lyz.blog.common.utils.JwtTokenUtil;
import com.lyz.blog.common.utils.ResponseModel;
import com.lyz.blog.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 功能描述: 登入拦截器
 * @Param:
 * @Return:
 * @Author: zhouchaobiao
 * @Date: 2019/11/1 10:10
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;

    private static final String HTTP_METHOD="GET";
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**目标方法执行之前*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //文件类型直接放行
        String contentType = request.getHeader("Content-Type");
        if(contentType != null ){
            if(request.getHeader("Content-Type").contains("multipart")){
                return true;
            }
        }

//        String token = request.getHeader(GlobalConstant.TOKEN);

//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        boolean flag = TokenTools.loginStatus(request);
//
//        if (flag) {
//            //判断token是否一致
//            if(!TokenTools.compareToken(redisTemplate,token,request)){
//                //token错误
//                ResponseModel responseModel = ResponseUtils.fail(ResponseCodeEnum.TOKEN_ERROR);
//                String jsonObjectStr = JSONObject.toJSONString(responseModel);
//                returnJson(response,jsonObjectStr);
//                return false;
//            }
//            return true;
//        }else {
//            //未登录,返回失败信息
//            ResponseModel responseModel = ResponseUtils.fail(ResponseCodeEnum.NO_LOGIN_ERROR);
//            String jsonObjectStr = JSONObject.toJSONString(responseModel);
//            returnJson(response,jsonObjectStr);
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     *  返回json数据
     * @param response
     * @param json
     * @throws Exception
     */
    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }





}
