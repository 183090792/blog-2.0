package com.lyz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyz.blog.common.bean.entity.UserInfo;
import com.lyz.blog.mapper.UserInfoMapper;
import com.lyz.blog.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author LYZ
 * @create 2019/5/15 21:35
 **/
@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 用户登录
     * @param userInfo  用户名 密码
     * @return
     */
    @Override
    public UserInfo login(UserInfo userInfo) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userInfo.getUserName());
        queryWrapper.eq("password",userInfo.getPassword());
        UserInfo user = userInfoMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public boolean register(UserInfo userInfo) {
        try {
            userInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
            userInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            int result = userInfoMapper.insert(userInfo);
            if(result>0){
                return true;
            }
        } catch (Exception e) {
            log.error("用户注册时发生异常,用户名为===========>{},异常信息为==============>{}",userInfo.getUserName(),e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

        }
        return false;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int updateByUserInfo(UserInfo user) {
        int result = 0;
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getUserId());
            userInfo.setToken(user.getToken());
            result = userInfoMapper.updateById(userInfo);
        } catch (Exception e) {
            log.error("用户修改加密字段时发生异常,用户名为===========>{},异常信息为==============>{}",user.getUserName(),e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断用户是否登录
     * @param token
     * @return
     */
    @Override
    public boolean selectUserInfoByToken(String token) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token",token);
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        if(!StringUtils.isEmpty(userInfos) && userInfos.size()==1){
            return true;
        }
        return false;
    }

    /**
     * 用户注销
     * @param userId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public boolean updateUserInfoById(Integer userId) {
        int result = 0;
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            userInfo.setToken("空");
            result = userInfoMapper.updateById(userInfo);
            if(result==1){
                return true;
            }else {
                throw new Exception("用户注销是修改了多个用户参数");
            }
        } catch (Exception e) {
            log.error("用户注销时发生异常,用户ID为===========>{},异常信息为==============>{}",userId,e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return false;
    }
}
