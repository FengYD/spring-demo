package com.feng.demo.es7;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

/**
 * @author fengyadong
 * @date 2022/8/8 11:58
 * @Description
 */
@Slf4j
@Component
public class ESRecord {

    @Autowired
    private ElasticsearchRestTemplate template;

    public void addRecord(AreaIndex areaIndex) {
        template.save(areaIndex);
    }

}
