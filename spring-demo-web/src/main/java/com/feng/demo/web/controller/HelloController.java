package com.feng.demo.web.controller;

import com.feng.demo.web.model.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @Date: 2022/3/8 19:35
 */
@RestController
public class HelloController {

    // 输出 hello world
    @RequestMapping("/hello")
    public BaseResponse hello(){
        return BaseResponse.success("Hello World!");
    }
}
