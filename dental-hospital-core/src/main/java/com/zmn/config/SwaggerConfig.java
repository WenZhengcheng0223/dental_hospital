package com.zmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/22 上午 11:38
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : com.zmn.config
 * @ProjectName : DentalHospital
 * @Version : 1.0.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后端接口")
                .apiInfo(apiInfo())
                .pathMapping("/api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zmn.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("祖码农口腔医院接口")
                .contact(new Contact("peaceful", null, "wenzhengcheng0223@163.com"))
                .version("1.0.0")
                .build();
    }

}
