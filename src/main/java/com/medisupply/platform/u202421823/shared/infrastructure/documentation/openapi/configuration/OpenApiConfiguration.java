package com.medisupply.platform.u202421823.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configures the OpenAPI specification exposed by the platform (Swagger UI).
 * Security is intentionally not enabled for the documentation.
 */

@Configuration
public class OpenApiConfiguration {

    @Value("${spring.application.name}")
    String applicationName;

    @Value("${documentation.application.description}")
    String applicationDescription;

    @Value("${documentation.application.version}")
    String applicationVersion;


    @Bean
    public OpenAPI teslaPlatformOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(this.applicationName)
                        .description(this.applicationDescription)
                        .version(this.applicationVersion))
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Local Development Environment")));
    }
}
