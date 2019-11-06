package com.test.jms.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @description: Kafka生产者
 * <br>
 * @date: 2019/10/16 15:40
 * @since: JDK 1.8
 */
@Service
public class KafkaProducer
{
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.topic-name}")
    private String defaultTopic;

    /**
     * 发送消息
     *
     * @param msg
     */
    public void send(String msg)
    {
        String topic = defaultTopic;
        LOGGER.info("current default topic:{}", topic);
        this.send(topic, msg);
    }

    /**
     * 发送带Topic的消息
     *
     * @param topic
     * @param msg
     */
    public void send(String topic, String msg)
    {
        LOGGER.info("current topic:{},msg:{}", topic, msg);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>()
        {
            @Override
            public void onFailure(Throwable ex)
            {
                LOGGER.error("failed to send [{}] msg:{}.", topic, msg, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result)
            {
                LOGGER.info("send jms msg success:{}", result);
            }
        });
    }

    private static Logger LOGGER = LogManager.getLogger(KafkaProducer.class);
}