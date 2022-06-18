package com.yuansong.dailyHelper.features.mqreport;

import com.github.deansquirrel.tools.swagger.ISwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component("FeatureMQReportBean")
public class FeatureMQReportBean {

    private final ISwaggerConfig swaggerConfig;

    public FeatureMQReportBean(ISwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    @Bean("FeatureMQReportDocket")
    public Docket controller1Apis() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(this.swaggerConfig != null && this.swaggerConfig.getEnable() != null && this.swaggerConfig.getEnable())
                .apiInfo(this.apiInfo());

        return docket
                .groupName("03MQReport")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuansong.dailyHelper.features.mqreport"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.swaggerConfig == null ? "MQReport"
                        : this.swaggerConfig.getTitle() == null ? "MQReport"
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
