package com.lv.study.consumer.fegin;


import com.lv.study.common.vo.TestVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(value="provider",fallback = RollBack.class)
public interface TestCommonService {

    @RequestMapping(method = RequestMethod.POST,path = "hi")
    public TestVO hello();

    @RequestMapping(method = RequestMethod.POST,path = "test")
    public TestVO test(@RequestBody() TestVO testVO);
}
