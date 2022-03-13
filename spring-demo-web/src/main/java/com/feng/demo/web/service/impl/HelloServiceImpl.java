package com.feng.demo.web.service.impl;

import com.feng.demo.web.service.HelloService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author fengyadong001
 * @date 2022/3/11 5:14 下午
 * @description
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Async
    public void hello() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}