package com.lv.study.flux.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Demo2Controller {

    public Mono<ServerResponse> get1(ServerRequest request){
        return ServerResponse.ok().body(BodyInserters.fromValue("Hello World"));
    }
}
