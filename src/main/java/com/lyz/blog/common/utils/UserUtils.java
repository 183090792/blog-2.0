package com.lyz.blog.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.lyz.blog.common.bean.entity.UserInfo;
import com.lyz.blog.common.constant.GlobalConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述:
 *
 * @Author: zhouchaobiao
 * @Date: 2019/11/25$ 15:43$
 */

public class UserUtils {

    public static UserInfo getUser(HttpServletRequest request, RedisTemplate redisTemplate){
        String header = request.getHeader(GlobalConstant.TOKEN);
        if(StringUtils.isNotEmpty(header)){
            String userDto = (String) redisTemplate.opsForValue().get(GlobalConstant.TOKEN_KEY + header.substring(7));
            return JSONObject.parseObject(userDto,UserInfo.class);
        }
        return null;
    }
}
