package com.codamai.cms.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Set your swagger inforamtions here for better documentation.
 */
@Configuration
public class OpenApiConfiguration {
  /**
   * Info: You can add tags() here after .build() for describe service-groups
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.codamai.cms")).paths(PathSelectors.any()).build().apiInfo(getApiInfo());
  }

  /**
   * Info: You can add basic informations for your swagger here.
   */
  private ApiInfo getApiInfo() {
    return new ApiInfo("Headless CMS", "Your headless CMS","1.0.0", "https://www.codamai-cms.com/terms-of-use", new Contact("Daniel Mertins", "https://www.codamic.com", "dm@codamic.com"), "CMS License", "https://www.codamai-cms.com/license/",
        Collections.emptyList());
  }
}
