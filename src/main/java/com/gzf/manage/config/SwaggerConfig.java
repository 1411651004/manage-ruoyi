package com.gzf.manage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProgramName: manage
 * @ClassName: SwaggerConfig
 * @description: swagger配置
 * @author: Gaozf
 * @Date: 2021/1/6 9:51
 **/
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig implements ApplicationRunner {

    /** 是否开启swagger */
    @Value("${swagger.enabled}")
    private boolean enabled;

    @Value("${server.port:8080}")
    private String serverPort;

    @Value("${server.servlet.context-path:}")
    private String serverContextPath;

    @Value("${spring.cloud.client.ip-address:127.0.0.1}")
    private String ip;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 是否启用Swagger
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.gzf.manage.controller"))
                .paths(PathSelectors.any())
                .build()
                //设置请求统一前缀
                .pathMapping(serverContextPath);
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Lx-Gzf开发webAPI")
                //创建人
                .termsOfServiceUrl("http://localhost")
                .contact(new Contact("gzf","39.105.31.111",""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.warn("swagger doc url: http://{}:{}{}doc.html",ip,serverPort,serverContextPath);
        log.warn("swagger doc url: http://{}:{}{}swagger-ui.html",ip,serverPort,serverContextPath);

    }
}
