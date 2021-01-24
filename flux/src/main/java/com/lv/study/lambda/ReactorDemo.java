package com.lv.study.lambda;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

public class ReactorDemo {
    public static void main(String[] args) {
//        Flux.generate(()->0,(flag,sink)->{
//            if(flag == 1) sink.complete();
//            sink.next("hello_world");
//            return ++flag;}).subscribe(System.out::println);

        Flux.generate(AtomicLong::new,(stats,sink)->{
            Long i = stats.incrementAndGet();
            if(i == 5) sink.complete();
            sink.next("hello world"+i);
            return stats;
        },System.out::println).subscribe(System.out::println);

    }
}
