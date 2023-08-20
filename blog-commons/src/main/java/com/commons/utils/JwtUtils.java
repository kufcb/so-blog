package com.commons.utils;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.commons.constant.JwtConstant;
import com.commons.pojo.entity.User;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yys
 * @date 2023/8/20 23:48
 * @desc
 */
@Slf4j
public class JwtUtils {
    private String secret = "WEsaweawosndasda";
    // #秒 7天
    private Long expiration = 604800L;

    /**
     * 根据信息生成token
     *
     * @param user
     * @return
     */
    public String generateToken(User user) {
        Gson gson = new Gson();
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(JwtConstant.USER_INFO, gson.toJson(user));
        return generateToken(claims);
    }

    /**
     * token中获取用户信息
     *
     * @param token
     * @return
     */
    public User getUserInfoFromToken(String token) {
        User user;
        Gson gson = new Gson();
        try {
            Claims claims = getClaimsFromToken(token);
            user = gson.fromJson(claims.get(JwtConstant.USER_INFO).toString(), User.class);
        } catch (Exception e) {
            log.error("从token中获取token消息失败 error=>{}", ExceptionUtil.stacktraceToString(e));
            user = null;
        }
        return user;
    }


    /**
     * 获取荷载
     *
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("解析token有问题 error=>{}", ExceptionUtil.stacktraceToString(e));
        }
        return claims;
    }

    /**
     * 根据荷载生成JWT token
     *
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(claims.get("userName").toString())
                .setIssuedAt(new Date())
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成token生效时间
     *
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
}
