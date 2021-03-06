package com.chj.tpadsz.rabbitmq;/**
 * @Description: Created by xpl on 2018-04-26 21:47.
 */

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by xpl on 2018-04-26 21:47
 **/

public class Consumer1 {

    private static final String EXCHANGE_NAME = "test_exchange_topic";

    private static final String QUEUE_NAME = "test_queue_topic_1";

    /**
     * 绑定队列到交换机（这个交换机名称一定要和生产者的交换机名相同）
     * 参数1：队列名
     * 参数2：交换机名
     * 参数3：Routing key 路由键
     */
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //order.#
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "order.*");

        channel.basicQos(1);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body, "UTF-8"));
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}
