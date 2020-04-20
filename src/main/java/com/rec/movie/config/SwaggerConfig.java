package com.rec.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author：XudongHu
 * @description: swagger的配置文件
 * @date:9:45 2018/10/24
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String URL = "http://localhost";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rec.movie.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("电影推荐系统")   //标题
                .description("接口页面")     //说明
                .termsOfServiceUrl(URL)  //服务器地址
                .version("1.0")         //版本号
                .build();
    }


}
