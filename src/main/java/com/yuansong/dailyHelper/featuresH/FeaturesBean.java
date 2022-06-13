package com.yuansong.dailyHelper.featuresH;

import com.github.deansquirrel.tools.swagger.ISwaggerConfig;
import com.github.deansquirrel.tools.swagger.SwaggerBean;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class FeaturesBean {

    private final ISwaggerConfig swaggerConfig;

    public FeaturesBean(ISwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    @Bean("Features")
    public Docket controller1Apis() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(this.swaggerConfig != null && this.swaggerConfig.getEnable() != null && this.swaggerConfig.getEnable())
                .apiInfo(this.apiInfo());

        return docket
                .groupName("99Temp")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuansong.dailyHelper.features"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.swaggerConfig == null ? "Feature"
                        : this.swaggerConfig.getTitle() == null ? "Feature"
                        : this.swaggerConfig.getTitle())
                .description(this.swaggerConfig == null ? ""
                        : this.swaggerConfig.getDescription() == null ? ""
                        : this.swaggerConfig.getDescription())
                .version(this.swaggerConfig == null ? ""
                        : this.swaggerConfig.getVersion() == null ? ""
                        : this.swaggerConfig.getVersion())
                .build();
    }
}
