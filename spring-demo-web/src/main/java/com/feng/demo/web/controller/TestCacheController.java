package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.mysql.service.TestCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @date 2022/8/24 15:06
 * @Description
 */
@RestController
@RequestMapping("/test/cache")
public class TestCacheController {

    @Autowired
    private TestCache testCache;

    @RequestMapping("/test")
    public BaseVo test() {
        testCache.test();
        testCache.test2();
        return BaseVo.success();
    }
}
