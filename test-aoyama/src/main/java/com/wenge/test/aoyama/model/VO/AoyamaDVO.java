package com.wenge.test.aoyama.model.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class AoyamaDVO implements Serializable {

    private UUID id;

    private String announcementTitle;

    private String auctionName;

    //一拍到二拍出现的问题 or 二拍到变卖出现的问题
    private String Type;

    //描述
    private String notes;
}
