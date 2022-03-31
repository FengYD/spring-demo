package com.feng.demo.utils;

import com.feng.demo.model.dto.CustomException;
import com.feng.demo.model.dto.LoginUserDTO;
import com.feng.demo.model.enums.CustomExceptionEnum;
import com.feng.demo.model.enums.HttpRespCodeEnum;

import java.util.Optional;

/**
 * @author fengyadong
 * @Date: 2022/3/31 21:40
 */
public class ThreadLocalUtils {

    private static InheritableThreadLocal<LoginUserDTO> loginUserLocal = new InheritableThreadLocal<>();

    /**
     * 清除
     */
    public static void clear() {
        loginUserLocal.remove();
    }

    /**
     * set信息
     * @param loginUser 登录用户信息
     */
    public static void setLoginUserLocal(LoginUserDTO loginUser) {
        LoginUserDTO loginUserDTO = LoginUserDTO.builder()
                .userId(loginUser.getUserId())
                .userName(loginUser.getUserName())
                .token(loginUser.getToken())
                .loginTime(loginUser.getLoginTime())
                .build();
        loginUserLocal.set(loginUserDTO);
    }

    /**
     * 返回userId
     * @return userId 用户id
     */
    public static Long getUserId() {
        return Optional.ofNullable(loginUserLocal.get().getUserId())
                .orElseThrow(() -> new CustomException(CustomExceptionEnum.UNAUTH));
    }

    /**
     * 返回userInfo
     * @return UserInfo
     */
    public static LoginUserDTO getUserInfo() {
        return Optional.ofNullable(loginUserLocal.get())
                .orElseThrow(() -> new CustomException(CustomExceptionEnum.UNAUTH));
    }

}
