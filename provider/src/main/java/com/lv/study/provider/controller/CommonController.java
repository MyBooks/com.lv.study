package com.lv.study.provider.controller;

import com.lv.study.common.controller.ITestApiController;
import com.lv.study.common.vo.TestVO;
import com.lv.study.provider.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("common")
public class CommonController implements ITestApiController {

    @Override
    public TestVO hello() {
        TestVO testVO = new TestVO();
        return testVO;
    }

    @Override
    public TestVO test(TestVO testVO) {
        int test = 1/0;
        return testVO;
    }
}
