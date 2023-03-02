package com.feng.demo.web.aspect;

import com.feng.demo.model.constant.ThreadLocalKey;
import com.feng.demo.utils.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fengyadong
 * @Date: 2022/4/6 22:12
 */
@Aspect
@Component
@Slf4j
@Order(11)
public class WatchAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("execution(public * com.feng.demo.web.controller.*.*(..)) && @annotation(com.feng.demo.web.aspect.TimeWatch)")
    public void watch() {
    }

    @Before("watch()")
    public void cutBefore() {
        ThreadLocalUtils.set(ThreadLocalKey.START_TIME, System.nanoTime());
        String uri = httpServletRequest.getRequestURI();
        ThreadLocalUtils.set(ThreadLocalKey.URI, uri);
        log.info("traceId: {}, uri: {}, start: {}", ThreadLocalUtils.get(ThreadLocalKey.TRACE_ID),
                uri, ThreadLocalUtils.get(ThreadLocalKey.START_TIME));
    }

    @After("watch()")
    public void cutAfter() {
        ThreadLocalUtils.set(ThreadLocalKey.END_TIME, System.nanoTime());
        long costTime = (long)ThreadLocalUtils.get(ThreadLocalKey.END_TIME) -
                (long)ThreadLocalUtils.get(ThreadLocalKey.START_TIME);
        ThreadLocalUtils.set(ThreadLocalKey.COST_TIME, costTime);
        log.info("traceId: {}, uri: {}, start: {}, end: {}, cost: {}",ThreadLocalUtils.get(ThreadLocalKey.TRACE_ID),
                ThreadLocalUtils.get(ThreadLocalKey.URI),ThreadLocalUtils.get(ThreadLocalKey.START_TIME),
                ThreadLocalUtils.get(ThreadLocalKey.END_TIME), costTime);
    }
}
