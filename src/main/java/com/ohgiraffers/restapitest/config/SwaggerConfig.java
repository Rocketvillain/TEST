package com.ohgiraffers.restapitest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    // http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .components(new Components())
                .info(swaggerInfo());
    }

    private Info swaggerInfo() {
        return new Info()
                .title("JDH API")
                .description("SpringBoot Swagger 연동테스트")
                .version("1.0.0");
    }
}
