package com.feng.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author fengyadong
 * @date 2022/8/8 10:20
 * @Description
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(id = "consumer1", topics = "topic1", groupId = "group1")
    public void obtainMessage(ConsumerRecord<String, String> consumerRecord) {

        String key = consumerRecord.key();
        String value = consumerRecord.value();
        int partition = consumerRecord.partition();
        long timestamp = consumerRecord.timestamp();
        String topic = consumerRecord.topic();
        log.info("key: " + key + "\n" + "value: " + value + "\n" + "partition: " + partition + "\n" + "timestamp: " + timestamp + "\n" + "topic: " + topic);
    }

}
