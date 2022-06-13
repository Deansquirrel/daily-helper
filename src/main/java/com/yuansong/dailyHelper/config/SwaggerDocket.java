package com.yuansong.dailyHelper.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerDocket {

    private final Docket docket;

    public SwaggerDocket(@Qualifier("createAdminRestApi") Docket docket) {
        this.docket = docket;

        docket.groupName("01Action");

//        //为swagger中的请求增加token选项
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("token").description("token")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        pars.add(tokenPar.build());
//
//        docket.globalOperationParameters(pars);

    }
}
