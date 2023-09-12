package com.shamstabrez16.studentmanagementsystem.service;

import com.shamstabrez16.studentmanagementsystem.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, TestUser> kafkaJsonTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, TestUser> kafkaJsonTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaJsonTemplate = kafkaJsonTemplate;
    }

    public void sendString(String data) {
        kafkaTemplate.send("java_in_use_topic", data);
    }

    public void sendJson(TestUser data) {
        kafkaJsonTemplate.send("json_in_use_topic", data);
    }
}
