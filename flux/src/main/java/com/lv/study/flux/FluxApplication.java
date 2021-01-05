package com.lv.study.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class FluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(FluxApplication.class, args);
    }


}
