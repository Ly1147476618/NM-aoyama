package com.wenge.test.aoyama.service;

import com.wenge.test.aoyama.model.Query.AoyamaUserQuery;
import com.wenge.test.aoyama.model.VO.AoyamaDVO;
import com.wenge.test.aoyama.model.VO.AoyamaVO;
import com.wenge.test.aoyama.model.VO.JWTResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

public interface AoyamaService {
    List<AoyamaVO> getList();

    List<AoyamaDVO> getDCondition() throws ParseException;

    JWTResponseData login(AoyamaUserQuery aoyamaUserQuery);

    JWTResponseData loginOut(HttpServletRequest request, HttpServletResponse response);
}
