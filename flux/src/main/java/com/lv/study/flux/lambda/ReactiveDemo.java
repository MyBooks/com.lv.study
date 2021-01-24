package com.lv.study.flux.lambda;



public class ReactiveDemo {
    public static void main(String[] args) throws InterruptedException {
//        SubmissionPublisher publisher = new SubmissionPublisher(); //  创建生产者1.9后java才有的类
//        Subscriber subscriber = new Subscriber() {
//            private Subscription subscription;
//
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                this.subscription = subscription;
//                subscription.request(1); // 可以需要一个
//            }
//
//            @Override
//            // 处理数据的过程
//            public void onNext(Object item) {
//                System.out.println("item = " + item);
//                subscription.request(1);
//            }
//
//            @Override
//            // 异常时
//            public void onError(Throwable throwable) {
//
//            }
//
//            @Override
//            // 完成后
//            public void onComplete() {
//                System.out.println("By~By~");
//            }
//        };
//
//        publisher.subscribe(subscriber); // 消费者订阅生产者
//        publisher.submit("hello_world"); // 生产者产生数据
//        publisher.close(); // 生产结束
        Thread.sleep(100000);
        //publisher.close();
    }
}
