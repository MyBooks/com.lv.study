package com.lv.study.consumer.fegin;

import com.lv.study.common.controller.ITestApiController;
import com.lv.study.common.vo.TestVO;
import org.springframework.stereotype.Component;


@Component
public class RollBack implements TestCommonService{


    public TestVO hello() {
        TestVO testVO = new TestVO();
        testVO.setTestA("OOXX");
        return testVO;
    }


    public TestVO test(TestVO testVO) {
        TestVO testVO2 = new TestVO();
        testVO2.setTestA("xxoo");
        return testVO2;
    }
}
