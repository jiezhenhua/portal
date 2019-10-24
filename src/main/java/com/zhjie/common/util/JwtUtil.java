package com.zhjie.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

	/**
	 * 过期时间15分钟
	 */
	private static final long EXPRE_TIME = 15*60*1000;
	/**
	 * tonken私钥
	 */
	private static final String TOKEN_SECRET = "adfdasdfudsf878asdupfds9";
	
	/**
	 * 签名
	 * @param username
	 * @param userId
	 * @return
	 */
	public static String sign(String username, String userId){
		
		try {
			//过期时间
			Date date = new Date(System.currentTimeMillis() + EXPRE_TIME);
			//私钥及加密算法
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			//设置头部信息
			Map<String, Object> header = new HashMap<>();
			header.put("type", "JWT");
			header.put("alg", "HS256");
			//附带username,userId,生成签名信息
			return JWT.create().withHeader(header)
					.withClaim("loginName", username)
					.withClaim("userId", userId)
					.withExpiresAt(date)
					.sign(algorithm);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 校验token是否正确
	 * @param token 秘钥
	 * @return 是否正确
	 */
	public static boolean verify(String token){
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public static void main(String[] args) {
		String token = sign("Admin", "123456");
		System.out.println(token);
		System.out.println(verify(token));
	}
}
