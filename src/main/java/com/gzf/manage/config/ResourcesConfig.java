package com.gzf.manage.config;

import com.gzf.manage.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: manage
 * @description: 静态资源配置
 * @author: Gaozf
 * @create: 2020-12-29 20:38
 **/
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {

    // classpath相对路径， file绝对路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        /*registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/META-INF/resources/static/");*/
        //上传的图片在项目路径外，
        // 访问路径如：http://127.0.0.1:8081/profile/upload/2020/12/31/b2d6e7d9-3bf1-4bfe-95b9-f5d47005f3aa.jpg
        //其中/profile表示访问的前缀。"file:/Users/gzf/home/uploadPath/"是文件真实的存储路径
        registry.addResourceHandler(Constants.RESOURCE_PREFIX+"/**")
                .addResourceLocations("file:"+GzfConfig.getProfile()+"/");
    }

    /**
     * 自定义拦截规则
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }*/

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter()
    {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置访问源地址
        //config.addAllowedOrigin("*");
        config.addAllowedOriginPattern("*");
        // 设置访问源请求头
        config.addAllowedHeader("*");
        // 设置访问源请求方法
        config.addAllowedMethod("*");
        // 对接口配置跨域设置
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
