package com.gzf.manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: manage
 * @description: 静态资源配置
 * @author: Gaozf
 * @create: 2020-12-29 20:38
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 得到 classpath 的根路径， resources 目录下的所以路径都可以得到
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/profile/**")
                .addResourceLocations("classpath:/Users/gzf/home/uploadPath/");
    }

}
