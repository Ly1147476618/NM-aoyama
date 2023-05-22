package com.wenge.test.aoyama.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JWTUtils {

    //签发者，用于做加密的key数据
    private static final String JWT_SECERT = "test_jwt_secert";

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static final int JWT_ERRCODE_EXPIRE = 1005; //Token过期

    public static final int JWT_ERRCODE_FAIL = 1006; //验证不通过

    /**
     * 生成密钥Key的方法
     * @return
     */
    public static SecretKey generalKey(){
        try{
            //byte[] encodedKey = Base64.decode(JWT_SECERT);
            byte[] encodedKey = JWT_SECERT.getBytes("UTF-8");
            SecretKey key = new SecretKeySpec(encodedKey,0,encodedKey.length,"AES");
            return key;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建token对象
     * @param id JWT的唯一身份标志,只要用来作为一次性token,从而回避重放攻击
     * @param iss JWT签发者
     * @param subject JWT所面向的用户,payload中记录的public claims的公开信息 = (用户的登录名)
     * @param ttlMillis 有效期，单位毫秒
     * @return token token是一次性的，用户退出或者超时用户失效。
     */
    public static String createJWT(String id,String iss,String subject,long ttlMillis){
        //加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //当前时间
        long nowMillis = System.currentTimeMillis();
        //当前时间的日期对象
        Date now = new Date(nowMillis);
        //把我的generalKey(密钥生成出来)
        SecretKey secretKey = generalKey();
        //创建JWT的构建器
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuer(iss)
                .setSubject(subject)
                .setIssuedAt(now) //token生成的时间
                .signWith(signatureAlgorithm,secretKey);

        if(ttlMillis >= 0){
            long expMillis = nowMillis + ttlMillis;
            Date date = new Date(expMillis);
            builder.setExpiration(date); //token失效时间
        }
        return builder.compact(); //生成token
    }

    /**
     * 校验JWT
     */
    public static JWTResult validateJWT(String jwtStr){
        JWTResult checkResult = new JWTResult();
        Claims claims = null;
        try{
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        }catch (ExpiredJwtException e){
            checkResult.setErrCode(JWT_ERRCODE_EXPIRE); //过时
            checkResult.setSuccess(false);
        }catch (SignatureException e){
            checkResult.setErrCode(JWT_ERRCODE_FAIL); //校验失败
            checkResult.setSuccess(false);
        }catch (Exception e){
            checkResult.setErrCode(JWT_ERRCODE_FAIL); //运行异常
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * 解析JWT字符串
     * @param jwt 就是服务器为客户端生成的签名数据，就是token。
     * @return
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody(); //getBody获取的token中记录的payload数据,payload中保存的所有claims
    }

    /**
     * 生成subject信息
     * @param subObj -> 要转换的对象
     * @return java对象 -> JSON字符串出错时返回null
     */
    public static String generalSubject(Object subObj){
        try{
            return MAPPER.writeValueAsString(subObj);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            return null;
        }
    }
















}
