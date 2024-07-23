package br.com.git.api_gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

//@Configuration
public class ApiGatewayConfig {

    /*
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        Function<PredicateSpec, Buildable<Route>> function = predicateSpec -> predicateSpec.path("/get")
                .filters(f -> f.addRequestHeader("Hellow", "World")
                        .addRequestParameter("Hellow", "World"))
                .uri("http://httpbin.org:80");
        return builder.routes()
                .route(function)
                .route(p -> p.path("/cambio-service/**").uri("lb://cambio-service"))
                .route(p -> p.path("/book-service-v2/**").uri("lb://book-service"))
                .build();
    }
    */

    /*
    Class comentada faz considerar o application.yml

     */


}
