package com.lyz.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lyz.blog.common.bean.entity.UserInfo;

/**
 * @author LYZ
 * @create 2019/5/15 21:34
 **/
public interface IUserInfoService extends IService<UserInfo> {
    /**
     * 用户登录
     * @param userInfo  用户名 密码
     * @return
     */
    UserInfo login(UserInfo userInfo);

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    boolean register(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateByUserInfo(UserInfo user);

    /**
     * 判断用户是否登录
     * @param token
     * @return
     */
    boolean selectUserInfoByToken(String token);

    /**
     * 用户注销
     * @param userId
     * @return
     */
    boolean updateUserInfoById(Integer userId);

}
