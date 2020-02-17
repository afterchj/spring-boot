package com.example.blt.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

/**
 * Created by after on 2019/7/1.
 */

@Component
public class ConsumerDemo {
    /**
     * 消费者
     */
    @Value("${rocketmq.producer.group}")
    private String pushConsumer;

    /**
     * NameServer 地址
     */
    @Value("${rocketmq.name-server}")
    private String namesrvAddr;
    private DefaultMQPushConsumer consumer;

    @PostConstruct
    public DefaultMQPushConsumer buildConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(pushConsumer);
        consumer.setNamesrvAddr(namesrvAddr);
        // 设置消费地点,从最后一个进行消费(其实就是消费策略)
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe("blt_remote_topic", "*");
        // 注册监听器
        consumer.registerMessageListener((MessageListenerConcurrently)
                (msgs, context) -> {
                    try {
                        // 获取Message
                        Message msg = msgs.get(0);
                        System.out.printf("%s Receive New Messages: %s %n",
                                Thread.currentThread().getName(), new String(msgs.get(0).getBody()));
                        String topic = msg.getTopic();
                        String body = new String(msg.getBody(), "utf-8");
                        // 标签
                        String tags = msg.getTags();
                        String keys = msg.getKeys();
                        System.out.println("topic=" + topic + ", tags=" + tags + ",keys=" + keys + ", msg=" + body);
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                });
        consumer.start();
        System.out.println("Consumer Listener");
        return consumer;
    }

    public void consumer() throws MQClientException {

    }
}
