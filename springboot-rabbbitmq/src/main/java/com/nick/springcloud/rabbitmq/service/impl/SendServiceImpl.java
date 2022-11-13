package com.nick.springcloud.rabbitmq.service.impl;

import com.nick.springcloud.rabbitmq.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SendServiceImpl implements SendService {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("bootDirectExchange", "bootDirectRoutingKey", message);
    }





}
