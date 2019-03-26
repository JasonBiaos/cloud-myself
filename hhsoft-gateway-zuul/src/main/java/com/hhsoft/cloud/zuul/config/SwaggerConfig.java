package com.hhsoft.cloud.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description 网关Swagger接口文档
 * @Author Jason Biao
 * @Date 2019/3/26 10:16
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("网关Swagger接口文档")
                .apiInfo(new ApiInfoBuilder().title("网关Swagger接口文档")
                        .contact(new Contact("Jason Biao", "", "13381810527@163.com")).version("1.0").build())
                .select().paths(PathSelectors.any()).build();
    }

}
