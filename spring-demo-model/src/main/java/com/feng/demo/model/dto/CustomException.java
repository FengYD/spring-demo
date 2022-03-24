package com.feng.demo.model.dto;

import com.feng.demo.model.enums.CustomExceptionEnum;
import lombok.*;

/**
 * @author fengyadong
 * @Date: 2022/3/23 22:44
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private Integer code;

    private String message;

    public CustomException(CustomExceptionEnum customExceptionEnum) {
        this.code = customExceptionEnum.getCode();
        this.message = customExceptionEnum.getMessage();
    }

}
