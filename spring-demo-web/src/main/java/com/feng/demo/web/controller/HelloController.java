package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.web.aspect.AuthToken;
import com.feng.demo.web.aspect.TimeWatch;
import com.feng.demo.web.config.datasource.DynamicDataSourceContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengyadong
 * @Date: 2022/3/8 19:35
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    // 输出 hello world
    @TimeWatch
    @AuthToken
    @RequestMapping("/hello")
    public BaseVo hello() {
        DynamicDataSourceContextHolder.getContextKey();
        return BaseVo.success("Hello World!");
    }

    @RequestMapping("/hello2")
    public BaseVo hello2() {
        List<String> sss = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sss.add(null);
        }
        if (CollectionUtils.isEmpty(sss)) {
            System.out.println("aaa");
        }
        return BaseVo.success();
    }

}
