package com.pdp.springm10.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/September/2024  15:50
 **/
@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Pro API")
                        .description("API documentation for the Spring Boot Pro project")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Aliabbos Ashurov")
                                .email("aliabbosashurov@gmail.com")
                                .url("https://github.com/Aliabbos-Ashurov"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("https://docs.spring.io/spring-boot/index.html"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Production Server"),
                        new Server().url("http://localhost:9090").description("Test Server")
                ))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                )
                .security(List.of(new SecurityRequirement().addList("bearerAuth")))
                .tags(List.of(
                        new Tag().name("Authentication").description("Operations related to authentication"),
                        new Tag().name("User Management").description("Operations related to managing users")
                ));
    }
}

