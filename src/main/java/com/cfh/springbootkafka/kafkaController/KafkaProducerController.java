package com.cfh.springbootkafka.kafkaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName KafkaProducerController
 * @Description: TODO
 * @Author: bughua
 * @CreateDate: 2019/9/26 16:47
 */
@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //访问：localhost:8080/kafka/send?msg=hello(消息)

    @RequestMapping("/send")
    public String send(String msg) {
        // 消息的主题 TEST_TOPIC
        kafkaTemplate.send("TEST_TOPIC", msg);
        return "success";
    }

    //通过页面测试
    @RequestMapping("/test")
    public String helloKafka(){
        return "测试页面";
    }
}
