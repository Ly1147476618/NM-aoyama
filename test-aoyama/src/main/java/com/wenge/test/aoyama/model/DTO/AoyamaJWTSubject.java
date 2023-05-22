package com.wenge.test.aoyama.model.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * 用作项目数据使用，存放payload中保存的public claims
 * 不包含敏感数据
 */

@Data
public class AoyamaJWTSubject implements Serializable {

    private String userName;

    public AoyamaJWTSubject(){
        super();
    }

    public AoyamaJWTSubject(String userName){
        super();
        this.userName = userName;
    }
}
