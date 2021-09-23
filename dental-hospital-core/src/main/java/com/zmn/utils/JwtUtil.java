package com.zmn.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import javax.naming.AuthenticationException;
import java.util.Date;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/22 下午 05:49
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.utils
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */
public class JwtUtil {
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    //加盐
    private static final String SECRET = "xh";

    public static String createJWT(String username) throws Exception{
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);//指定过期时间
        Algorithm algorithm = Algorithm.HMAC256(SECRET);//指定加密算法+加盐
        String jwt = JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
        return jwt;
    }


    //验证 token
    public static Boolean verify(String token,String username) throws Exception{
        if (StringUtils.isBlank(token)) {
            throw new AuthenticationException("Token不能为空!");
        }

        if (StringUtils.isBlank(username)) {
            throw new AuthenticationException("username不能为空!");
        }

        Algorithm algorithm = Algorithm.HMAC256(SECRET);//指定加密算法+加盐
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withClaim("username",username).build();
        try{
            jwtVerifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static String decoded(String token) throws Exception{
        DecodedJWT decode = JWT.decode(token);
        Claim claim = decode.getClaim("username");
        return claim.asString();
    }
    public static void main(String[] args) throws Exception {
        String tonken= createJWT("张三");
        System.out.println(createJWT("张三"));

        System.out.println(verify("tonken","张三"));
    }
}
