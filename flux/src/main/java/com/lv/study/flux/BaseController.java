package com.lv.study.flux;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(path = "base")
public class BaseController {

    @RequestMapping(method = RequestMethod.GET,path = "just")
    public Mono<String> getString(ServerHttpRequest request){
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        List<String> id = queryParams.get("id");
        Mono<String> objectMono = Mono.just(id.get(0)); // 直接返回
        return objectMono;
    }


    @RequestMapping(method = RequestMethod.GET,path = "runnable")
    public Mono<String> getString2(ServerHttpRequest request){
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        List<String> id = queryParams.get("id");
        // 无返回值
        Mono<String> objectMono = Mono.fromRunnable(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\"runnable\" = " + "runnable");
        }); // 直接返回
        System.out.println("runnable....."); // 异步执行到这，同时浏览器在等待10000ms
        return objectMono;
    }


    @RequestMapping(method = RequestMethod.GET,path = "create/{id}")
    public Mono<String> getString3(ServerHttpRequest request){

        // 无返回值
        Mono<String> objectMono = Mono.create((sink)->{
            MultiValueMap<String, String> queryParams = request.getQueryParams();
            List<String> id = queryParams.get("id");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sink.success("\"create\" = " + id.get(0));
        }); // 直接返回
        System.out.println("create....."); // 异步执行到这，同时浏览器在等待10000ms
        return objectMono;
    }
}
