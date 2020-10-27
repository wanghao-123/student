package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.cssl.web")
@MapperScan(basePackages = "com.cssl.dao")
@SpringBootApplication
public class XmApplication {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XmApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(XmApplication.class, args);
    }
}
