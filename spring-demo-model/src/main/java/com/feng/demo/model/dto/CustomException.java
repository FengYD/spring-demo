package com.feng.demo.model.dto;

import com.feng.demo.model.enums.CustomExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author fengyadong
 * @Date: 2022/3/23 22:44
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private Integer code;

    private String message;

    private CustomExceptionEnum customExceptionEnum;

    public CustomException(CustomExceptionEnum customExceptionEnum) {
        this.customExceptionEnum = customExceptionEnum;
        this.code = customExceptionEnum.getCode();
        this.message = customExceptionEnum.getMessage();
    }

}
