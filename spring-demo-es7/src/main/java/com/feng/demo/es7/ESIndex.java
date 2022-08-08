package com.feng.demo.es7;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.stereotype.Component;

/**
 * @author fengyadong
 * @date 2022/8/8 11:49
 * @Description
 */
@Slf4j
@Component
public class ESIndex {

    @Autowired
    private ElasticsearchRestTemplate template;

    public Document createIndex(Class clazz) {
        Document document = template.indexOps(clazz).createMapping(clazz);
        return document;
    }

    public boolean dropIndex(Class clazz) {
        return template.indexOps(clazz).delete();
    }
}
