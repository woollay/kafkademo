package com.test.jms.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @description: Kafka消费者
 * <br>
 * @date: 2019/10/24 16:20
 * @since: JDK 1.8
 */
@Service
public class KafkaConsumer
{
    @KafkaListener(topics = {"test-topic"}, groupId = "test-group")
    public void process(ConsumerRecord<String, String> msg)
    {
        LOGGER.info("receive msg:{}", msg.value());
    }

    private static final Logger LOGGER = LogManager.getLogger(KafkaConsumer.class);
}