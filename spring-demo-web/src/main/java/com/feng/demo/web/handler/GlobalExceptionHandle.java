package com.feng.demo.web.handler;

import com.feng.demo.model.dto.CustomException;
import com.feng.demo.model.enums.HttpRespCodeEnum;
import com.feng.demo.model.vo.BaseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fengyadong
 * @date 2022/4/3 8:52 下午
 * @Description
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseVo exceptionHandler(Exception e, HttpRequest request) {
        recordErrorLog(e, request);
        return BaseVo.fail(HttpRespCodeEnum.ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public BaseVo customExceptionHandler(CustomException e, HttpRequest request) {
        recordErrorLog(e, request);
        return BaseVo.fail(e);
    }

    private void recordErrorLog(Exception e, HttpRequest request) {
        log.error("请求出现异常, 请求路径: {}, 错误信息: {}", request.getURI().getRawPath(), e.getMessage());
    }

}
