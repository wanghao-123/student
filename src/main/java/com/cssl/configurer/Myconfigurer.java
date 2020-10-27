package com.cssl.configurer;

import com.cssl.interceptor.Myinterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//123
//ppppppp
//66332
@Configuration
public class Myconfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("regist.html").setViewName("regist");
        registry.addViewController("add.html").setViewName("add");
        registry.addViewController("voteview.html").setViewName("voteview");
        registry.addViewController("vote.html").setViewName("vote");
    }
}
