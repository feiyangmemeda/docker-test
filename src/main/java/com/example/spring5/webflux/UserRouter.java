package com.example.spring5.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author feiyang.d
 * @date 2018/7/20
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction route(){
        return RouterFunctions.route(GET("/user"), request -> {
            Mono<User> user = Mono.just(new User().setId(1).setName("jack"));
            return ok().body(fromPublisher(user,User.class));
        });
    }
}
