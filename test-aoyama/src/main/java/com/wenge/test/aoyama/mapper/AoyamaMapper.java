package com.wenge.test.aoyama.mapper;

import com.wenge.test.aoyama.model.Query.AoyamaUserQuery;
import com.wenge.test.aoyama.model.VO.AoyamaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AoyamaMapper {

    List<AoyamaVO> getList();

    List<AoyamaVO> oneBeat();

    List<AoyamaVO> erpai();

    List<AoyamaVO> sellOff();

    boolean login(AoyamaUserQuery aoyamaUserQuery);
}
