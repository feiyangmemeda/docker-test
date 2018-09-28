package com.example.spring5.webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

/**
 * @author feiyang.d
 * @date 2018/7/20
 */
@Component
public class UserHandler implements HandlerFunction {
    public void post(){
        System.out.println("this is post");
    }

    public void get(){
        System.out.println("this is get");
    }

    public void put(){
        System.out.println("this is put");
    }

    public void delete(){
        System.out.println("this is delete");
    }

    @Override
    public Mono handle(ServerRequest request) {
        return null;
    }
}
