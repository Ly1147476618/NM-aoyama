package com.wenge.test.aoyama.model.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class AoyamaVO implements Serializable {

    private int id;

    private String announcementTitle;

    private String announcementTime;

    private String auctionName;

    private String auctionType;

    private String auctionTime;

    private String auctionFrequency;

    private String startingAmount;

    private String priceIncreaseMargin;

    private String securityDeposit;

    private String signingTime;

}
