package com.jcavi.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jcavi.cadastro.controller"))
                .paths(PathSelectors.regex("/v1.*"))
                .build()
                .apiInfo(metaInfo())
                .securitySchemes(Arrays.asList(apiKey()));

    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Cadastro - API REST",
                "Cadastro de produtos gerais",
                "1.0",
                "Termos de serviços",
                new Contact("Wesley Pereira", "https://www.linkedin.com.in/jimmmisss",
                        "contato@legalizzr.com.br"),
                "MIT",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()

        );

        return apiInfo;
    }

    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }

}
