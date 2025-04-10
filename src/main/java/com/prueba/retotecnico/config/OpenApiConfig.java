package com.prueba.retotecnico.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API de Solicitudes", version = "1.0", description = "CRUD de Solicitudes"))
public class OpenApiConfig {
}
