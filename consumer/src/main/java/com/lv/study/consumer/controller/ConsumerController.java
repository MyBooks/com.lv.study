package com.lv.study.consumer.controller;

import com.lv.study.common.vo.TestVO;
import com.lv.study.consumer.fegin.TestCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private TestCommonService testCommonService;

    @RequestMapping(method = RequestMethod.GET,path = "test")
    public TestVO test(){
        // Map<String, String> stringStringMap = Collections.singletonMap("name", "lvtest");
        // Map<String,Object> forObject = restTemplate.getForObject("http://provider/restTest/object2?name={name}", Map.class,stringStringMap);
        return testCommonService.hello();
    }

    @RequestMapping(method = RequestMethod.GET,path = "test2")
    public TestVO test2(){
        TestVO testVO = new TestVO();
        testVO.setTestA("1");
        testVO.setTestB("2");
        return testCommonService.test(testVO);
    }


}
