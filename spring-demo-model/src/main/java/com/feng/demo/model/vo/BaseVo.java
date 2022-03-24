package com.feng.demo.model.vo;

import com.feng.demo.model.enums.HttpRespCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengyadong
 * @Date: 2022/3/23 22:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseVo {

    private Integer code;

    private String message;

    private Object data;

    public static BaseVo success(){
        return success(HttpRespCodeEnum.SUCCESS);
    }

    public static BaseVo success(HttpRespCodeEnum httpRespCodeEnum){
        return success(httpRespCodeEnum.getCode(), httpRespCodeEnum.getMessage(), null);
    }

    public static BaseVo success(Object data){
        return success(HttpRespCodeEnum.SUCCESS.getCode(), HttpRespCodeEnum.SUCCESS.getMessage(), data);
    }

    public static BaseVo success(Integer code, String message, Object data) {
        return new BaseVo(code, message, data);
    }

    public static BaseVo fail(){
        return fail(HttpRespCodeEnum.ERROR);
    }

    public static BaseVo fail(HttpRespCodeEnum httpRespCodeEnum){
        return fail(httpRespCodeEnum.getCode(), httpRespCodeEnum.getMessage(), null);
    }

    public static BaseVo fail(Object data){
        return fail(HttpRespCodeEnum.ERROR.getCode(), HttpRespCodeEnum.ERROR.getMessage(), data);
    }

    public static BaseVo fail(Integer code, String message, Object data) {
        return new BaseVo(code, message, data);
    }
}
