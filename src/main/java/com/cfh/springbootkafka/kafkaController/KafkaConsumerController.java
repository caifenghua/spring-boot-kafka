package com.cfh.springbootkafka.kafkaController;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @ClassName KafkaConsumerController
 * @Description: TODO
 * @Author: bughua
 * @CreateDate: 2019/9/26 16:47
 */
@Component
@Slf4j
public class KafkaConsumerController {
    @KafkaListener(topics = "TEST_TOPIC")
    public void listen(ConsumerRecord<?,?> record) {
        //判断kafka消息是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        log.info(">>>>>>>> record = " + kafkaMessage);
        if(kafkaMessage.isPresent()) {
            String topic = record.topic();
            long offset = record.offset();
            Object value = record.value();
            System.out.printf("topic = %s, offset = %d, 内容 = %s \n", topic, offset, value);
        }
    }
}
