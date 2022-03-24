package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.mysql.domain.User;

/**
 * @author fengyadong
 * @Date: 2022/3/23 23:33
 */
//@RestController("/test/trans")
public class TestTransController {
    //@Autowired


    //@RequestMapping("/test1")
    public BaseVo test1(Integer num){
        User user = User.builder()
                .realName("feng")
                .userName("feng")
                .phone("1234")
                .age(22)
                .build();
        user.setUserName(user.getUserName() + num);
        user.setRealName(user.getRealName() + num);
        //testTransService.addUser(user);
        return BaseVo.success();
    }
}
