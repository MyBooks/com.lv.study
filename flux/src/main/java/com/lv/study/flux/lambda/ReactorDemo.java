package com.lv.study.flux.lambda;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

public class ReactorDemo {
    public static void main(String[] args) {
//        Flux.generate(()->0,(flag,sink)->{
//            if(flag == 1) sink.complete();
//            sink.next("hello_world");
//            return ++flag;}).subscribe(System.out::println);

        Flux<Object> flux = Flux.generate(AtomicLong::new, (stats, sink) -> {
            Long i = stats.incrementAndGet();
            if (i == 5) sink.complete();
            else sink.next("hello world" + i); // 如果在完成前还有next则会产生一个抛弃的数据
            return stats;
        }, System.out::println);

        flux.subscribe(new MySubscriber()); // 被压模式

        Flux<Object> flux2 = Flux.create(fluxSink -> {
            fluxSink.next(1);

            fluxSink.complete();
        });

        flux2.subscribe(new MySubscriber());



    }
}
class MySubscriber extends BaseSubscriber{
    private Subscription subscription;
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("订阅了");
//        this.subscription.request(5);
        this.requestUnbounded(); //获取最大值
    }

    @Override
    protected void hookOnNext(Object value) {
        System.out.println("value = " + value);
        //this.subscription.request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("完成了");
    }
}
