package com.lyz.blog.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyz.blog.common.bean.dto.SecurityUserDetails;
import com.lyz.blog.common.bean.entity.UserInfo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 功能说明：
 *
 * @author LYZ
 * @date 2020/4/11 16:35
 */
@Component
public class JwtTokenUtil<T> implements Serializable {
    private static final long serialVersionUID = -3301605591108950415L;

    @Value("${jwt.secret}")
    private  String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.token}")
    private String tokenHeader;

    private Clock clock = DefaultClock.INSTANCE;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String createToken(String appId) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, appId);
    }

    /**
     * 解析 Token
     * @param token
     * @param clazz
     * @return
     */
    public String parseToken(String token,Class<T> clazz){
        String subject = Jwts.parser()
                             .setSigningKey(secret)
                             .parseClaimsJws(token)
                             .getBody().getSubject();
//        T t = JSON.parseObject(subject, clazz);

        return subject;
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        SecurityUserDetails user = (SecurityUserDetails) userDetails;
        final String username = getUsernameFromToken(token);
        JSONObject jsonObject = JSONObject.parseObject(username);
        UserInfo userInfo = JSON.toJavaObject(jsonObject, UserInfo.class);
        return (userInfo.getUserName().equals(user.getUsername())
                && !isTokenExpired(token)
        );
    }

    public void demo1(Class<T> clazz){
        System.out.println(clazz);
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public static void main(String[] args) {
        JwtTokenUtil<UserInfo> jwtTokenUtil = new JwtTokenUtil();
        jwtTokenUtil.demo1(UserInfo.class);
//        String asdqwe = jwtTokenUtil.createToken("asdqwe");


//        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJwYXNzd29yZFwiOlwiOUNCRjhBNERDQjhFMzA2ODJCOTI3RjM1MkQ2NTU5QTBcIixcInVzZXJOYW1lXCI6XCLlvKDkuIlcIn0iLCJleHAiOjE2MDY2NTc5MjUsImlhdCI6MTU5OTQ1NzkyNX0.OInb0QRnxhS5RWH1zDajq13FDC5t-pb8T-7XUrU9WByomKEl8BCwlvSN6K0fcG_4rfsF8VkmQGmQMU9Beetj8w";
//        Jws<Claims> secret = Jwts.parser().setSigningKey("secret").parseClaimsJws(token);
//        String secret = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody().getSubject();
//        UserInfo userInfo = JSON.toJavaObject(JSON.parseObject(secret), UserInfo.class);
//        System.out.println(secret);
    }

}
