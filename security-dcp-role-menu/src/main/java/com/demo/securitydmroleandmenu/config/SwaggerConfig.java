package com.demo.securitydmroleandmenu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther:Lian
 * @Date:2020/10/8 11:09
 * @Description:TODO
 * @version:1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket organizationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName("API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.securitydmroleandmenu.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Security-动态角色权限管理-接口文档")
                .contact(new Contact("lian", "", "L1anyX@126.com"))
                .description("SpringSecurity + MongoDB + Swagger2")
                .build();
    }
}
