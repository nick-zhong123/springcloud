package com.nick.springcloud.rabbitmq.service.impl;

import com.nick.springcloud.rabbitmq.service.ReceiveService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReceiveServiceImpl implements ReceiveService {

    @Resource
    AmqpTemplate amqpTemplate;

    /**
     * 每运行一次只能接收一条消息
     */
    @Override
    public void receiveMessage() {
        Object obj = amqpTemplate.receiveAndConvert("bootDirectQueue");
        String message = String.valueOf(obj);
        System.out.println("message:" + message);
    }

    @RabbitListener(queues = {"bootDirectQueue"})
    @Override
    public void directReceive(String message) {
        System.out.println("message:" + message);
    }

}
