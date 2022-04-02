package com.feng.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author fengyadong
 * @date 2022/4/2 5:01 下午
 * @Description
 */
@Getter
@AllArgsConstructor
public enum YesNoEnum {
    YES(1, "YES", "是"),
    NO(0, "MO", "否");

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
