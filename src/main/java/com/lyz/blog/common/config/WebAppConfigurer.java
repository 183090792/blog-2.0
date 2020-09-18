package com.lyz.blog.common.config;


import com.lyz.blog.common.config.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 功能描述: 拦截器配置
 * @Author: zhouchaobiao
 * @Date: 2019/11/1 10:09
 */
//@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    /**
     * 这里需要先将限流拦截器入住，不然无法获取到拦截器中的redistemplate
     * @return
     */
//    @Bean
    public LoginInterceptor getAccessLimitIntercept() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //登录拦截的管理器
        //拦截的对象会进入这个类中进行判断
        InterceptorRegistration registration = registry.addInterceptor(getAccessLimitIntercept());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns("/","/sso/sso/login","/sso/login","/login","/error","/static/**","/logout","/getLoginUrl","/loginScan","/findUser",
                "/oauth/authorize","/app/toSeaFile","/oauth/callback/","/oauth/user");

    }


}