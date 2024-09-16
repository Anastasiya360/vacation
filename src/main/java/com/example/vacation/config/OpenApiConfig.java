package com.example.vacation.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Calculation of vacation pay",
                description = "Calculation of vacation pay", version = "2.6.0",
                contact = @Contact (
                        name = "Anastasia",
                        email = "n.bogocharova@gmail.com"
                )
        )
)
public class OpenApiConfig {

}

