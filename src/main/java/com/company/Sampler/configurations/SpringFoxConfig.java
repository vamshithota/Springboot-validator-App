package com.company.Sampler.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	
	  @Bean 
	  public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2).groupName("Spring Boot App")
			  .apiInfo(apiInfo())
	  .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	  .build();
		  }
	  private ApiInfo apiInfo() {
		  return new
				  ApiInfoBuilder().title("SpringBoot API")
				  .description("Sampler API reference for developers")
				  .termsOfServiceUrl("http://java.com")
				  .contact("vamshi.thota4@gmail.com").license("User License")
				  .licenseUrl("vamshi.thota4@gmail.com").version("1.0").build(); 
	  }
				 

	/*
	 * @Bean public Docket postsApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).groupName("public-api")
	 * .apiInfo(apiInfo()).select().paths(postPaths()).build(); }
	 * 
	 * private Predicate<String> postPaths() { return or(regex("/*"),
	 * regex("/api/*")); }
	 * 
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("JavaInUse API")
	 * .description("JavaInUse API reference for developers")
	 * .termsOfServiceUrl("http://javainuse.com")
	 * .contact("javainuse@gmail.com").license("JavaInUse License")
	 * .licenseUrl("javainuse@gmail.com").version("1.0").build(); }
	 */
	
	
}
