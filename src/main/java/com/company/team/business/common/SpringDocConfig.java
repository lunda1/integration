package com.company.team.business.common;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * 集成OpenAPI信息到swagger页面
 */
@Configuration
@Slf4j
public class SpringDocConfig {
    @Bean
    public OpenAPI openApi(ObjectProvider<BuildProperties> buildProperties) {
        OpenAPI openAPI = new OpenAPI();
        // 基本信息
        openAPI.info(new Info().title("integration")
                .description("integration 集成服务")
                .version(Optional.ofNullable(buildProperties.getIfAvailable()).map(BuildProperties::getVersion).orElse("1.0.1")));
        return openAPI;
    }
}
