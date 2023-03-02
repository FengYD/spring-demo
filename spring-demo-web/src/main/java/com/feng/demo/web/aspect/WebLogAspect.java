package com.feng.demo.web.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fengyadong
 * @date 2023/2/9 17:04
 * @Description
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Autowired
    ObjectMapper om;

    @Around("(execution(public * com.feng.demo.web.controller..*.*(..)))")
    public Object webTrace(ProceedingJoinPoint pjd) throws Throwable {
        log.info("METHOD:{}, PARAMETERS:{}", pjd.getSignature(), pjd.getArgs());
        Object ret = pjd.proceed();
        try {
            log.debug("RESPONSE:{} ", om.writeValueAsString(ret));
        } catch (Exception ignored) {
        }
        return ret;
    }
}
