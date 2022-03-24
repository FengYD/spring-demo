package com.feng.demo.mysql.service;

import com.feng.demo.model.dto.CustomException;
import com.feng.demo.model.enums.CustomExceptionEnum;
import com.feng.demo.mysql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fengyadong001
 * @date 2022/3/24 10:35 上午
 * @description
 */
@Slf4j
@Service
public class TestTransService extends TestTransBase {

    @Override
    @Transactional
    public void addUser(User user) {
        super.addUser(user);
        long ts = System.currentTimeMillis();
        if ((ts & 1) == 1) {
            log.info("回滚，user = {}", user.getUserName());
            throw new CustomException(CustomExceptionEnum.ERROR);
        } else {
            log.info("不回滚，user = {}", user.getUserName());
        }
    }

}