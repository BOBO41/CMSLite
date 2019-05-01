package com.xiang.shiro;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xiang.bean.vo.XAuthToken;
import com.xiang.restserver.APIException;
import com.xiang.restserver.ErrorCodes;

/**
 * @author xiang
 * @createDate 2018年12月13日 上午9:38:01
 */
public class JWTAuth {
	private static String JWTSECRET = "<MQLMNQNQJQK sdfXX#$%()(#*!()!KL<>kjsdrow38854545fd";
	private static final String ISSUER = "com.auth0";
	public static final String USERNAME="username";
	public static final String TOKENHEADER="XAuthToken";
	public static final String USERID="id";
	public static final String NICK="nick";
	/**
	 * token过期时间，默认7天，单位天
	 */
	public static int DEFAULT_EXPIRE_DAY = 7;
	/**
	 * 间隔1小时刷新一次token，单位小时
	 */
	public static long DEFAULT_REFRESH_TOKEN = 1;
	public void setSecret(String secret) {
		JWTAuth.JWTSECRET=secret;
	}
	/**
	 * 生成token
	 *
	 * @param claims
	 * @return
	 */
	public static XAuthToken createToken(Map<String, String> claims) throws APIException {
		try {
			Date  expireAt=DateUtils.addDays(new Date(), DEFAULT_EXPIRE_DAY);
			Algorithm algorithm = Algorithm.HMAC256(JWTSECRET);
			JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER)
					.withExpiresAt(expireAt);
			claims.forEach(builder::withClaim);
			String token=builder.sign(algorithm);
			XAuthToken xAuthToken=getXAuthToken(claims);
			xAuthToken.setExpireAt(expireAt);
			xAuthToken.setToken(token);
			return xAuthToken;
		} catch (IllegalArgumentException e) {
			throw new APIException(ErrorCodes.createErrorCode("生成token失败"));
		}
	}
	public static XAuthToken getXAuthToken(Map<String, String> claims)
	{
		XAuthToken xAuthToken=new XAuthToken();
		String id=claims.get(USERID);
		if(!StringUtils.isEmpty(id))
		{
			xAuthToken.setId(Long.parseLong(id));
		}
		xAuthToken.setNick(claims.get(NICK));
		xAuthToken.setToken(claims.get(TOKENHEADER));
		xAuthToken.setUserName(claims.get(USERNAME));
		return xAuthToken;
	}
	public static String refreshToken(String token) throws APIException {
		return refreshToken(verifyToken(token));
	}
	public static String refreshToken(Map<String, String> map) throws APIException {
		String exp = map.get(PublicClaims.EXPIRES_AT);
		if (exp != null) {
			long passTime = DateUtils.addDays(new Date(), DEFAULT_EXPIRE_DAY).getTime() - Long.parseLong(exp) * 1000l;
			if (passTime >= DEFAULT_REFRESH_TOKEN * 3600000) {
				map.remove(PublicClaims.EXPIRES_AT);
				XAuthToken xAuthToken=createToken(map);
				return xAuthToken.getToken();
			}
		}
		return null;
	}

	/**
	 * 验证jwt，并返回数据
	 */
	public static Map<String, String> verifyToken(String token) throws APIException {
		Algorithm algorithm;
		Map<String, Claim> map;
		try {
			algorithm = Algorithm.HMAC256(JWTSECRET);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
			DecodedJWT jwt = verifier.verify(token);
			map = jwt.getClaims();
		} catch (Exception e) {
			e.printStackTrace();
			throw new APIException(ErrorCodes.LOGIN);
		}
		Map<String, String> resultMap = new HashMap<>(map.size());
		for (String name : map.keySet()) {
			switch (name) {
			case PublicClaims.ISSUER:
				break;
			case PublicClaims.SUBJECT:
				break;
			case PublicClaims.EXPIRES_AT:
				if (map.get(name) != null) {
					Long exp = map.get(name).asLong();
					if (exp != null)
						resultMap.put(name, exp.toString());
				}
				break;
			case PublicClaims.NOT_BEFORE:
				break;
			case PublicClaims.ISSUED_AT:
				break;
			case PublicClaims.JWT_ID:
				break;
			case PublicClaims.AUDIENCE:
				break;
			default:
				resultMap.put(name, map.get(name).asString());
			}
		}
		return resultMap;
	}
}
