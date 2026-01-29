package com.kyobo.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiVersionConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        // api 관리를 위해 특정 경로에  prefix로 api 버전을 붙이도록 명시함.
        configurer.addPathPrefix(
                "/api/v1",
                HandlerTypePredicate.forBasePackage("limecoding.onlinebookstore.api.v1"));

        configurer.addPathPrefix(
                "/api/v2",
                HandlerTypePredicate.forBasePackage("limecoding.onlinebookstore.api.v2"));
    }
}
