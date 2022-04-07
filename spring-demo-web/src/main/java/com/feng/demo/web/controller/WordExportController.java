package com.feng.demo.web.controller;

import com.feng.demo.model.vo.BaseVo;
import com.feng.demo.utils.word.WordGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @date 2022/4/7 11:10 上午
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/word")
public class WordExportController {

    @Autowired
    private WordGenerateService wordGenerateService;

    @RequestMapping("/export/simple")
    public BaseVo exportSimpleWord(String dest) {
        wordGenerateService.simpleWord(dest);
        return BaseVo.success();
    }

}
