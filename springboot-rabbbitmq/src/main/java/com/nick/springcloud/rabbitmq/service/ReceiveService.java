package com.nick.springcloud.rabbitmq.service;

public interface ReceiveService {

    void receiveMessage();

    void directReceive(String message);

}
