package com.lv.study.flux;

import com.lv.study.flux.controller.Demo2Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.security.PublicKey;

@SpringBootApplication
@EnableDiscoveryClient
public class FluxApplication {

    private Demo2Controller demo2Controller;

    public FluxApplication(Demo2Controller demo2Controller){
         this.demo2Controller = demo2Controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(FluxApplication.class, args);
    }

    @Bean
    public RouterFunction routerFunction(){
        return RouterFunctions.route(RequestPredicates.path("/get1"),demo2Controller::get1);

    }


}
