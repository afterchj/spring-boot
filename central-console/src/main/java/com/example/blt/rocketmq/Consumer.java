package com.example.blt.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author hongjian.chen
 * @date 2019/6/25 16:26
 */

@Service
@RocketMQMessageListener(topic = "test_topic", consumerGroup = "my-consumer_test-topic-2")
public class Consumer implements RocketMQListener<String> {


    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onMessage(String message) {
        //JSONObject jsonObject =  JSON.parseObject(message);
        //OrderPaidEvent orderPaidEvent = JSONObject.parseObject(message, OrderPaidEvent.class);
        log.info("received message: " + message);
    }

}
