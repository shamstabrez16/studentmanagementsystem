package com.shamstabrez16.studentmanagementsystem.config.controller;


import com.shamstabrez16.studentmanagementsystem.model.TestUser;
import com.shamstabrez16.studentmanagementsystem.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaSender.sendString(message);

        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }
    @GetMapping(value = "/producer2")
    public String producer2(@RequestBody TestUser message) {
        kafkaSender.sendJson(message);

        return "Json Message sent to the Kafka Topic java_in_use_topic Successfully";
    }
}
