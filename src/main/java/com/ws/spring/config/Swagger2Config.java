package com.ws.spring.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg
 * 
 * @author admin
 *
 */
@Configuration
@EnableSwagger2
@Profile({ "local", "dev", "stage", "prod" })
public class Swagger2Config {

	@Bean
	public Docket eDesignApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiEndPointsInfo()).enable(Boolean.TRUE).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(Boolean.FALSE).enableUrlTemplating(Boolean.FALSE);
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().deepLinking(Boolean.TRUE).displayOperationId(Boolean.FALSE)
				.defaultModelsExpandDepth(1).defaultModelExpandDepth(1).defaultModelRendering(ModelRendering.EXAMPLE)
				.displayRequestDuration(Boolean.FALSE).docExpansion(DocExpansion.NONE).filter(Boolean.FALSE)
				.maxDisplayedTags(0).operationsSorter(OperationsSorter.ALPHA).showExtensions(Boolean.FALSE)
				.tagsSorter(TagsSorter.ALPHA).supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
				.validatorUrl(null).build();
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Mobiledog app REST API").description("User Management REST API")
				.termsOfServiceUrl("https://mobiledog.in")
				.contact(new Contact("Ramesh Patil", "www.mobiledog.in", "supporttest@mobiledog.in"))
				.license("walkinsoftware.in").licenseUrl("www.walkinsoftware.in").version("1.0.0").build();
	}

}
