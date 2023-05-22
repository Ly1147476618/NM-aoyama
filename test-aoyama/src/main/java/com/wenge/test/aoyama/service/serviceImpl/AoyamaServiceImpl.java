package com.wenge.test.aoyama.service.serviceImpl;

import com.wenge.test.aoyama.mapper.AoyamaMapper;
import com.wenge.test.aoyama.model.DTO.AoyamaJWTSubject;
import com.wenge.test.aoyama.model.Query.AoyamaUserQuery;
import com.wenge.test.aoyama.model.VO.AoyamaDVO;
import com.wenge.test.aoyama.model.VO.AoyamaVO;
import com.wenge.test.aoyama.model.VO.JWTResponseData;
import com.wenge.test.aoyama.service.AoyamaService;
import com.wenge.test.aoyama.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AoyamaServiceImpl implements AoyamaService {

    @Autowired
    AoyamaMapper aoyamaMapper;

    @Override
    public List<AoyamaVO> getList() {
        List<AoyamaVO> list = aoyamaMapper.getList();
        return list;
    }

    @Override
    public List<AoyamaDVO> getDCondition() throws ParseException {
        //暂定容器
        List<AoyamaDVO> resultList = new ArrayList<>();
        AoyamaDVO aoyamaDVO;

        //一拍
        List<AoyamaVO> oneBeatList = aoyamaMapper.oneBeat();
        //二拍
        List<AoyamaVO> erpaiList = aoyamaMapper.erpai();
        //变卖
        List<AoyamaVO> sellOffList = aoyamaMapper.sellOff();
        //设置小数点
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setParseBigDecimal(true);
        //统计二拍价格比一拍少80%的数据
        for (AoyamaVO a:oneBeatList){
            for (AoyamaVO e:erpaiList){
                if(!a.getAuctionName().equals("") && !e.getAuctionName().equals("")){
                    if (a.getAuctionName().equals(e.getAuctionName())){
                        //获取一拍的起拍价
                        String startingAmountA = a.getStartingAmount();
                        String startingReplaceA = startingAmountA.replace("元", "");
                        //将a的起拍价转化为BigDecimal类型
                        BigDecimal bigDecimalA = (BigDecimal) decimalFormat.parse(startingReplaceA);
                        BigDecimal multiplyA = bigDecimalA.multiply(BigDecimal.valueOf(0.8));

                        //b类型的转化
                        String startingAmountB = e.getStartingAmount();
                        String startingReplaceB = startingAmountB.replace("元", "");

                        BigDecimal bigDecimalB = (BigDecimal) decimalFormat.parse(startingReplaceB);

                        int flag = multiplyA.compareTo(bigDecimalB);

                        if (flag == 1){
                            aoyamaDVO = new AoyamaDVO();

                            //少了多少钱
                            BigDecimal subtract = bigDecimalB.subtract(multiplyA);
                            //自动生成uuid
                            UUID uuid = UUID.randomUUID();

                            aoyamaDVO.setId(uuid);
                            aoyamaDVO.setAnnouncementTitle(a.getAnnouncementTitle());
                            aoyamaDVO.setAuctionName(a.getAuctionName());
                            aoyamaDVO.setType("一拍到二拍出现的问题");
                            aoyamaDVO.setNotes("二拍拍卖价格比一拍拍卖价格的80%要少"+subtract+"元");
                            resultList.add(aoyamaDVO);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    @Override
    public JWTResponseData login(AoyamaUserQuery aoyamaUserQuery) {
        //创建return null对象
        JWTResponseData responseData = null;
        //查询用户和密码是否正确
        boolean login = aoyamaMapper.login(aoyamaUserQuery);
        if(login == true){
            AoyamaJWTSubject Subject = new AoyamaJWTSubject(aoyamaUserQuery.getUserName());
            String jwtToken = JWTUtils.createJWT(UUID.randomUUID().toString(), "sxt-test-jwt", JWTUtils.generalSubject(Subject), 1 * 60 * 1000);
            responseData = new JWTResponseData();
            responseData.setCode(200);
            responseData.setData(null);
            responseData.setMsg("登录成功");
            responseData.setToken(jwtToken);
        }else {
            responseData = new JWTResponseData();
            responseData.setCode(500);
            responseData.setData(null);
            responseData.setMsg("登录失败,用户名或密码错误");
            responseData.setToken(null);
        }
        return responseData;
    }

    @Override
    public JWTResponseData loginOut(HttpServletRequest request, HttpServletResponse response) {

        return null;
    }


}
