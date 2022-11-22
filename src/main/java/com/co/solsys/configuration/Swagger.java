package com.co.solsys.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(
                com.co.solsys.controller.controllerImpl.AccountControllerImpl.class,
                        com.co.solsys.controller.controllerImpl.SubscriptionControllerImpl.class,
                        com.co.solsys.controller.controllerImpl.BillingAddressControllerImpl.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.co.solsys"))
                .paths(PathSelectors.any())
                .build();
    }
}
