package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.model.domain.User;
import com.feng.demo.mysql.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @Date: 2022/3/23 23:33
 */
@RestController
@RequestMapping("/test/trans")
public class TestTransController {
    @Autowired
    private TestTransService testTransService;


    @RequestMapping("/test1")
    public BaseVo test1(Integer num) {
        User user = User.builder()
                .realName("feng")
                .userName("feng")
                .phone("1234")
                .age(22)
                .build();
        user.setUserName(user.getUserName() + num);
        user.setRealName(user.getRealName() + num);
        testTransService.addUser(user);
        return BaseVo.success();
    }
}
