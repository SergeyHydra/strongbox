package org.carlspring.strongbox.config;

import java.util.Collections;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    @Value("${strongbox.version}")
    public String strongboxVersion;

    @Bean
    public Docket strongboxApiDocket()
    {
        Contact contact = new Contact("Strongbox",
                                      "http://github.com/strongbox/strongbox/",
                                      "strongbox-dev@carlspring.com");
        ApiInfo apiInfo = new ApiInfo("Carlspring Consulting &amp; Development Ltd.",
                                      "This is the documentation of Strongbox's REST API.",
                                      strongboxVersion,
                                      "http://github.com/strongbox/strongbox/",
                                      contact,
                                      "Apache 2.0",
                                      "http://www.apache.org/licenses/LICENSE-2.0.html",
                                      Collections.EMPTY_LIST);
        
        return new Docket(DocumentationType.SWAGGER_2).protocols(Sets.newHashSet("http", "https"))
                                                      .host("carlspring.org")
                                                      .pathMapping("/strongbox")
                                                      .apiInfo(apiInfo);
    }

    @Bean
    public UiConfiguration uiConfiguration()
    {
        return UiConfigurationBuilder.builder().build();
    }
    
}
