package com.example.gestao_produtos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestão de Produtos")
                        .description("API REST para gerenciamento de produtos desenvolvida com Spring Boot.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Ivan L. Silva Junior")
                                .url("https://github.com/IvanSilva21")
                        )
                );
    }
}
