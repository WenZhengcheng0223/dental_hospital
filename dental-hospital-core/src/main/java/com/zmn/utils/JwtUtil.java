package com.zmn.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.ImmutableMap;

import javax.naming.AuthenticationException;
import java.util.Date;
import java.util.Map;

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
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
//    private static final long EXPIRE_TIME = 24*60* 1000;
    //加盐
    private static final String SECRET = "12345678";

    public static String createJWT(String username, String role){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        String token = JWT.create()
                .withClaim("username",username)
                .withClaim("role",role)
                .withExpiresAt(date)
                .sign(algorithm);
        return token;
    }


    //验证 token
    public static Map<String,Claim> verifyToken(String token){

        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaims();
    }

    public static Map<String, String> getUser(String token){
        Map<String, Claim> claimMap = verifyToken(token);
        return ImmutableMap.<String,String>builder()
                .put("username", claimMap.get("username").asString())
                .put("role", claimMap.get("role").asString())
                .build();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(JwtUtil.createJWT("小白", "admin"));
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJleHAiOjE2MzI0MDkyNTYsInVzZXJuYW1lIjoi5bCP55m9In0.S7r8zPWnRooXWLviz_k6Q27sVyOPtYvA5Jlru2zaWcs";
        Map<String, String> user = JwtUtil.getUser(token);
        System.out.println(user.toString());
    }
}
