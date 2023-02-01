package com.lasprogramaderas.todolist.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springToDoListOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("To Do List")
						.description("Aplicação desenvolvida para o projeto praticando start")
						.version("1.0.0")
						.contact(new Contact()
								.name("Rafaela Santos")
								.email("santos.rafaela2991@gmail.com")
								.url("https://www.linkedin.com/in/rafaela-psantos/")));
	}
}
