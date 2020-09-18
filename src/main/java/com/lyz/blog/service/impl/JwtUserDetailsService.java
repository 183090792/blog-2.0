package com.lyz.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyz.blog.common.bean.dto.SecurityUserDetails;
import com.lyz.blog.common.bean.entity.UserInfo;
import com.lyz.blog.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 *
 * @author LYZ
 * @date 2020/4/11 16:35
 */
@Service("jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("JwtUserDetailsService:" + userName);
        JSONObject jsonObject = JSONObject.parseObject(userName);
        UserInfo userInfo = JSON.toJavaObject(jsonObject, UserInfo.class);
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq("user_name",userInfo.getUserName());
        UserInfo user = userInfoService.getOne(userInfoQueryWrapper);

        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        User user1 = new User();

        return new SecurityUserDetails(user,authorityList);
    }

}
