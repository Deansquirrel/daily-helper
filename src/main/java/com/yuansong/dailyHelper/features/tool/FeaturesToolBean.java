package com.yuansong.dailyHelper.features.tool;

import com.github.deansquirrel.tools.swagger.ISwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component("FeaturesToolBean")
public class FeaturesToolBean {

    private final ISwaggerConfig swaggerConfig;

    public FeaturesToolBean(ISwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    @Bean("FeaturesToolsDocket")
    public Docket controller1Apis() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(this.swaggerConfig != null && this.swaggerConfig.getEnable() != null && this.swaggerConfig.getEnable())
                .apiInfo(this.apiInfo());

        return docket
                .groupName("02Tools")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuansong.dailyHelper.features.tool"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.swaggerConfig == null ? "Tools"
                        : this.swaggerConfig.getTitle() == null ? "Tools"
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
