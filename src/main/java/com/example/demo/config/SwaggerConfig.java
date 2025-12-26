package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 JWT Security Scheme
        SecurityScheme jwtScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        return new OpenAPI()
                .info(new Info()
                        .title("Demo API")
                        .version("1.0")
                        .description("JWT Secured APIs")
                )
                .servers(List.of(
                        new Server().url("https://9050.32procr.amypo.ai/")
                ))
                // 🔥 THIS ENABLES AUTHORIZE BUTTON
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .schemaRequirement("BearerAuth", jwtScheme);
    }
}
