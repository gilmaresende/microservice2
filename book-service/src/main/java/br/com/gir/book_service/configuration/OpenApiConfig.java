package br.com.gir.book_service.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(title = "Book Service API",
                version = "V1",
                description = "Documentation of Book Service API")
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()).info(new io.swagger.v3.oas.models.info.Info().title("Book Service API")
                .version("V1")
                .description("Documentation of Book Service API")
                .license(new License().name("Apache 2.0")
                        .url("http://sprinigdoc.org")));
    }
}
