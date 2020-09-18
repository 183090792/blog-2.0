package com.lyz.blog;

import com.lyz.blog.common.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void demo1(){
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String asdqwe = jwtTokenUtil.createToken("asdqwe");

//        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiLlvKDkuIkiLCJleHAiOjE2MDY2NDYzMjksImlhdCI6MTU5OTQ0NjMyOX0.m6CR1aQ8lcOSuxiJeiYKoq7Tx81BzZlHX_rSnp7gSxCCqk5KTDk-QFCFqVvjzKQZWCeDDNRfOInEYT1lk4Somw";
        Claims body = Jwts.parser().parseClaimsJws(asdqwe).getBody();
        System.out.println(body);
    }

}
