package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @Date: 2022/3/8 19:35
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    // 输出 hello world
    @RequestMapping("/hello")
    public BaseVo hello() {
        return BaseVo.success("Hello World!");
    }

    @RequestMapping("/async")
    public BaseVo testAsync() {
        helloService.hello();
        return BaseVo.success("Async生效");
    }
}
