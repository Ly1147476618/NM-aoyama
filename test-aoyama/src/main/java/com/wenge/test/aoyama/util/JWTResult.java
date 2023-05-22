package com.wenge.test.aoyama.util;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * 结果对象
 */
@Data
public class JWTResult {

    private int errCode;

    private boolean success;

    private Claims claims;

}
