package com.example.blt.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;


/**
 * @author hongjian.chen
 * @date 2019/6/25 16:25
 */
public class Producer {
    public static void main(String[] args) throws MQClientException {

    }

    public static void pushMsg(String msg) {
        DefaultMQProducer producer = new DefaultMQProducer("push-group");
        producer.setNamesrvAddr("119.3.49.192:9876");
        producer.setInstanceName("rmq-push");
        try {
            producer.start();
            Message message = new Message("demo-topic-test", "test-tag", msg.getBytes());
            SendResult result = producer.send(message);
            System.out.println("result=" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}
