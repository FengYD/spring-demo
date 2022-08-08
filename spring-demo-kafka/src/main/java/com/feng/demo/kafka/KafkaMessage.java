package com.feng.demo.kafka;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author fengyadong
 * @date 2022/8/8 9:50
 * @Description
 */
@Data
public class KafkaMessage {
    private Long id;
    private String message;
    private ZonedDateTime zonedDateTime;
}
