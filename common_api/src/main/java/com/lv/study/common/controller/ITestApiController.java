package com.lv.study.common.controller;

import com.lv.study.common.vo.TestVO;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("common")
public interface ITestApiController {

    @RequestMapping(method = RequestMethod.POST,path = "hi")
    public TestVO hello();

    @RequestMapping(method = RequestMethod.POST,path = "test")
    public TestVO test(@RequestBody() TestVO testVO);
}
