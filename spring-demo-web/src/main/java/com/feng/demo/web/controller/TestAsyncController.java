package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @date 2022/4/2 9:15 上午
 * @Description
 */
@RestController
@RequestMapping("/test/async")
public class TestAsyncController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/async1")
    public BaseVo testAsync() {
        helloService.hello();
        return BaseVo.success("Async生效");
    }

}
