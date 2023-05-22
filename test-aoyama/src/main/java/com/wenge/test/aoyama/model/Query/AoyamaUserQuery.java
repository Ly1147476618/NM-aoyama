package com.wenge.test.aoyama.model.Query;


import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class AoyamaUserQuery implements Serializable {

    @NotNull
    private String userName;

    @NotNull
    private String passWord;

}
