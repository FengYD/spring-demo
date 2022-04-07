package com.feng.demo.web.aspect;

import cn.hutool.core.lang.UUID;
import com.feng.demo.model.constant.ThreadLocalKey;
import com.feng.demo.model.dto.CustomException;
import com.feng.demo.model.enums.CustomExceptionEnum;
import com.feng.demo.utils.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fengyadong
 * @date 2022/4/3 9:31 下午
 * @Description
 */
@Aspect
@Component
@Slf4j
@Order(10)
public class TokenAspect {

    @Autowired
    private HttpServletRequest request;

    private static final String TOKEN = "token";

    @Pointcut("execution(public * com.feng.demo.web.controller.*.*(..)) && @annotation(com.feng.demo.web.aspect.AuthToken)")
    public void token() {
    }

    @Before("token()")
    public void authBefore() {
        ThreadLocalUtils.remove();
        String token = request.getHeader(TOKEN);
        String uri = request.getRequestURI();
        ThreadLocalUtils.set(ThreadLocalKey.URI, uri);
        ThreadLocalUtils.set(ThreadLocalKey.TOKEN, token);
        ThreadLocalUtils.set(ThreadLocalKey.TRACE_ID, UUID.fastUUID());
        log.info("traceId: {}, uri: {}, token: {}", uri, token, ThreadLocalUtils.get(ThreadLocalKey.TRACE_ID));
        if (!activeAuth(token)) {
            throw new CustomException(CustomExceptionEnum.UNAUTH);
        }
    }

    private boolean activeAuth(String token){
        return !StringUtils.isAllEmpty(token);
    }
}
