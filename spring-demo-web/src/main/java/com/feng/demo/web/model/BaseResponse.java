package com.feng.demo.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengyadong
 * @Date: 2022/3/8 19:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private Integer code;

    private String message;

    private Object data;

    public static BaseResponse success(Object data){
        return new BaseResponse(0, "success", data);
    }

    public static BaseResponse success(){
        return new BaseResponse(0, "success", "success");
    }

}
