package com.test.jms.controller;

import com.test.jms.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 生产者Controller
 * <br>
 * @date: 2019/10/24 14:01
 * @since: JDK 1.8
 */
@RestController
public class ProducerController
{
    @Autowired
    private KafkaProducer producerService;

    @GetMapping("/kafka/send")
    @ResponseBody
    public String send(String aaa)
    {
        producerService.send(aaa);
        return "ok";
    }
}