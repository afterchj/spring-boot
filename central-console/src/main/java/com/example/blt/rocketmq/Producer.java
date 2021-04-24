package com.example.blt.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
 * @author hongjian.chen
 * @date 2019/6/25 16:25
 */
public class Producer {
    public static void main(String[] args) throws MQClientException {
        for(int i=0;i<100;i++){
            pushMsg("Test times "+ LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        }
    }

    public static void pushMsg(String msg) {
        DefaultMQProducer producer = new DefaultMQProducer("push-group");
        producer.setNamesrvAddr("172.26.171.218:9876");
        producer.setInstanceName("rmq-push");
        try {
            producer.start();
            Message message = new Message("test_topic", "test_tag", msg.getBytes());
            SendResult result = producer.send(message);
//            System.out.println("result=" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }
    }
}
