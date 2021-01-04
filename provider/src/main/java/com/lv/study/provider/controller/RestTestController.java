package com.lv.study.provider.controller;

import com.lv.study.provider.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

@RestController
@RequestMapping("restTest")
public class RestTestController{


    @RequestMapping(method = RequestMethod.GET,path = "object")
    public Object getObject(){
        UserVO userVO = new UserVO();
        userVO.setName("123");
        userVO.setPassword("test");
        return "{\"test\":1,\"abc\":\"efgh\"}";
    }

    @RequestMapping(method = RequestMethod.GET,path = "object2")
    public Object getObject2(String name){
        return "{\"name\":1,\""+name+"\":\"efgh\"}";
    }
}
