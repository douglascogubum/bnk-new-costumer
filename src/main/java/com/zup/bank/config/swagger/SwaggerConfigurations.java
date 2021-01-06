package com.zup.bank.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zup.bank.model.User;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket bankApi() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.zup.bank"))
					.paths(PathSelectors.ant("/**"))
					.build()
					.ignoredParameterTypes(User.class)
					.apiInfo(apiInfo())
					.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
						.name("Authorization")
						.description("Header for JWT Token")
						.modelRef(new ModelRef("string"))
						.parameterType("header")
						.required(false)
						.build()));
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Bank Spring Boot exemplo")
	            .description("Um exemplo de aplicação Spring Boot REST API")
	            .version("0.1.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Douglas Cogubum", "http://www.zup.com.br", "doug_cogubum@htomail.com"))
	            .build();
	}
}
