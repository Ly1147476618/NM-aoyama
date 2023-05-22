package com.wenge.test.aoyama.controller;

import com.wenge.test.aoyama.model.Query.AoyamaUserQuery;
import com.wenge.test.aoyama.model.VO.AoyamaDVO;
import com.wenge.test.aoyama.model.VO.AoyamaVO;
import com.wenge.test.aoyama.model.VO.JWTResponseData;
import com.wenge.test.aoyama.service.AoyamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * NM 青山区
 * @author liuyan 2023/05/19 17:03
 */
@RequestMapping("/api/dataAoyama")
@RestController
public class AoyamaController {

        @Autowired
        AoyamaService aoyamaService;

        @GetMapping(value = "/getList")
        public List<AoyamaVO> getList(){
            return aoyamaService.getList();
        }

        @GetMapping(value = "/getDCondition")
        public List<AoyamaDVO> getDCondition() throws ParseException {
                return aoyamaService.getDCondition();
        }

        //登录
        @PostMapping(value = "/login")
        public JWTResponseData login(@Validated @RequestBody AoyamaUserQuery aoyamaUserQuery) {
                return aoyamaService.login(aoyamaUserQuery);
        }

        //退出
        @PostMapping(value = "/loginOut")
        public JWTResponseData loginOut(HttpServletRequest request, HttpServletResponse response) {
                return aoyamaService.loginOut(request,response);
        }

}
