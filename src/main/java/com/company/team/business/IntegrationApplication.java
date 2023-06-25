package com.company.team.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class IntegrationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IntegrationApplication.class, args);
        printSwaggerUIAndApiDocsUrl(context);
    }

    private static void printSwaggerUIAndApiDocsUrl(ConfigurableApplicationContext context) {
        ConfigurableEnvironment env = context.getEnvironment();
        String port = env.getProperty("server.port", "8080");
        String contextPath = env.getProperty("server.servlet.context-path", "");
        String swaggerUIPath = env.getProperty("springdoc.swagger-ui.path", "/swagger-ui.html");
        log.info("swagger-ui url: http://localhost:{}{}{}", port, contextPath, swaggerUIPath);
    }

}
