package org.lboot.onlyoffice.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
 * @author  : Kindear
 * @date : 2021-11-15
 * Knife4j 文档配置 基于 SpringFox
 */
@Configuration
@EnableSwagger2
@AllArgsConstructor
public class OfficeKnife4jConfig {

    @ConditionalOnProperty(prefix = "office.api",name = "enable",havingValue = "true")
    @Bean(value = "officeApi")
    public Docket officeApi() {
        String groupName="office服务接口";
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("lucy-onlyoffice")
                .description("lucy-onlyoffice 文档预览解决方案")
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0.0")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .host("http://localhost:8080/")
                .apiInfo(apiInfo)
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.lboot.onlyoffice.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
