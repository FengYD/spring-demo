package com.feng.demo.model.enums;

import com.feng.demo.model.dto.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author fengyadong
 * @Date: 2022/3/23 22:48
 */
@Getter
@AllArgsConstructor
public enum CustomExceptionEnum {

    ERROR(1, "ERROR", "ERROR"),;

    private Integer code;

    private String message;

    private String desc;

    public CustomExceptionEnum parseByCode(Integer code) {
        return Arrays.stream(CustomExceptionEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findAny()
                .orElse(null);
    }
}
