package com.feng.demo.kafka;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author fengyadong
 * @date 2022/8/8 9:51
 * @Description
 */
@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(KafkaMessage kafkaMessage) {
        this.kafkaTemplate.send("topic1", JSON.toJSONString(kafkaMessage));
    }

}
