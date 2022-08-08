package com.feng.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.demo.es7.AreaIndex;
import com.feng.demo.es7.ESIndex;
import com.feng.demo.es7.ESRecord;
import com.feng.demo.model.domain.Area;
import com.feng.demo.mysql.mapper.AreaMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fengyadong
 * @date 2022/8/8 13:46
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/es7")
public class ESController {

    @Resource
    private AreaMapper areaMapper;

    @Autowired
    private ESRecord esRecord;

    @Autowired
    private ESIndex esIndex;


    @RequestMapping("/deleteIndex")
    public void deleteIndex() {
        esIndex.dropIndex(AreaIndex.class);
    }

    @RequestMapping("/createIndex")
    public void createIndex() {
        esIndex.createIndex(AreaIndex.class);
    }

    @RequestMapping("/syncArea")
    public void syncArea() {
        List<Area> allArea = areaMapper.selectList(new QueryWrapper<>());
        for (Area area : allArea) {
            AreaIndex areaIndex = JSON.parseObject(JSON.toJSONString(area), AreaIndex.class);
            esRecord.addRecord(areaIndex);
        }
    }

}
