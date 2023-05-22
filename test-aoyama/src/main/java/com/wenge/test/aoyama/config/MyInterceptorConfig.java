package com.wenge.test.aoyama.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Resource
    SampleInterceptor sampleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(sampleInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/**/api/dataAoyama/**");
        WebMvcConfigurer.super.addInterceptors(registry);

    }

}
