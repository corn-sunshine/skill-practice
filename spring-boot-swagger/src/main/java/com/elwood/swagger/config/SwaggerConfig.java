package com.elwood.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/11/11
 * @Version: 1.0
 */
@Configuration // 配置类
@EnableSwagger2 // 开启Swagger2的自动配置
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("corn", "https://github.com/corn-sunshine", "695803955@qq.com");
        return new ApiInfo(
                "swagger测试", // 标题
                "Swagger的学习", // 描述
                "v1.0", // 版本
                "https://github.com/corn-sunshine", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "https://github.com/corn-sunshine", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
