package com.lv.study.flux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@RestController
@RequestMapping("demo1")
public class Demo1Controller {

    @RequestMapping(path = "get1",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> get1(){
        return Flux.create(sink->{
            Stream.of("Hello World","你好 世界","こんにちは、世界").forEach(str->{
                try {
                    Thread.sleep(3000);
                    sink.next(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            sink.complete();
        });
    }
}
