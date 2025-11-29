package com.pokemon.api_pokemon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI pokemonApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pokémon API")
                        .description("Documentação da API Pokémon")
                        .version("1.0.0"));
    }
}
