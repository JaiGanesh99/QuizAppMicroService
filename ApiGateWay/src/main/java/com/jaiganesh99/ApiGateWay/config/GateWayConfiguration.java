package com.jaiganesh99.ApiGateWay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("question-service", r -> r.path("/question/**")
                .uri("lb://QuestionMainMicroService"))
            .route("quiz-service", r -> r.path("/quiz/**")
                .uri("lb://QuizMainMicroService"))
            .build();
    }
    
}

