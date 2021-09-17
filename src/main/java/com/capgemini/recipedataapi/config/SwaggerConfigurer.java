package com.capgemini.recipedataapi.config;

import static com.capgemini.recipedataapi.util.Constants.API_DESCRIPTION;
import static com.capgemini.recipedataapi.util.Constants.API_NAME;
import static com.capgemini.recipedataapi.util.Constants.API_TITLE;
import static com.capgemini.recipedataapi.util.Constants.API_VERSION;
import static com.capgemini.recipedataapi.util.Constants.AUTHORIZATION_DESCRIPTION;
import static com.capgemini.recipedataapi.util.Constants.AUTHORIZATION_HEADER;
import static com.capgemini.recipedataapi.util.Constants.AUTHORIZATION_SCOPE;
import static com.capgemini.recipedataapi.util.Constants.CONTACT_EMAIL;
import static com.capgemini.recipedataapi.util.Constants.CONTACT_NAME;
import static com.capgemini.recipedataapi.util.Constants.CONTACT_URL;
import static com.capgemini.recipedataapi.util.Constants.LICENSE;
import static com.capgemini.recipedataapi.util.Constants.LICENSE_URL;
import static com.capgemini.recipedataapi.util.Constants.TERM_OF_SERVICE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

	/**
	 * This bean is used for generation of Swagger documentation for each end point.
	 * 
	 * @return Docket class object
	 */
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
				.apis(RequestHandlerSelectors.basePackage("com.capgemini.recipedataapi.controller")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION, TERM_OF_SERVICE, contact(), LICENSE, LICENSE_URL,
				Collections.emptyList());
	}

	private Contact contact() {
		return new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL);
	}

	private ApiKey apiKey() {
		return new ApiKey(API_NAME, AUTHORIZATION_HEADER, SecuritySchemeIn.HEADER.name());
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(securityReference()).build();
	}

	List<SecurityReference> securityReference() {
		AuthorizationScope[] authorizationScope = {
				new AuthorizationScope(AUTHORIZATION_SCOPE, AUTHORIZATION_DESCRIPTION) };
		return Arrays.asList(new SecurityReference(API_NAME, authorizationScope));
	}

}
