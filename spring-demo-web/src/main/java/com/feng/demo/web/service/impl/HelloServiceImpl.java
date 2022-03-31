package com.feng.demo.web.service.impl;

import com.feng.demo.web.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author fengyadong001
 * @date 2022/3/11 5:14 下午
 * @description
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Async
    public void hello() {
        int count = 0;
        while (count < 10) {
            try {
                Thread.sleep(1000);
                count++;
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}