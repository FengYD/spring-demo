package com.feng.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author fengyadong
 * @Date: 2022/3/23 22:59
 */
@Getter
@AllArgsConstructor
public enum HttpRespCodeEnum {

    SUCCESS(200, "SUCCESS", "成功"),
    UNAUTH(401, "UNAUTH", "未授权"),
    ERROR(500, "ERROR", "失败"),;

    private Integer code;

    private String message;

    private String desc;

    public HttpRespCodeEnum parseByCode(Integer code) {
        return Arrays.stream(HttpRespCodeEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findAny()
                .orElse(null);
    }

}
