package com.lv.study.flux.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> lists1 = new ArrayList<>();
        lists1.add("吕");
        lists1.add("吕晓");
        List<Integer> collect = lists1.stream().map(MyFunction::length).collect(Collectors.toList());
        collect.forEach(System.out::println);

        MyVO myVO1 = new MyVO();
        myVO1.setNameLists(lists1);
        myVO1.setAge(12);

        List<String> lists2 = new ArrayList<>();
        lists2.add("吕");
        lists2.add("晓");
        MyVO myVO2 = new MyVO();
        myVO2.setNameLists(lists2);
        myVO2.setAge(11);

        List<String> lists3 = new ArrayList<>();
        lists3.add("张");
        lists3.add("吕晓");
        MyVO myVO3 = new MyVO();
        myVO3.setNameLists(lists3);
        myVO3.setAge(11);

        List<MyVO> myVOs = new ArrayList<>();
        myVOs.add(myVO1);
        myVOs.add(myVO2);
        myVOs.add(myVO3);

        myVOs.stream().flatMap(MyFunction::getStream).forEach(System.out::println);
        Thread.sleep(10000);
    }
}

class MyFunction{
    public static Integer length(String string) {
        return string.length();
    }

    public static Stream<String> getStream(MyVO args) {
        Stream<String> stream = args.getNameLists().stream();
        return stream;
    }
}

class MyVO{
    private List<String> nameLists;

    private Integer age;

    public List<String> getNameLists() {
        return nameLists;
    }

    public void setNameLists(List<String> nameLists) {
        this.nameLists = nameLists;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
