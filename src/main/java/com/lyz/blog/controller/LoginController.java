package com.lyz.blog.controller;

import com.alibaba.fastjson.JSON;
import com.lyz.blog.common.bean.entity.UserInfo;
import com.lyz.blog.common.constant.GlobalConstant;
import com.lyz.blog.common.utils.JwtTokenUtil;
import com.lyz.blog.common.utils.Md5Util;
import com.lyz.blog.common.utils.wrapper.ResponseMsgBean;
import com.lyz.blog.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * @author LYZ
 * @create 2019/5/15 21:24
 **/
@Slf4j
@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
    @Autowired
    private IUserInfoService loginService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 登录
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/login",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String login(@RequestBody UserInfo userInfo){
        if(userInfo!=null && userInfo.getPassword()!=null && userInfo.getUserName()!=null){
            String password = Md5Util.EncoderByMd5(userInfo.getPassword());
            userInfo.setPassword(password);
            UserInfo user = loginService.login(userInfo);
            if(user==null){
                return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_6001,GlobalConstant.RESULT_MSG_6001);
            }
            log.debug("用户登录成功=================>{}",userInfo.toString());
            user.setToken(null);
            final String token = jwtTokenUtil.createToken(JSON.toJSONString(userInfo));
            user.setToken(token);
            return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8004,GlobalConstant.RESULT_MSG_8004,user);
        }
        log.error("用户名或密码为空！");
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_7002,GlobalConstant.RESULT_MSG_7002);
    }

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/register",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String register(@RequestBody UserInfo userInfo){
        if(userInfo!=null && userInfo.getPassword()!=null && userInfo.getUserName()!=null){
            String password = Md5Util.EncoderByMd5(userInfo.getPassword());
            userInfo.setPassword(password);
            boolean result = loginService.register(userInfo);
            if(result){
                return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8002,GlobalConstant.RESULT_MSG_8002);
            }
            return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_7003,GlobalConstant.RESULT_MSG_7003);
        }
        log.error("用户名或密码为空！");
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_7002,GlobalConstant.RESULT_MSG_7002);
    }

    /**
     * 判断用户是否登录
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/isLogin",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String isLogin(@RequestBody UserInfo userInfo){
        boolean result = loginService.selectUserInfoByToken(userInfo.getToken());
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8003,GlobalConstant.RESULT_MSG_8003,result);
    }

    /**
     * 用户注销
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/loginOut",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String loginOut(@RequestBody UserInfo userInfo){
        log.debug("接受到的userId为===================>{}",userInfo.toString());
        boolean result = loginService.updateUserInfoById(Integer.valueOf(userInfo.getUserId()));
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8003,GlobalConstant.RESULT_MSG_8003,result);
    }

    @RequestMapping(value = "demo",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String demo(){
        return "链接上";
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.EncoderByMd5("123456a"));
    }



}
