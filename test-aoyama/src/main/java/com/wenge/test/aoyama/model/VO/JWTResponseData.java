package com.wenge.test.aoyama.model.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 发送给客户端的数据对象
 */

@Data
public class JWTResponseData implements Serializable {

    private Integer code; //返回码

    private Object data; //返回数据

    private String msg; //返回描述

    private String token; //身份识别 JWT生成的令牌信息
}
