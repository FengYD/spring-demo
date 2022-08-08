package com.feng.demo.web.controller;

import com.feng.demo.kafka.KafkaMessage;
import com.feng.demo.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * @author fengyadong
 * @date 2022/8/8 10:34
 * @Description
 */
@Slf4j
@RequestMapping("/kafka")
@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send/topic1")
    public void sendKafkaMessage(String message) {
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(System.currentTimeMillis());
        kafkaMessage.setMessage(message);
        kafkaMessage.setZonedDateTime(ZonedDateTime.now());
        kafkaProducer.sendMessage(kafkaMessage);
        log.info("kafka send message, {}", message);
    }

}
