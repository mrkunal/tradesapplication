package org.balaji.multiplex.commons.config;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Swagger Configuration api
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Logger log = LogManager.getLogger(SwaggerConfig.class);

	@PostConstruct
	private void postSwaggerConfig1() {
		log.info("Java 14 Module Application swagger Initialize");
	}

	
	@Bean
	public Docket api() {
		log.info("Docket Bean Created for Swagger");

		AuthorizationScope[] authScopes = new AuthorizationScope[1];
		authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();
		SecurityReference securityReference = SecurityReference.builder().reference("Authorization-Key")
				.scopes(authScopes).build();

		ArrayList<SecurityContext> securityContexts = Lists.newArrayList(
				SecurityContext.builder().securityReferences(Lists.newArrayList(securityReference)).build());

		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
//				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(apiInfo())
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	            .paths(PathSelectors.any()).build()
				.useDefaultResponseMessages(false)
				.securitySchemes(Lists.newArrayList(new ApiKey("Authorization-Key", "X-TOKEN-AUTH", "header")))
				.securityContexts(securityContexts).apiInfo(apiInfo()).select().build();
	}

	

	private ApiInfo apiInfo() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Java 14 Application");
		apiInfoBuilder.description("Java 14 API Swagger Documentation");
		apiInfoBuilder.version("0.1");
		return apiInfoBuilder.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("OAuthKey", "X-TOKEN-AUTH", "header");
	}
}