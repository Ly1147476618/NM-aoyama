package com.wenge.test.aoyama.config;

import com.alibaba.fastjson.JSONObject;
import com.wenge.test.aoyama.model.VO.JWTResponseData;
import com.wenge.test.aoyama.util.JWTResult;
import com.wenge.test.aoyama.util.JWTUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class SampleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.如果请求要去登陆页面则放行
        if (request.getRequestURI().contains("login")) {
            return true;
        }

        // 2.如果用户已登录token不为null也放行
        String token = request.getHeader("Authorization");
        JWTResult result = JWTUtils.validateJWT(token);
        JWTResponseData responseData = new JWTResponseData();
        PrintWriter out = null;

        if (result.isSuccess()){
            responseData.setCode(200);
            responseData.setData(result.getClaims().getSubject());
            String newToken = JWTUtils.createJWT(result.getClaims().getId(), result.getClaims().getIssuer(),
                    result.getClaims().getSubject(), 1*60*1000);
            responseData.setToken(newToken);
            //
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JSONObject res = new JSONObject ();
            res.put("data",responseData);
            out = response.getWriter();
            out.append(res.toString());
            return true;
        }
//        else {
//            responseData.setCode(500);
//            responseData.setMsg("用户未登录");
//
//            //
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//            JSONObject res = new JSONObject ();
//            res.put("data",responseData);
//            out = response.getWriter();
//            out.append(res.toString());
//            //跳转前端login页面
//            //request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request,response);
//            return false;
//        }

        // 3.用户未登录 - 直接跳转login页面
        //request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        responseData.setCode(500);
        responseData.setMsg("用户未登录");

        //
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject ();
        res.put("data",responseData);
        out = response.getWriter();
        out.append(res.toString());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("逻辑中");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("拦截后");
    }
}
