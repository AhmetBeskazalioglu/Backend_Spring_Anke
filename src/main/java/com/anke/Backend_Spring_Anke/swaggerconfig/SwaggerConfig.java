package com.anke.Backend_Spring_Anke.swaggerconfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // Builder design pattern
        return new OpenAPI()
                .info(new Info()
                        .title("Anke API ")
                        .version("1.0")
                        .description("Anke API Documentation")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(new Contact().email("ahmetbeskazalioglu@gmail.com")
                                .name("Ahmet Beskazalıoğlu")
                                .url("https://www.krafttechnologie.com/tr/index")));

    }
}
