package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * kafka微服务
 */
@SpringBootApplication
@EnableKafka
public class KafkaApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
